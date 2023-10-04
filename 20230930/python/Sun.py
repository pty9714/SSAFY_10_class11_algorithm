n = int(input())
l = []
answer = []
for i in range(n):
    a,b = map(int,input().split())
    l.append((a,b))


def work(a,b):
    if a==n:
        answer.append(b)
        return
    if a+l[a][0]>n:
        answer.append(b)
    if a+l[a][0]<=n:
        work(a+l[a][0],b+l[a][1])
    if a+1<n:
        work(a+1,b)

work(0,0)
print(max(answer))