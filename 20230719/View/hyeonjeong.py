T = 10
for test_case in range(1, T + 1):
    N = int(input())
    arr = list(map(int, input().split()))
     
    answer = 0
    for i in range(2, N-2):
        highest = max(arr[i-2], arr[i-1], arr[i+1], arr[i+2])
        if highest < arr[i]:
            answer += arr[i] - highest
     
    print('#{0} {1}'.format(test_case, answer))
