import sys
input = sys.stdin.readline

def findParent(a):
    pa = parent[a]
    while pa != a:
        a = pa
        pa = parent[a]
    return a

n, m = map(int,input().split())

parent = [i for i in range(n)]

answer = 0

for i in range(1, m+1):
    a, b = map(int, input().split())
    pa = findParent(a)
    pb = findParent(b)
    if pa == pb:
        answer = i
        break
    parent[pb] = pa

print(answer)
