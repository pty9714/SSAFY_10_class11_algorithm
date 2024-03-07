import sys
input = sys.stdin.readline

def find(x):
    if x != parent[x]: return find(parent[x])
    return parent[x]

def union_(a, b):
    a, b = find(a), find(b)
    if a == b: return
    if rank[a] > rank[b]: parent[b] = a
    elif rank[a] < rank[b]: parent[a] = b
    else:
        rank[b] += 1
        parent[a] = b

N, M = map(int, input().split())

parent = [i for i in range(N)]
rank = [0] * N
ans = 0
for i in range(M):
    a, b = map(int, input().split())
    if not ans:
        if find(a) == find(b): ans = i + 1
        else: union_(a, b)

print(ans)
