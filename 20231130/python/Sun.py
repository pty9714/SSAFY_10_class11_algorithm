n = int(input())
l = list(map(int,input().split()))
l.sort()

start = 0
end = n-1
ans = abs(l[start]+l[end])
answer = [l[start],l[end]]
while start<end:
    left = l[start]
    right = l[end]

    s = left+right
    
    if abs(s) < ans:
        ans = abs(s)
        answer = [left, right]
        if ans == 0:
            break
    if s<0:
        start +=1
    else:
        end -=1
print(answer[0],answer[1])

