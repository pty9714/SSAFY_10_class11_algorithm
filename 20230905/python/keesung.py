def solution(N, number):
    numbers = [set() for _ in range(9)]
    num = 0
    for i in range(8):
        num = num * 10 + N
        numbers[i+1].add(num)
    
    for i in range(1, 8):
        first_numbers = numbers[i]
        if number in first_numbers:
            return i
        for j in range(1, i+1):
            index = i + j
            if index > 8:
                continue
            second_numbers = numbers[j]
            
            
            for num1 in first_numbers:
                for num2 in second_numbers:
                    numbers[index].add(num1 + num2)
                    numbers[index].add(abs(num1 - num2))
                    numbers[index].add(num1 * num2)
                    if num2 != 0:
                        numbers[index].add(num1 // num2)
    
    # for i in range(4):
    #     print(numbers[i])
    
    for i in range(1, 9):
        if number in numbers[i]:
            return i
    return -1

# print(solution(5, 12))
# print(solution(6, 5))

# 테스트 1 〉	통과 (6.45ms, 11MB)
# 테스트 2 〉	통과 (0.82ms, 10.2MB)
# 테스트 3 〉	통과 (3.82ms, 10.4MB)
# 테스트 4 〉	통과 (6.33ms, 11.1MB)
# 테스트 5 〉	통과 (5.17ms, 10.4MB)
# 테스트 6 〉	통과 (4.71ms, 10.5MB)
# 테스트 7 〉	통과 (10.57ms, 10.5MB)
# 테스트 8 〉	통과 (11.07ms, 11.1MB)
# 테스트 9 〉	통과 (3.70ms, 10.4MB)

# 각 횟수 에서 가능한 모든 경우의 수 더해주기

# 테스트 1 〉	통과 (6.23ms, 10.4MB)
# 테스트 2 〉	통과 (0.02ms, 10.2MB)
# 테스트 3 〉	통과 (0.03ms, 10.1MB)
# 테스트 4 〉	통과 (12.67ms, 10.9MB)
# 테스트 5 〉	통과 (5.78ms, 10.4MB)
# 테스트 6 〉	통과 (2.71ms, 10.3MB)
# 테스트 7 〉	통과 (1.73ms, 10.4MB)
# 테스트 8 〉	통과 (7.55ms, 11MB)
# 테스트 9 〉	통과 (0.01ms, 10.2MB)