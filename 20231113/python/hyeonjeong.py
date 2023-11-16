import sys
import heapq

V, E = map(int, input().split())
K = int(input())
graph = [[] for _ in range(V+1)]
INF = 1e8
answer = [INF for _ in range(V+1)]

for _ in range(E):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append((v, w))

queue = []
heapq.heappush(queue, (0, K))
answer[K] = 0

while queue:
    acc_dist, start = heapq.heappop(queue)

    if answer[start] < acc_dist:
        continue

    for end, dist in graph[start]:
        if acc_dist + dist < answer[end]:
            answer[end] = acc_dist + dist
            heapq.heappush(queue, (acc_dist + dist, end))

for i in range(1, V+1):
    if answer[i] == INF:
        print('INF')
    else:
        print(answer[i])

# 68348 kb	652 ms
