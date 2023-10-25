import heapq

k, n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
visited = [0 for _ in range(n + 1)]
for i in range(m):
    a, b, t, h = map(int, input().split())
    graph[a].append((b, t, h))
    graph[b].append((a, t, h))

a, b = map(int, input().split())
answer = []
heapq.heapify(answer)
heapq.heappush(answer, (0, a, k))  # 시간,출발지,뗏목길이
while answer:
    # print(answer)
    v, w, x = heapq.heappop(answer)
    # print(v, w, x)
    if w == b and x > 0:
        print(v)
        exit()

    for b1, t1, h1 in graph[w]:
        arrive = b1
        time = v + t1
        length = x - h1

        if length > 0:
            heapq.heappush(answer, (time, arrive, length))
else:
    print(-1)


# 시간초과
