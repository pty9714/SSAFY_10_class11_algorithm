import math

n = int(input())
if n == 1:
    print(0)
    exit()

# 에라토스테네스의 체
arr = [0] * 2 + [1] * (n-1)
for i in range(2, int(math.sqrt(n))+1):
    if arr[i]:
        j = 2
        while (i * j) <= n:
            arr[i * j] = 0
            j += 1

# 소수 추가    
prime = []
for i in range(n+1):
    if arr[i]: prime.append(i)

# 투포인터
answer, result = 0, prime[0]
left, right = 0, 0
while left <= right:
    if result > n:
        result -= prime[left]
        left += 1
    else:
        if result == n:
            answer += 1
        right += 1
        if right == len(prime):
            break
        result += prime[right] 
    
print(answer)
# 95744	2640
