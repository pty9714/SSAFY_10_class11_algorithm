n = int(input())
dp= [0]*31
dp[2] = 3
dp[4] = 3*3+2
if n%2==0:
    for i in range(6,31,2):
        dp[i] = dp[i-2] * dp[2]
        for j in range(2,i-2,2):
            dp[i] +=dp[j]*2
        dp[i] +=2


print(dp[n])