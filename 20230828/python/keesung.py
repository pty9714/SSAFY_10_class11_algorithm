from bisect import bisect_left, bisect_right
T = int(input())
numbers = [1]
while True:
    new_number = numbers[-1] * 2
    if new_number > 10e9:
        numbers.append(new_number)
        break
    else:
        numbers.append(new_number)

for test_case in range(1, T+1):
    N, V = map(int, input().split())
    depth = bisect_right(numbers, N)
    # print(numbers[depth])
    if V == 1:
        print(f'#{test_case} {depth - 1}')
    else:
        v_depth = bisect_right(numbers, V)
        mid_val = (numbers[v_depth] + numbers[v_depth-1]) / 2
        if V >= mid_val:
            print(f'#{test_case} {v_depth + depth - 2}')
        else:
            total_mid_val = (numbers[depth] + numbers[depth-1]) / 2
            if N < total_mid_val:
                print(f'#{test_case} {v_depth + depth - 3}')
            else:
                print(f'#{test_case} {v_depth + depth - 2}')
            
# 시간초과 26917개 정답