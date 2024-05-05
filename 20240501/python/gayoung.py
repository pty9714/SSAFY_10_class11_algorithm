import sys;
from collections import deque

N = int(input())
arr = [[0]*N for _ in range(N)]
visited_m = [[-1]*N for _ in range(N)]

def dfs_max(arr,visited):
    dx = [1, 1, 1,]
    dy = [0, -1, 1]
    
    qu = deque([])
    for i in range(N): 
        visited[0][i] = arr[0][i]
        qu.append((0,i))
    
    while qu:
        x, y = qu.popleft()
        for i in range(3):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if visited_m[nx][ny] == -1 or visited[nx][ny]< visited[x][y] + arr[nx][ny]:
                visited[nx][ny] = visited[x][y] + arr[nx][ny]
                qu.append([nx,ny])
            else:
                continue
def dfs_min(arr,visited):
    dx = [1, 1, 1,]
    dy = [0, -1, 1]
    
    qu = deque([])
    for i in range(N): 
            visited[0][i] = arr[0][i]
            qu.append((0,i))
    
    while qu:
        x, y = qu.popleft()
        for i in range(3):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if visited_m[nx][ny] == -1 or visited[nx][ny]> visited[x][y] + arr[nx][ny]:
                visited[nx][ny] = visited[x][y] + arr[nx][ny]
                qu.append([nx,ny])
            else:
                continue

for i in range(N):
    a,b,c = map(int, sys.stdin.readline().split())
    arr[i][0] = a
    arr[i][1] = b
    arr[i][2] = c

dfs_max(arr,visited_m)
max_t = max(visited_m[N-1][0],visited_m[N-1][1],visited_m[N-1][2])
dfs_min(arr,visited_m)
min_t = min(visited_m[N-1][0],visited_m[N-1][1],visited_m[N-1][2])

print(max_t,min_t)