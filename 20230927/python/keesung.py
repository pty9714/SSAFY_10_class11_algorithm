N = int(input())
houses = [list(map(int, input().split())) for _ in range(N)]
INF = 10e9
dp = [[[INF for _ in range(N)] for _ in range(3)] for _ in range(3)] # dp[0, 1, 2][0, 1, 2][N] 처음이 빨, 초, 파 일 때

dp[0][0][0] = houses[0][0]
dp[1][1][0] = houses[0][1]
dp[2][2][0] = houses[0][2]

for i in range(1, N-1):
    for j in range(3):
        dp[j][0][i] = min(dp[j][1][i-1], dp[j][2][i-1]) + houses[i][0]
        dp[j][1][i] = min(dp[j][0][i-1], dp[j][2][i-1]) + houses[i][1]
        dp[j][2][i] = min(dp[j][1][i-1], dp[j][0][i-1]) + houses[i][2]
    
dp[0][1][N-1] = min(dp[0][2][N-2], dp[0][0][N-2]) + houses[N-1][1]
dp[0][2][N-1] = min(dp[0][1][N-2], dp[0][0][N-2]) + houses[N-1][2]
dp[1][0][N-1] = min(dp[1][2][N-2], dp[1][1][N-2]) + houses[N-1][0]
dp[1][2][N-1] = min(dp[1][0][N-2], dp[1][1][N-2]) + houses[N-1][2]
dp[2][1][N-1] = min(dp[2][0][N-2], dp[2][2][N-2]) + houses[N-1][1]
dp[2][0][N-1] = min(dp[2][1][N-2], dp[2][2][N-2]) + houses[N-1][0]

# print(dp)
# for num1, i in enumerate(["빨강", "초록", "파랑"]):
#     for num2, j in enumerate(["빨강", "초록", "파랑"]):
#         print(f"{i} 로 시작해서 현재 {j} 일 때 ===========")
#         print(dp[num1][num2])

result = min([dp[0][1][N-1], dp[0][2][N-1], dp[1][0][N-1], dp[1][2][N-1], dp[2][1][N-1], dp[2][0][N-1]])
print(result)

# 31256kb, 80ms
# DP 0 부터 입력 하고 1~N-1까지만 진행 후 N을 다시 진행한다.