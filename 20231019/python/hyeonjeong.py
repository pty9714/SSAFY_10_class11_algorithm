# 실패

def dfs(s, e, t, h):
    global result
    if h >= K:
        return
    if e == end and (result < 0 or result > t):
        result = t
        return

    for nxt in conn[e]:
        dfs(e, nxt, t + roads[e][nxt][0], h + roads[e][nxt][1])


K, N, M = map(int, input().split())
roads = [[() for _ in range(N + 1)] for _ in range(N + 1)]
conn = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b, time, height = map(int, input().split())
    roads[a][b] = (time, height)
    conn[a].append(b)

start, end = map(int, input().split())
result = -1


for i in conn[start]:
    dfs(start, i, roads[start][i][0], roads[start][i][1])

print(result)
