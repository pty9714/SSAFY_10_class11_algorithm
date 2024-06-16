n,m = map(int,input().split())
l = list(map(int,input().split()))

l.sort()
if abs(l[0])>abs(l[-1]):
    check = -1
else:
    check = 1

l1 = []
l2 = []

for i in l:  
    if i>0:
        l1.append(i)
    else:
        l2.append(i)

l1.sort(reverse=True)

if check == 1:
    l1,l2 = l2,l1   

answer = abs(l2[0])
if l2:
    for i in range(m,len(l2),m):
        answer+=abs(l2[i])*2
if l1:
    for i in range(0,len(l1),m):
        answer += abs(l1[i]*2)

print(answer)
