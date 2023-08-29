N, K = map(int, input().split())
numbers = []

# N 이하의 2제곱수 저장
number = 1
while number <= N:
    numbers.append(number)
    number *= 2

# 가장 적은 수로 N 만들기 시도
answer = 0
while True:
    temp, count = N+answer, 0
    if answer == temp:
        numbers.append(temp)
    for i in range(len(numbers)-1, -1, -1):
        q = temp // numbers[i]
        temp -= q*numbers[i]
        if q > 0:
            count += 1
        if temp == 0:
            break
    if temp == 0: # N을 만들었다
        if count <= K: # K개 이하로 만들었다
            print(answer)
            break
    if (N+answer) % 2 == 0:
        answer += 2
    else:
        answer += 1

# 114976KB  2076ms
