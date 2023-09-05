def solution(N, number):
    numbers = [set() for _ in range(9)]
    num = 0
    for i in range(8):
        num = num * 10 + N
        numbers[i+1].add(num)
    
    for i in range(1, 8):
        first_numbers = numbers[i]
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