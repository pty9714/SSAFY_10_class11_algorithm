def solution(N, number):
    dp = [[] for _ in range(9)]
    for i in range(1,9):
        dp[i].append(int(str(N)*i))
        for j in range(1,i):
            for num1 in dp[j]:
                for num2 in dp[i-j]:
                    dp[i].append(num1+num2)
                    dp[i].append(num1-num2)
                    dp[i].append(num1*num2)
                    if num2 != 0:
                        dp[i].append(num1//num2)

        dp[i] = list(set(dp[i]))
        if number in dp[i] :
            return i
        
    return -1

# 테스트 1 〉	통과 (1.17ms, 10.5MB)
# 테스트 2 〉	통과 (0.03ms, 10.5MB)
# 테스트 3 〉	통과 (0.04ms, 10.2MB)
# 테스트 4 〉	통과 (26.89ms, 14.4MB)
# 테스트 5 〉	통과 (15.01ms, 13.2MB)
# 테스트 6 〉	통과 (0.22ms, 10.4MB)
# 테스트 7 〉	통과 (0.37ms, 10.4MB)
# 테스트 8 〉	통과 (24.88ms, 14.4MB)
# 테스트 9 〉	통과 (0.03ms, 10.4MB)