import sys
input = sys.stdin.readline

def find(parent, x):
    if parent[x] != x: return find(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    a, b = find(parent, a), find(parent, b)
    if a < b: parent[b] = a
    else: parent[a] = b

n = int(input())
m = int(input())
parent = [i for i in range(n + 1)]
for i in range(n):
    city = list(map(int, input().split()))
    for j in range(i + 1, n):
        if city[j]:
            union(parent, i + 1, j + 1)
path = list(map(int, input().split()))
start = find(parent, path[0])

ans = 'YES'
for i in range(1, m):
    if find(parent, path[i]) != start:
        ans = 'NO'
        break
print(ans)
