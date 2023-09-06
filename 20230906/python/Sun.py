TC = int(input())
for tc in range(TC):
    N = int(input())
    l = set([])
    for i in range(N):
        l.add(input())

    k = list(l)
    k.sort(key = lambda x: (len(x),x))
    
    print(f'#{tc+1}')
    for i in k:
        print(i)
                