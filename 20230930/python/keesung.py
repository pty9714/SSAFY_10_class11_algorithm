N = int(input())
scores = [list(map(int, input().split())) for _ in range(N)]
dp = [[0, 0] for _ in range(N)] # dp[일][A] A가 0이면 일 불가능, 1이면 일 가능

for i in range(N):
    day, score = scores[i]
    new_score = dp[i][1] + score
    if i + day > N:
        continue
    for j in range(day): # 일을 했을 때는 한 일수만큼 score 더해서 업데이트
        dp[i+j][0] = max(dp[i+j][0], new_score)
    for j in range(i+day, N): # 일을 해도 기간 끝난 뒤에는 일을 다시 할 수 있으므로 여기도 업데이트
        dp[j][1] = max(dp[i][1] + score, dp[j][1])

# print(dp)
print(max([x[0] for x in dp] + [x[1] for x in dp]))

# 가능한 것과 불가능 한 것 나누어서 생각
# 31256KB 44ms