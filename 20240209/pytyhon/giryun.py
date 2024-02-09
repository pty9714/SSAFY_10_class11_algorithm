import heapq
import sys

input = sys.stdin.readline
INF = sys.maxsize

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for next, ndist in graph[now]:
            cost = dist + ndist
            if cost < distance[next]:
                distance[next] = cost
                heapq.heappush(q, (cost, next))

v, e = map(int, input().split())
k = int(input())
graph = [[] for i in range(v + 1)]
distance = [INF] * (v + 1)

for _ in range(e):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

dijkstra(k)
for i in range(1, v + 1):
    print(distance[i] if distance[i] != INF else 'INF')
    
