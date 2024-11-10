import sys, heapq
input = sys.stdin.readline

n = int(input())
m = int(input())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

start, end = map(int, input().split())

near = [start] * (n + 1)
distance = [1e9] * (n + 1)

q = [(0, start)]
while q:
    dist, now = heapq.heappop(q)
    if dist > distance[now]:
        continue
    
    for next, nextdist in graph[now]:
        cost = nextdist + dist
        if cost < distance[next]:
            distance[next], near[next] = cost, now
            heapq.heappush(q, (cost, next))
    
ans = []
tmp = end
while tmp != start:
    ans.append(tmp)
    tmp = near[tmp]

ans.append(start)
ans.reverse()

print(distance[end])
print(len(ans))
print(*ans)