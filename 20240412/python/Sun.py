graph = [[0 for _ in range(100)] for i in range(100)]
answer = 0
n,m = map(int,input().split())
for i in range(n):
    a,b,c,d = map(int,input().split())
    for i in range(a-1,c):
        for j in range(b-1,d):
            graph[i][j] +=1


for i in range(100):
    for j in range(100):
        if graph[i][j] > m:
            answer +=1

print(answer)
