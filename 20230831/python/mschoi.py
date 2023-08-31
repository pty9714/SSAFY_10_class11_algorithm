from collections import deque

class BabyShark:
    row, col, size = 0, 0, 2

    def setLocation(self, row, col):
        self.row = row
        self.col = col

    def setSize(self, size):
        self.size = size

N = int(input())
graph = [[] for _ in range(N)]
shark = BabyShark()
count = 0
time = 0

for i in range(N):
    temp = list(map(int, input().split()))
    graph[i] = temp
    for j, tmp in enumerate(temp):
        if tmp == 9: # 상어 위치
            shark.setLocation(i, j)

# 아기상어 위치 기준으로 BFS
dx, dy = [-1, 0, 1, 0], [0, -1, 0, 1] # 상, 좌, 하, 우


def bfs(shark, cand):
    global time, count
    q = deque()
    q.append([shark.row, shark.col, 0])
    visited = [[False for _ in range(N)] for _ in range(N)]
    visited[shark.row][shark.col] = True
    graph[shark.row][shark.col] = 0

    while q:
        curRow, curCol, timeCnt = q.popleft()
        for dxx, dyy in zip(dx, dy):
            nextRow, nextCol = curRow+dxx, curCol+dyy
            if nextRow < 0 or nextRow > N-1 or nextCol < 0 or nextCol > N-1:
                continue
            if visited[nextRow][nextCol]:
                continue
            if graph[nextRow][nextCol] == 0: # 빈칸
                q.append([nextRow, nextCol, timeCnt+1])
                visited[nextRow][nextCol] = True
            elif 1 <= graph[nextRow][nextCol] <= 6: # 물고기 칸
                if shark.size > graph[nextRow][nextCol]: # 자기보다 작은 물고기만 먹는다
                    visited[nextRow][nextCol] = True
                    if cand:
                        if timeCnt+1 > cand[-1][2]:
                            continue
                    cand.append([nextRow, nextCol, timeCnt+1])
                elif shark.size == graph[nextRow][nextCol]: # 지나갈 수만 있다
                    q.append([nextRow, nextCol, timeCnt + 1])
                    visited[nextRow][nextCol] = True


def update(cand):
    global graph, count, time
    if not cand:
        return False
    cand.sort()
    targetRow, targetCol, targetTime = cand[0][0], cand[0][1], cand[0][2]
    shark.setLocation(targetRow, targetCol)
    graph[targetRow][targetCol] = 0
    time += targetTime
    count += 1
    if shark.size == count:
        shark.setSize(shark.size + 1)
        count = 0
    return True


# 시간 측정
while(True):
    cand = []
    bfs(shark, cand)
    if not update(cand):
        break

print(time)

---
# 34280kb  128ms
