
# dp로 풀이
# [t1 ~ t2 범위]

def solution(temperature, t1, t2, a, b, onboard):
    MAX_VALUE = 1000000000
    if t1 <= temperature <= t2:
        answer = 0
        return answer
    elif temperature < t1:
        temperature = t2 + (t1 - temperature)
    # dp[분][온도]
    dp = [[MAX_VALUE] * (temperature - t1 + 1) for _ in range(len(onboard))]
    dp[0][-1] = 0
    for i in range(1, len(onboard)):
        if onboard[i] == 1:
            Range = range(t2 + 1 - t1)
        else:
            Range = range(temperature + 1 - t1)
        for j in Range:
            if j == temperature - t1:
                dp[i][j] = min(dp[i-1][j-1], dp[i-1][j])
            else:
                min_list = [dp[i-1][j+1] + a, dp[i-1][j] + b]
                if j > 0:
                    min_list.append(dp[i-1][j-1])
                
                dp[i][j] = min(min_list)
    
    answer = min(dp[-1])
    return answer

# print(solution(28, 18, 26, 10, 8, [0, 0, 1, 1, 1, 1, 1]))

# 테스트 1 〉	통과 (0.05ms, 10.4MB)
# 테스트 2 〉	통과 (12.47ms, 10.5MB)
# 테스트 3 〉	통과 (6.09ms, 10.5MB)
# 테스트 4 〉	통과 (0.06ms, 10.3MB)
# 테스트 5 〉	통과 (0.07ms, 10.2MB)
# 테스트 6 〉	통과 (0.06ms, 10.5MB)
# 테스트 7 〉	통과 (0.03ms, 10.4MB)
# 테스트 8 〉	통과 (0.08ms, 10.2MB)
# 테스트 9 〉	통과 (0.08ms, 10.4MB)
# 테스트 10 〉	통과 (3.25ms, 10.4MB)
# 테스트 11 〉	통과 (1.77ms, 10.4MB)
# 테스트 12 〉	통과 (2.04ms, 10.3MB)
# 테스트 13 〉	통과 (11.19ms, 10.6MB)
# 테스트 14 〉	통과 (28.41ms, 10.5MB)
# 테스트 15 〉	통과 (13.26ms, 11MB)
# 테스트 16 〉	통과 (21.99ms, 10.5MB)
# 테스트 17 〉	통과 (13.06ms, 10.7MB)
# 테스트 18 〉	통과 (2.70ms, 10.2MB)
# 테스트 19 〉	통과 (17.50ms, 10.4MB)
# 테스트 20 〉	통과 (16.28ms, 10.9MB)
# 테스트 21 〉	통과 (18.81ms, 11.2MB)
# 테스트 22 〉	통과 (29.08ms, 10.3MB)
# 테스트 23 〉	통과 (29.66ms, 10.4MB)
# 테스트 24 〉	통과 (31.39ms, 11.9MB)
# 테스트 25 〉	통과 (29.96ms, 11.9MB)