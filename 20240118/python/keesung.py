n, k = map(int, input().split())

inf = 1e9
dp = [inf] * (k + 1)

coins = [int(input()) for _ in range(n)]
coins = [x for x in coins if x <= k]
for coin in coins:
    dp[coin] = 1
    
for i in range(2, k + 1):
    for coin in coins: 
        for idx in range(k+1-coin):
            dp[coin+idx] = min(dp[coin+idx], dp[idx] + 1)
    if dp[-1] != inf:
        break

if dp[-1] == inf:
    print(-1)
else:
    print(dp[-1])
    
// dp