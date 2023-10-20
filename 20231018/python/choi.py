import sys
sys.setrecursionlimit(10**6)

T = int(input())


def dfs(i):
    global result, visited
    visited[i] = True
    cycle.append(i)
    nxt = students[i]

    if visited[nxt]:
        if nxt in cycle:
            result += cycle[cycle.index(nxt):]
        return
    else:
        dfs(nxt)


for test_case in range(T):
    N = int(input())
    students = [0] + list(map(int, input().split()))
    result = []
    visited = [False for _ in range(N+1)]

    # 사이클 판단
    for idx in range(1, N+1):
        if visited[idx]:
            continue
        cycle = []
        dfs(idx)

    print(N - len(result))

62044kb  2692ms
