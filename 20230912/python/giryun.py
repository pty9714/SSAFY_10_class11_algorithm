from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(i, j):
    q = deque()
    q.append((i, j))
    B[i][j] = 0
    cnt = 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and B[nx][ny] == 1:
                q.append((nx, ny))
                B[nx][ny] = 0
                cnt += 1
    return cnt

n = int(input())
B = [list(map(int, input())) for _ in range(n)]

ans = []
for i in range(n):
    for j in range(n):
        if B[i][j] == 1:
            ans.append(bfs(i, j))
ans.sort()
print(len(ans))
for a in ans:
    print(a)
