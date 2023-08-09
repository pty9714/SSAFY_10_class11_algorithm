import heapq

T = int(input())

for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    graph = [[] for _ in range(N+1)]
    MAX_ = 987654321
    answer = MAX_

    for _ in range(M):
        S, E, C = map(int, input().split())
        graph[S].append([C, E])

    for start in range(1, N+1):
        heap = []
        distance = [MAX_ for _ in range(N+1)]
        for item in graph[start]:
            dist, node = item[0], item[1]
            heapq.heappush(heap, [dist, node])

        while heap:
            curDist, curNode = heapq.heappop(heap)
            if curNode == start:
                if answer > distance[start]:
                    answer = distance[start]
            for adj in graph[curNode]:
                if curDist+adj[0] < distance[adj[1]]:
                    distance[adj[1]] = curDist+adj[0]
                    heapq.heappush(heap, [adj[0]+curDist, adj[1]])

    if answer == 987654321:
        answer = -1
    print("#" + str(test_case) + " " + str(answer))

---
# 실패!!!!! 왜 틀림?
