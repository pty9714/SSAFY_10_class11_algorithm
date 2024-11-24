import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline
dx = [0, 0, 1, -1]
dy = [-1, 1, 0, 0]
def dfs(x, y):
    cnt = 1
    for i, j in zip(dx, dy):
        nx, ny = x + i, y + j
        if 0 <= nx < n and 0 <= ny < n:
            if graph[nx][ny] > graph[x][y]:
                if dp[nx][ny] != -1:
                    cnt = max(cnt, 1 + dp[nx][ny])
                else:
                    cnt = max(cnt, 1 + dfs(nx, ny))
    dp[x][y] = cnt
    return dp[x][y]

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
dp = [[-1] * n for _ in range(n)]

cnt = 0
for x in range(n):
    for y in range(n):
        cnt = max(cnt, dfs(x, y))
print(cnt)