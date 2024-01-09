N = int(input())
l = list(map(int,input().split()))
l.sort()
answer = 0
for i in range(2,N):
    start = 0
    end = i-1
    while start!=end:
        s = l[start] + l[end]
        if s == l[i]:
            answer +=1
            break
        if s < l[i]:
            start +=1
        if s >l[i]:
            end -=1

print(answer)