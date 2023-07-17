def solution(numbers):
    sz = len(numbers)
    answer = [-1 for i in range(sz)]
    temp = []

    for i in range(sz):
        while temp and numbers[temp[-1]] < numbers[i]:
            answer[temp.pop()] = numbers[i]
        temp.append(i)

    return answer

---

N = 1,000,000 = 10^6
=> O(N^2) 불가능

~ O(N) 풀이 필요
=> 스택에 저장하면서 인덱스 순회.
