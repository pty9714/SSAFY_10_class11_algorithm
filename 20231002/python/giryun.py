from collections import defaultdict

def find_case(pizza, length):
    case = defaultdict(int)
    for i in range(length):
        temp = pizza[i:] + pizza[:i]
        pre = 0
        for num in temp:
            pre += num
            case[pre] += 1
    case[sum(pizza)] = 1
    return case


k = int(input())
m, n = map(int, input().split())
pizza_a = [int(input()) for _ in range(m)]
pizza_b = [int(input()) for _ in range(n)]

case1 = find_case(pizza_a, m)
case2 = find_case(pizza_b, n)

result = case1.get(k, 0) + case2.get(k, 0)
for num in case1:
    if k-num in case2:
        result += case1[num] * case2[k-num]
print(result)
