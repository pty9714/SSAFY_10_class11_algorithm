def solution(sticker):
    answer = 0
    
    if len(sticker) == 1:
        return sticker[0]
    
    # 첫번째 칸을 뜯었을 경우
    dp = [0 for _ in range(len(sticker))]
    dp[0], dp[1] = sticker[0], sticker[0]
    for i in range(2, len(sticker)-1): # 마지막 칸 뜯을 수 X
        dp[i] = max(dp[i-1], dp[i-2]+sticker[i])
    answer = max(answer, dp[len(sticker)-1], dp[len(sticker)-2])
    
    # 첫번째 칸을 뜯지 X
    dp = [0 for _ in range(len(sticker))]
    dp[0], dp[1] = 0, sticker[1]
    for i in range(2, len(sticker)):
        dp[i] = max(dp[i-1], dp[i-2]+sticker[i])
    answer = max(answer, dp[len(sticker)-1], dp[len(sticker)-2])

    return answer

# 테스트 2 〉	통과 (72.94ms, 14.4MB)
