def solution(sticker):
    if(len(sticker)<3): return max(sticker)
    dp = [sticker[0], sticker[0]]
    dp2 = [0, sticker[1]]
    
    for i in range(2, len(sticker)-1):
        if dp[i-2]!=dp[i-1]:
            dp.append(dp[i-1])
        else:
            dp.append(max(dp[i-1], dp[i-2]+sticker[i]))
        if dp2[i-2]!=dp2[i-1]:
            dp2.append(dp2[i-1])
        else:
            dp2.append(max(dp2[i-1], dp2[i-2]+sticker[i]))
        
    return max(dp[-1], max(dp2[-1], dp2[i-2]+sticker[-1]))
