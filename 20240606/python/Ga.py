T = int(input())
answer = []
for t in range(T):
    n, K = map(int, input().split())
    num = list(map(int, input().split()))
    
    K_num = {}
    K_min = 100000000
    for i in range(n):
        arr = num[i+1:]
        if K > num[i]:
             arr = sorted(arr, reverse=True)
        else:
            arr = sorted(arr)
        # print(num[i],arr,"---")
        for j in arr:
            minus = abs(K - (num[i]+j))
            if minus <= K_min:
                K_min = minus
                if K_num.get(minus) == None:
                    K_num[minus] = 1
                else :
                    K_num[minus] += 1
            if minus > K_min:
                break
            #엔터없이 출력
    #         print(minus, end=' ')
    #     print()
    # print(K_num)
    keys = sorted(K_num.keys())
    answer.append(K_num[keys[0]])

for a in answer:
    print(a)