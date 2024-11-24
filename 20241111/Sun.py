from collections import deque

n, m = map(int,input().split())
graph = []
for i in range(n):
    k = input()
    graph.append(list(k))

dx = [1,-1,0,0]
dy = [0,0,1,-1]

def bfs(i,j):
    q = deque()
    q.append((i,j))
    visited = [[0 for _ in range(m)] for _ in range(n)]
    visited[i][j] = 1
    cnt = 0

    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<n and 0<=ny<m:
                if graph[nx][ny] == 'L' and visited[nx][ny] == 0:
                    visited[nx][ny] = visited[x][y] +1
                    cnt = max(cnt,visited[nx][ny])
                    q.append((nx,ny))
    return cnt-1

answer = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == 'L':
            answer = max(answer,bfs(i,j))
print(answer)