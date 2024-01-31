import sys

input = sys.stdin.readline
n, m = map(int, input().split())
M = list(map(int, input().split()))
C = list(map(int, input().split()))
l = sum(C)
dp = [[0 for _ in range(l + 1)] for _ in range(n + 1)]

ans = int(1e9)
for i in range(1, n + 1):
    mi, ci = M[i - 1], C[i - 1]
    for j in range(l + 1):
        dp[i][j] = dp[i - 1][j]
    for j in range(ci, l + 1):
        dp[i][j] = max(dp[i - 1][j - ci] + mi, dp[i][j])
        if dp[i][j] >= m:
            ans = min(ans, j)
print(ans)
