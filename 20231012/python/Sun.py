n,k = map(int,input().split())
left = 0
right = n
while left<=right:
    i = (left+right)//2
    p = (i+1)*(n-i+1)
    if k == p:
        print("YES")
        break
    elif k > p:
        left = i+1
    elif k < p:
        right = i-1
else:
    print("NO")