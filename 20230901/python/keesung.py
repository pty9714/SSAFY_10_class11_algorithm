def solution(arr):
    arr = [int(arr[x]) if x % 2 == 0 else arr[x] for x in range(len(arr))]
    max_dp = [0] * (len(arr) // 2 + 1)
    min_dp = [0] * (len(arr) // 2 + 1)
    
    max_dp[-1] = arr[-1]
    min_dp[-1] = arr[-1]
    
    for i in range(len(arr) // 2 - 1, -1, -1):
        index = i * 2
        text = index + 1
        if text == "+":
            max_dp[i] += max_dp[i+1]  + arr[index]
            min_dp[i] += min_dp[i+1]  + arr[index]
        else:
            max_dp[i] = arr[index] - min_dp[i+1]
            min_dp[i] = arr[index] - max_dp[i+1]
    answer = max_dp[0]
    print(max_dp)
    print(min_dp)    
    return answer


print(solution(["1", "-", "3", "+", "5", "-", "8"]))