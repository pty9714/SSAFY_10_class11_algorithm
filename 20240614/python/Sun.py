from collections import deque
n,w,L= map(int,input().split())
l = deque(list(map(int,input().split())))

b = deque([0]*w)
t = []
answer = 0
while len(t) != n:
    answer +=1
    k = b.popleft()
    if k != 0:
        t.append(k)
    if l: 
        if sum(b)+l[0]<=L:
            b.append(l.popleft())
        else:
            b.append(0)
    else:
        b.append(0)

print(answer)

