import sys
sys.setrecursionlimit(10**6)

V = int(input())

tree = [[] for _ in range(V+1)]
for _ in range(V):
    tmp = list(map(int, input().split()))
    i = 1
    while tmp[i] != -1:
        tree[tmp[0]].append([tmp[i], tmp[i+1]])
        i += 2


def dfs(node, total_cost):
    global answer, end
    if answer < total_cost:
        answer = total_cost
        end = node
    for nxt, cost in tree[node]:
        if not visited[nxt]:
            visited[nxt] = True
            dfs(nxt, total_cost+cost)


answer = 0
end = 0

visited = [False for _ in range(V+1)]
visited[1] = True
dfs(1, 0)

visited = [False for _ in range(V+1)]
visited[end] = True
dfs(end, 0)

print(answer)

# 71356	kb 4568 ms
