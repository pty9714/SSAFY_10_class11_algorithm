import sys
sys.setrecursionlimit(10**6)

N = int(input())
picture = [list(input()) for _ in range(N)]
directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]


def dfs(r, c):
    visited[r][c] = True
    color = picture[r][c]
    for d in directions:
        nr = r + d[0]
        nc = c + d[1]
        if nr < 0 or nr >= N or nc < 0 or nc >= N or visited[nr][nc]:
            continue
        if picture[nr][nc] == color:
            dfs(nr, nc)


visited = [[False for _ in range(N)] for _ in range(N)]
cnt = 0
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            dfs(i, j)
            cnt += 1


def dfs1(r, c):
    visited1[r][c] = True
    color = picture[r][c]
    for d in directions:
        nr = r + d[0]
        nc = c + d[1]
        if nr < 0 or nr >= N or nc < 0 or nc >= N or visited1[nr][nc]:
            continue
        if picture[nr][nc] == color or (picture[nr][nc] != 'B' and color != 'B'):
            dfs1(nr, nc)


visited1 = [[False for _ in range(N)] for _ in range(N)]
cnt1 = 0
for i in range(N):
    for j in range(N):
        if not visited1[i][j]:
            dfs1(i, j)
            cnt1 += 1

print(cnt, cnt1)

# 31580	kb 68 ms
