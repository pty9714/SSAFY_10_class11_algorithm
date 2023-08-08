n,m = map(int,input().split())
l = list(map(int,input().split()))
rain = 0
for i in range(1, m-1):
    lm = max(l[:i])
    rm = max(l[i+1:])
    
    min_max = min(lm, rm) 
    
    if l[i] < min_max: 
        rain += min_max - l[i]
print(rain)


#메모리 31256kb 시간 48ms