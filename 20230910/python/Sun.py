
TC = int(input())


for tc in range(TC):
    x1,y1,x2,y2 = map(int,input().split())
    answer = 0
    m1 = abs(x1-x2)
    m2 = abs(y1-y2)
    answer += 2*min(m1,m2)
    k = max(m1,m2)-min(m1,m2)
    if k%2 == 0:
        answer +=2*k
    else:
        answer += 2*k-1
    print(f'#{tc+1} {answer}')