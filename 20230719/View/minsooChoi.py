T = 10
for test_case in range(1, T + 1):
    n = int(input())
    bds = list(map(int, input().split()))
    answer = 0

    for idx, item in enumerate(bds):
        if idx < 2 or idx > n-3:
            continue
        
        maxHeight = max(bds[idx-2], bds[idx-1], bds[idx+1], bds[idx+2])
        if maxHeight < bds[idx]:
            answer += bds[idx] - maxHeight

    print("#" + str(test_case), answer)
