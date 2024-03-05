import math
import sys
input = sys.stdin.readline

INF = int(1e9)
def dfs(now, visited) :
    if visited == (1 << n) - 1:
        if graph[now][0]: return graph[now][0]
        else: return INF
    
    if (now, visited) in dp:
        return dp[(now, visited)]
    
    ans = INF
    for nxt in range(1, n):
        if graph[now][nxt] == 0 or visited & (1 << nxt): continue
        cost = dfs(nxt, visited | (1 << nxt)) + graph[now][nxt]
        ans = min(ans, cost)

    dp[(now, visited)] = ans
    return ans


n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
dp = {}

print(dfs(0, 1))
