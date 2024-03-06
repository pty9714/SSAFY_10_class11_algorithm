import sys
input = sys.stdin.readline

n,m = map(int,input().split())
parent = [i for i in range(n)]

def find(x):
    if parent[x] != x:
        return find(parent[x])
    return x
        
def union(x,y):
    x = find(x)
    y = find(y)
    if x<y:
        parent[y] = x
    else:
        parent[x] = y

for i in range(m):
    a,b = map(int,input().split())
    if find(a) == find(b):
        print(i+1)   
        break
    union(a,b)
    
else:
    print(0)




