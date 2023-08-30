def solution(sticker):
    if len(sticker) == 1:
        return sticker[0]
    dp = [[0, 0, 0, 0] for _ in range(len(sticker)+1)] # 처음껄 뗀 뒤 [뗀, 안뗀, + 처음꺼 안땐 뒤 뗀, 안뗀]
    dp[1][0] = sticker[0]
    for index, num in enumerate(sticker[1:-1]):
        index += 2
        dp[index][0] = dp[index-1][1] + num
        dp[index][1] = max(dp[index-1][1], dp[index-1][0])
        dp[index][2] = dp[index-1][3] + num
        dp[index][3] = max(dp[index-1][3], dp[index-1][2])
    dp[-1][0] = dp[-2][0]
    dp[-1][1] = dp[-2][1]
    dp[-1][2] = dp[-2][3] + sticker[-1]
    dp[-1][3] = max(dp[-2][3], dp[-2][2])
    answer = max(dp[-1])
    return answer

print(solution([14, 6, 5, 11, 3, 9, 2, 10]))

# dp
# 처음 배열을 나누는 기준
# index 0 : 처음껄 뗀 뒤 현재 위치걸 뗀 경우
# index 1 : 처음껄 뗀 뒤 현재 위치 안뗀 경우
# index 2 : 처음껄 안뗀 뒤 현재 위치걸 뗀 경우
# index 3 : 처음껄 안뗀 뒤 현재 위치 안뗀 경우