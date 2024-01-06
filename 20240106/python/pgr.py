from collections import deque


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(i, j, idx):
    united = []
    united.append((i, j))
    q = deque()
    q.append((i, j))
    B[i][j] = idx
    total = A[i][j]
    cnt = 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and B[nx][ny] == -1:
                if l <= abs(A[nx][ny] - A[x][y]) <= r:
                    united.append((nx, ny))
                    q.append((nx, ny))
                    B[nx][ny] = idx
                    total += A[nx][ny]
                    cnt += 1
    if cnt == 1:
        return
    res = total // cnt
    for x, y in united:
        A[x][y] = res
    return

n, l, r = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(n)]

ans = 0
while True:
    B = [[-1] * n for _ in range(n)]
    idx = 0
    for i in range(n):
        for j in range(n):
            if B[i][j] == -1:
                bfs(i, j, idx)
                idx += 1
    if idx == n * n:
        break
    ans += 1

print(ans)
