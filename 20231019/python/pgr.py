import heapq
import sys
INF = sys.maxsize

def Dijsktra():
    distances = [[INF for _ in range(k+1)] for _ in range(n+1)]
    distances[start][k] = 0
    pq = []
    heapq.heappush(pq, [0, start, k])
    while pq:
        cur_cost, cur_node, cur_wood = heapq.heappop(pq)
        if distances[cur_node][cur_wood] < cur_cost: continue
        for next_node, next_cost, next_wood in nodes[cur_node]:
            if cur_wood - next_wood > 0 and distances[next_node][cur_wood - next_wood] > cur_cost + next_cost:
                distances[next_node][cur_wood - next_wood] = cur_cost + next_cost
                heapq.heappush(pq, [cur_cost + next_cost, next_node, cur_wood - next_wood])
    return min(distances[end])

k, n, m = map(int, input().split())
nodes = [[] for _ in range(n+1)]
for _ in range(m):
    a, b, t, h = map(int, input().split())
    nodes[a].append([b, t, h])
    nodes[b].append([a, t, h])
start, end = map(int, input().split())

answer = Dijsktra()
print(-1 if answer == INF else answer)
# 64188	2836	
