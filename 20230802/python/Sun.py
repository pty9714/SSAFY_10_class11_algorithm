import heapq
INF = int(1e9)
tc = int(input())

def dijkstra(start):
    global answer
    q = []
    heapq.heappush(q,(0,start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in Map[now]:
            cost = dist + i[1]
            if i[0] == start:
                answer = min(answer, cost)
                return
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q,(cost,i[0]))




for TC in range(1,tc+1):
    n,m = map(int,input().split())

    Map = [[] for _ in range(n+1)]
    for _ in range(m):
        s,e,c = map(int,input().split())
        Map[s].append((e, c))
    
    distance = [INF]*(n+1)
    answer = INF
    for i in range(1, n+1):
        distance = [INF] * (n + 1)
        dijkstra(i)

    print(f'#{TC} {answer}')
