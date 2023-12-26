import heapq
INF = int(1e9)

n,m,x = map(int,input().split())
graph = [[] for _ in range(n+1)]

def dijkstra(s,e):
    q = []
    heapq.heappush(q,(0,s))
    distance = [INF] *(n+1)
    distance[s] = 0

    while q:
        d, now = heapq.heappop(q)
        if distance[now] < d: 
            continue
        
        for i in graph[now]:
            dst = i[0]
            cost = d+i[1]
            
            if cost < distance[dst]:
                heapq.heappush(q, (cost, dst))
                distance[dst] = cost
 
    return distance[e]


for _ in range(m):
    start,end,T = map(int,input().split())
    graph[start].append((end,T))

answer = 0
for i in range(1,n+1):
    if i !=x:
        answer = max(answer,dijkstra(i,x)+dijkstra(x,i))
print(answer)