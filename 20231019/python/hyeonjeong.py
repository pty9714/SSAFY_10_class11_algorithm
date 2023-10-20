# 실패
def dfs(i, t, h):
    global result
    # 도착점에 도착
    if i == end:
        result = t
        return
    # 연결되어 있는 섬 중에 방문하지 않았고, 최단 시간을 넘지 않으며, 뗏목이 사라지지 않는 섬만 방문
    for nxt in roads[i]:
        if visited[nxt[0]] or t + nxt[1] >= result > -1 or h + nxt[2] >= K:
            continue
        visited[nxt[0]] = True
        dfs(nxt[0], t + nxt[1], h + nxt[2])
        visited[nxt[0]] = False


K, N, M = map(int, input().split())
roads = [[] for _ in range(N + 1)]
visited = [False for _ in range(N+1)]

for _ in range(M):
    a, b, time, height = map(int, input().split())
    roads[a].append([b, time, height])
    roads[b].append([a, time, height])

start, end = map(int, input().split())
result = -1

dfs(start, 0, 0)

print(result)

# 52% pypy3 63%
