n = int(input())
k = int(input())
s = list(map(int,input().split()))
s.sort()

l = []
for i in range(0,n-1):
    l.append(s[i+1] - s[i])

l.sort()

print(sum(l[:n-k]))