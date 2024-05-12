import sys;
from collections import deque

N, M = map(int, input().split())
input = sys.stdin.readline

arr = []
star =[[] for _ in range(N+1)]
for i in range(M):
    li = list(map(int, input().split()))
    number = li[0]
    if number>2:
        for j in range(number-1):
            star[li[j+2]].extend(li[1:j+2])
    else:
        star[li[2]].append(li[1])
        
answer = []

que = deque()
for i in range(1, N+1):
    if len(star[i]) == 0:
        que.append(i)
while que:

    n = que.pop()
    answer.append(n)
    
    print(que , answer)
    for j in range(1,N+1):
        if n in star[j]: 
            print("j",star[j])
            star[j].remove(n)
            print(star[j])
        
        if len(star[j]) == 0 and j not in answer and j not in que:
            que.append(j)


if len(answer) == N:
    for i in answer:
        print(i)
else:
    print(0)