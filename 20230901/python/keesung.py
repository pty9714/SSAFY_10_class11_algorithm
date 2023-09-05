def solution(arr):
    arr = [int(arr[x]) if x % 2 == 0 else arr[x] for x in range(len(arr))]
    INF = 10e9
    max_dp = [[-INF] * (len(arr) // 2 + 1) for _ in range(len(arr) // 2 + 1)]
    min_dp = [[INF] * (len(arr) // 2 + 1) for _ in range(len(arr) // 2 + 1)]
    
    for i in range(len(arr) // 2 + 1):
        max_dp[i][i] = arr[i * 2]
        min_dp[i][i] = arr[i * 2]
    
    for cnt in range(1, len(arr) // 2+1):
        for i in range(len(arr) // 2+1):
        # for j in range(i+1, len(arr) // 2 + 1):
            j = i + cnt
            if j > len(arr) // 2:
                continue
            for k in range(i, j):
                if arr[k*2+1] == '+':
                    max_dp[i][j] = max(max_dp[i][j], max_dp[i][k] + max_dp[k+1][j])
                    min_dp[i][j] = min(min_dp[i][j], min_dp[i][k] + min_dp[k+1][j])
                else:
                    max_dp[i][j] = max(max_dp[i][j], max_dp[i][k] - min_dp[k+1][j])
                    min_dp[i][j] = min(min_dp[i][j], min_dp[i][k] - max_dp[k+1][j])
    answer = max_dp[0][-1]
    # print(max_dp)
    # print(min_dp)
    return answer


# print(solution(["1", "-", "3", "+", "5", "-", "8"]))

# 테스트 1 〉	통과 (0.24ms, 10.3MB)
# 테스트 2 〉	통과 (0.31ms, 10.4MB)
# 테스트 3 〉	통과 (0.23ms, 10.5MB)
# 테스트 4 〉	통과 (0.23ms, 10.5MB)
# 테스트 5 〉	통과 (0.23ms, 10.3MB)
# 테스트 6 〉	통과 (0.23ms, 10.4MB)
# 테스트 7 〉	통과 (0.38ms, 10.3MB)
# 테스트 8 〉	통과 (0.46ms, 10.4MB)
# 테스트 9 〉	통과 (0.07ms, 10.6MB)
# 테스트 10 〉	통과 (0.03ms, 10.4MB)
# 효율성  테스트
# 테스트 1 〉	통과 (218.30ms, 10.7MB)
# 테스트 2 〉	통과 (115.01ms, 10.6MB)
# 테스트 3 〉	통과 (110.94ms, 10.6MB)
# 테스트 4 〉	통과 (168.14ms, 10.6MB)
# 테스트 5 〉	통과 (111.73ms, 10.7MB)
# 테스트 6 〉	통과 (203.11ms, 10.6MB)
# 테스트 7 〉	통과 (215.53ms, 10.7MB)
# 테스트 8 〉	통과 (209.02ms, 10.6MB)


# 업데이트의 개념을 1~2, 2~3, 3~4 를 한 다음 1~3, 2~4를 해주는 방식을 적용해줘야 함.