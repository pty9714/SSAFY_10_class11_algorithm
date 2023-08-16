import sys
sys.stdin = open("input.txt", "r")

from collections import deque

T = int(input())
dx, dy = [-1, 1, 0, 0, -1, -1, 1, 1], [0, 0, -1, 1, -1, 1, -1, 1]

# 범위 체크
def rangeCheck(nxtRow, nxtCol):
    if 0 <= nxtRow < N and 0 <= nxtCol < N:
        return True
    return False


# 8방에서 지뢰 있는지 여부 판단
def searchMine(curRow, curCol):
    for dxx, dyy in zip(dx, dy):
        nxtRow, nxtCol = curRow + dxx, curCol + dyy
        if not rangeCheck(nxtRow, nxtCol):
            continue
        if graph[nxtRow][nxtCol] == "*":
            return True
    return False


# 해당 칸에서 bfs 시도
def bfs(r, c):
    q = deque()
    q.append([r, c])

    while q:
        curRow, curCol = q.popleft()
        graph[curRow][curCol] = -1 # 지뢰 숫자 -1로 표시
        if searchMine(curRow, curCol):
            continue
        for dxx, dyy in zip(dx, dy):
            nxtRow, nxtCol = curRow+dxx, curCol+dyy
            if not rangeCheck(nxtRow, nxtCol):
                continue
            if graph[nxtRow][nxtCol] == ".":
                q.append([nxtRow, nxtCol])
                graph[nxtRow][nxtCol] = 0


for test_case in range(1, T + 1):
    N = int(input())
    graph = [["." for _ in range(N)] for _ in range(N)]
    answer = 0

    for i in range(N):
        temp = input()
        for idx, t in enumerate(temp):
            if t == "*": # 지뢰
                graph[i][idx] = "*"

    # 주변 지뢰 0부터 탐색
    for i in range(N):
        for j in range(N):
            if graph[i][j] == ".":
                if not searchMine(i, j): # 주변 지뢰X
                    bfs(i, j)
                    answer += 1

    # 탐색
    for i in range(N):
        for j in range(N):
            if graph[i][j] == ".": # 빈 칸
                bfs(i, j)
                answer += 1

    print("#" + str(test_case) + " " + str(answer))

