from itertools import combinations as cb

N = int(input())
numbers = []
answer = []

# 9 ~ 0
for i in range(9,-1,-1):
    numbers.append(str(i))

# 1 ~ 10개 모든 조합
for i in range(1, 11):
    comb = cb(numbers, i)
    temp = []
    for item in comb:
        res = int(''.join(list(item)))
        temp.append(res)
    temp.sort()
    answer.extend(temp)

if N >= 2**10:
    print(-1)
else:
    print(answer[N-1])

---
31256KB
44ms
