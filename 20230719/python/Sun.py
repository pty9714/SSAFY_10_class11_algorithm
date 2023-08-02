for tc in range(1,11):
    n = int(input())
    l = list(map(int,input().split()))
    s = 0
    for i in range(2,n-2):
        t = max(l[i-2],l[i-1],l[i+1],l[i+2])
        if l[i]>t:
            s +=l[i]-t
    
    print(f"#{tc} {s}")