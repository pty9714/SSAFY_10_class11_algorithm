def solution(numbers):
    sz = len(numbers)
    answer = [-1 for i in range(sz)]
    temp = []

    for i in range(sz):
        while temp and numbers[temp[-1]] < numbers[i]:
            answer[temp.pop()] = numbers[i]
        temp.append(i)

    return answer

# N = 1,000,000 = 10^6
# => O(N^2) 불가능

# ~ O(N) 풀이 필요
# => O(n)으로 쭉 순회하면서 해결된 값은 stack(스택과 같은 역할을 하는 리스트) 에서 바로 제거, 해결 되지 않은 값은 stack에 남겨둔 채로 계속 진행.
