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

# 테스트 1 〉	통과 (0.01ms, 10.2MB)
# 테스트 2 〉	통과 (0.01ms, 10.3MB)
# 테스트 3 〉	통과 (0.01ms, 10.4MB)
# 테스트 4 〉	통과 (0.01ms, 10.3MB)
# 테스트 5 〉	통과 (0.02ms, 10.2MB)
# 테스트 6 〉	통과 (0.03ms, 10.4MB)
# 테스트 7 〉	통과 (1.05ms, 10.2MB)
# 테스트 8 〉	통과 (1.21ms, 10.4MB)
# 테스트 9 〉	통과 (1.05ms, 10.3MB)
# 테스트 10 〉	통과 (1.06ms, 10.3MB)
# 테스트 11 〉	통과 (1.08ms, 10.4MB)
# 테스트 12 〉	통과 (1.31ms, 10.4MB)
# 테스트 13 〉	통과 (1.05ms, 10.2MB)
# 테스트 14 〉	통과 (2.09ms, 10.4MB)
# 테스트 15 〉	통과 (1.08ms, 10.4MB)
# 테스트 16 〉	통과 (1.10ms, 10.3MB)
# 테스트 17 〉	통과 (2.05ms, 10.3MB)
# 테스트 18 〉	통과 (2.07ms, 10.3MB)
# 테스트 19 〉	통과 (1.02ms, 10.3MB)
# 테스트 20 〉	통과 (1.43ms, 10.4MB)
# 테스트 21 〉	통과 (1.04ms, 10.2MB)
# 테스트 22 〉	통과 (1.95ms, 10.3MB)
# 테스트 23 〉	통과 (1.21ms, 10.3MB)
# 테스트 24 〉	통과 (1.78ms, 10.4MB)
# 테스트 25 〉	통과 (1.20ms, 10.3MB)
# 테스트 26 〉	통과 (1.37ms, 10.4MB)
# 테스트 27 〉	통과 (1.09ms, 10.3MB)
# 테스트 28 〉	통과 (1.03ms, 10.3MB)
# 테스트 29 〉	통과 (1.95ms, 10.4MB)
# 테스트 30 〉	통과 (1.08ms, 10.3MB)
# 테스트 31 〉	통과 (2.02ms, 10.2MB)
# 테스트 32 〉	통과 (1.03ms, 10.3MB)
# 테스트 33 〉	통과 (0.00ms, 10.3MB)
# 효율성  테스트
# 테스트 1 〉	통과 (107.68ms, 27.7MB)
# 테스트 2 〉	통과 (120.43ms, 27.8MB)
# 테스트 3 〉	통과 (112.08ms, 27.7MB)
# 테스트 4 〉	통과 (108.20ms, 27.7MB)