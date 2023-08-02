import heapq
INF = int(1e9)


def dijkstra(start):
    global answer
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist: continue
        for next_, ndist in graph[now]:
            cost = dist + ndist
            if next_ == start:
                answer = min(answer, cost)
                return
            if cost < distance[next_]:
                distance[next_] = cost
                heapq.heappush(q, (cost, next_))
    return


for t in range(int(input())):
    n, m = map(int, input().split())
    
    graph = [[] for _ in range(n+1)]
    for _ in range(m):
        s, e, c = map(int, input().split())
        graph[s].append((e, c))

    answer = INF
    for i in range(1, n+1):
        distance = [INF] * (n + 1)
        dijkstra(i)
        
    print(f'#{t+1} {answer}')