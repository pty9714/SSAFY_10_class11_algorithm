from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(i, j, c, visited, t):
    q = deque()
    q.append((i, j))
    visited[i][j] = 1
    while q:
        x, y = q.popleft()
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            if nx < 0 or nx >= n or ny < 0 or ny >= n: continue
            if visited[nx][ny]: continue
            if t == 0 and B[nx][ny] != c: continue # 색맹 아닐때
            if t == 1 and not ((B[x][y] == B[nx][ny]) or (B[x][y] == 'R' and B[nx][ny] == 'G') or (B[x][y] == 'G' and B[nx][ny] == 'R')): continue
            q.append((nx, ny))
            visited[nx][ny] = 1
    return visited

n = int(input())
B = [list(input()) for _ in range(n)]
visited1 = [[0] * n for _ in range(n)] # 색맹 아닌 사람
visited2 = [[0] * n for _ in range(n)] # 색맹
ans1, ans2 = 0, 0
for i in range(n):
    for j in range(n):
        if not visited1[i][j]:
            visited1 = bfs(i, j, B[i][j], visited1, 0)
            ans1 += 1
        if not visited2[i][j]:
            visited2 = bfs(i, j, B[i][j], visited2, 1)
            ans2 += 1
        
print(ans1, ans2)
# 34112	80
