tc = int(input())
for TC in range(1,tc+1):
    answer = -1
    N,A,B = map(int,input().split())
    for i in range(1,N):
        j = 1
        while i*j <= N:
            result = A*abs(i-j) + B*(N-i*j)
            if answer == -1:
                answer = result
            else:
                answer = min(answer,result)
            j+=1
    print(f'#{TC} {answer}')
