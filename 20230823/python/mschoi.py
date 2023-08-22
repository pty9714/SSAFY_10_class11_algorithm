first, sec = input(), input()
dp = [[0 for _ in range(len(sec) + 1)]for _ in range(len(first) + 1)]

for row in range(1, len(first)+1):
    for col in range(1, len(sec)+1):
        if first[row-1] == sec[col-1]: # 같은 알파벳일 때 (왼쪽 위 대각선 값+1)
            dp[row][col] = dp[row-1][col-1]+1
        else:
            dp[row][col] = max(dp[row-1][col], dp[row][col-1])

print(dp[-1][-1])

# 56452KB  556ms
