from collections import deque

N = int(input())
maps = [[] for _ in range(N)]
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
visited = [[False for _ in range(N)] for _ in range(N)]
howMany, answer = 0, [] # 단지 수, 단지내 집의 수

for i in range(N):
    temp = input()
    maps[i] = list(str(item) for item in temp)

# BFS
def bfs(row, col):
    global visited
    q = deque()
    q.append([row, col])
    visited[row][col] = True
    houseCnt = 1

    while q:
        cr, cc = q.popleft()
        for dxx, dyy in zip(dx, dy):
            nr, nc = cr+dxx, cc+dyy
            if nr < 0 or nr > N-1 or nc < 0 or nc > N-1:
                continue
            if maps[nr][nc] == "1" and not visited[nr][nc]:
                q.append([nr, nc])
                houseCnt += 1
                visited[nr][nc] = True
    return houseCnt


for i in range(N):
    for j in range(N):
        # 새로운 단지만 방문
        if not visited[i][j] and maps[i][j] != "0":
            howMany += 1 # 단지 수
            answer.append(bfs(i, j))

print(howMany)
for item in sorted(answer):
    print(item)

# 34192kb  64ms
