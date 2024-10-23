n = int(input())
dp = [0]*(n+1)
for i in range(1, n+1):
    w, c, *p = map(int, input().split())
    dp[i] = w
    for j in p:
        dp[i] = max(dp[i], dp[j]+w)
print(max(dp))