import sys
input = sys.stdin.readline
n = int(input())
l = list(map(int,input().split()))
if n == 1:
    l2 = [0]
else:
    l2 = [0]*(n+1)
    if l[0] > l[1]:
        l2[0] = 1
    else:
        l2[0] = 0
    for i in range(1,n):
        if l[i-1]>l[i]:
            l2[i] = l2[i-1]+1
        else:
            l2[i] = l2[i-1]
    l2[-1] = l2[-2]
m = int(input())
for i in range(m):
    a, b = map(int,input().split())
    print(l2[b-1]-l2[a-1])

