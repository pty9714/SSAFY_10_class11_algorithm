from collections import deque
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

# 입력
R, C = map(int, input().split())
graph = [[0 for _ in range(C)] for _ in range(R)]
for i in range(R):
    graph[i] = list(map(int, input().split()))

def bfs(r, c, target):
    q = deque()
    result = [] # 영역 구하기
    q.append([r, c])
    visited[r][c] = True

    while q:
        curRow, curCol = q.popleft()
        if [curRow, curCol] not in result:
            result.append([curRow, curCol])
        for k in range(4):
            nextRow, nextCol = curRow+dx[k], curCol+dy[k]
            if nextRow < 0 or nextRow > R-1 or nextCol < 0 or nextCol > C-1:
                continue
            if not visited[nextRow][nextCol] and graph[nextRow][nextCol] == target:
                q.append([nextRow, nextCol])
                visited[nextRow][nextCol] = True
    return result


# 테두리 따는 로직
def getBorderLine(r, c):
    for k in range(4):
        nextRow, nextCol = r + dx[k], c + dy[k]
        if nextRow < 0 or nextRow > R - 1 or nextCol < 0 or nextCol > C - 1:
            continue
        if graph[nextRow][nextCol] == 0:
            return True
    return False


count = 0
answer = 0


# 모두 녹아 없어졌는지 확인
def allZeros():
    cnt = 0
    for i in range(R):
        for j in range(C):
            if graph[i][j] == 0:
                cnt += 1
    if cnt == R*C:
        return True
    return False


while True:
    # 외부 공기 영역 구하기
    visited = [[False for _ in range(C)] for _ in range(R)]
    outside = bfs(0, 0, 0)

    # 내부 영역 판단
    inside = []
    for i in range(R):
        for j in range(C):
            if graph[i][j] == 0 and not visited[i][j]:
                inside.append([i,j])

    # 내부 영역 2로 변환
    for ir, ic in inside:
        graph[ir][ic] = 2

    # 테두리 영역 따기
    borders = []
    for i in range(R):
        for j in range(C):
            if graph[i][j] == 1 and getBorderLine(i, j):
                borders.append([i,j])

    answer = len(borders)

    # 테두리 녹이기
    for itemR, itemC in borders:
        graph[itemR][itemC] = 0

    # 내부 다시 0으로 돌려놓기
    for ir, ic in inside:
        graph[ir][ic] = 0

    count += 1

    if allZeros():
        print(count)
        print(answer)
        break

# 34288KB  1212ms
