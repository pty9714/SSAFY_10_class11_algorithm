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