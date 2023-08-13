from itertools import combinations


n = int(input())

# 10자리수까지 가능 : 9876543210
arr = []
for i in range(1, 11):
    for comb in combinations(range(10), i):
        num = int("".join(sorted(list(map(str, comb)), reverse=True)))
        arr.append(num)
    if len(arr) >= n:
        break

# 순서대로 정렬
arr.sort()

if len(arr) >= n:
    print(arr[n-1])
else:
    print(-1)

# 31256kb	44ms
