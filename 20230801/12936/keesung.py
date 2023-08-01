def solution(n, k):
    answer = []
    
    fact = [1]
    numbers = [i for i in range(1, n+1)]
    for i in range(2, n):
        fact.append(fact[-1]*i)
    for idx in range(len(fact)-1, -1, -1):
        number = fact.pop()
        if k % number == 0:
            answer.append(numbers.pop(k//number-1))
        else:
            answer.append(numbers.pop(k//number))
        k %= number
    answer.append(numbers.pop())
    return answer

# n = 3
# k = 5
# print(solution(n, k))