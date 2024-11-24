N = list(map(int,input()))
dp = [0] * (len(N)+1)
dp[0],dp[1] = 1,1
if N[0] == 0:
    print(0)
else:
    for i in range(1,len(N)):
        if N[i]>0:
            dp[i+1] +=dp[i]
        if 10<= N[i] + N[i-1]*10 <= 26:
            dp[i+1] += dp[i-1]
    print(dp[-1]%1000000)