T = int(input())

n = int(input())
A = [0] + list(map(int, input().split()))

for i in range(1, n+1):
    A[i] += A[i - 1]

m = int(input())
B = [0] + list(map(int, input().split()))

for i in range(1, m+1):
    B[i] += B[i - 1]

ans = 0
hashmap = {}

for i in range(1, n+1):
    for j in range(i):
        hashmap[A[i] - A[j]] = hashmap.get(A[i] - A[j], 0) + 1

for i in range(1, m+1):
    for j in range(i):
        ans += hashmap.get(T - (B[i] - B[j]), 0)

print(ans)
