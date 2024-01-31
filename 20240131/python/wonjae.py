from sys import stdin

n, m = map(int, stdin.readline().split())
dp = [0 for i in range(10100)]
mem = list(map(int, stdin.readline().split()))

cost = list(map(int, stdin.readline().split()))

for i in range(n):
    for j in range(10001, cost[i]-1, -1):
        if dp[j] < dp[j - cost[i]] + mem[i]:
            dp[j] = dp[j - cost[i]] + mem[i]
for i in range(10001):
    if dp[i] >= m:
        print(i)
        break
