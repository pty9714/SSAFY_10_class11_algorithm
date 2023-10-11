from collections import deque

def topology_sort(indegree):
    tmp = [0] * (N+1)
    q = deque()

    for i in range(1, N+1):
        if indegree[i] == 0:
            tmp[i] = D[i-1]
            q.append((i, tmp[i]))

    while q:
        now, cost = q.popleft()
        for i in graph[now]:
            indegree[i] -= 1
            tmp[i] = max(tmp[i], cost+D[i-1])
            if indegree[i] == 0:
                q.append((i, tmp[i]))

    return tmp


T = int(input())
for _ in range(T):
    N, K = map(int, input().split())
    D = list(map(int, input().split()))

    graph = [[] for i in range(N+1)]
    indegree = [0] * (N+1)
    for _ in range(K):
        X, Y = list(map(int, input().split()))
        graph[X].append(Y)
        indegree[Y] += 1

    res = topology_sort(indegree)

    W = int(input())
    print(res[W])

# 140984KB, 760ms
