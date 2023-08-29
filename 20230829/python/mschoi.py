N, K = map(int, input().split())
numbers = []

# N 이하의 2제곱수 저장
number = 1
while number <= N:
    numbers.append(number)
    number *= 2

# 가장 적은 수로 N 만들기 시도
cnt = []
for i in range(len(numbers)-1, -1, -1):
    q = N // numbers[i]
    N -= q*numbers[i]
    if q > 0:
        cnt.append(numbers[i])
    if N == 0:
        break

if len(cnt) > K:
    count = len(cnt) - K
    temp = 0
    for j in range(count):
        temp += cnt[len(cnt)-j-2] - cnt[len(cnt)-j-1]
        cnt[len(cnt)-j-2] *= 2
    print(temp)
else:
    print(0)

# 31256KB  44ms
