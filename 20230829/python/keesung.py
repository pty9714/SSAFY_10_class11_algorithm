from bisect import bisect_left, bisect_right

numbers = [1]

while True:
    numbers.append(numbers[-1] * 2)
    if numbers[-1] > 10e7:
        break
    
bottle = 0
N, K = map(int, input().split())

if N <= K:
    print(K-N)
else:
    while K > 1:
        index = bisect_left(numbers, N) - 1
        N -= numbers[index]
        if K >= numbers[index]:
            K -= numbers[index]
        else:
            K -= 1
        # print(N)
    if N in numbers:
        bottle = 0
    else:
        bottle = numbers[bisect_right(numbers, N)] - N
    print(bottle)
        