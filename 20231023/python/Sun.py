n, m = map(int, input().split())
maxr = -1
l = []
for _ in range(n):
    l.append(list(input()))

dp = [[0 for _ in range(m)] for _ in range(n)]
visited = [[0 for _ in range(m)] for _ in range(n)]


def dfs(x, y, r):
    global maxr
    num = int(l[y][x])
    if r > maxr:
        maxr = r
    g = [(x + num, y), (x - num, y), (x, y + num), (x, y - num)]
    for mx, my in g:
        if 0 <= mx < m and 0 <= my < n:
            if l[my][mx] != "H" and r + 1 > dp[my][mx]:
                if visited[my][mx] == 0:
                    dp[my][mx] = r + 1
                    visited[my][mx] = 1
                    dfs(mx, my, r + 1)
                    visited[my][mx] = 0
                else:
                    print(-1)
                    exit()


dfs(0, 0, 1)
print(maxr)
