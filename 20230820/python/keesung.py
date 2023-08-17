def solution(alp, cop, problems):
    max_alp = alp
    max_cop = cop
    problems = sorted(problems, key=lambda x: x[4])
    problems = sorted(problems, key=lambda x: x[3])
    for problem in problems:
        max_alp, max_cop = max(max_alp, problem[0]), max(max_cop, problem[1])
    dp = [[0] * (max_cop + 1) for _ in range(max_alp + 1)] # dp[alp][cop]
    
    # 최초 입력
    for j in range(cop+1, max_cop + 1):
        dp[alp][j] = dp[alp][j-1] + 1
    for i in range(alp+1, max_alp + 1):
        dp[i][cop] = dp[i-1][cop] + 1
        for j in range(cop+1, max_cop + 1):
            dp[i][j] = dp[i][j-1] + 1
    
    # for i, line in enumerate(dp):
    #     print(i, line)   
    for i in range(alp, max_alp + 1):
        for j in range(cop, max_cop + 1):
            for problem in problems:
                alp_req, cop_req, alp_rwd, cop_rwd, cost = problem
                if i >= alp_req and j >= cop_req:
                    ni, nj = min(max_alp, i+alp_rwd), min(max_cop, j+cop_rwd)
                    # if ni == 12 and nj == 16:
                        # print(dp[ni][nj])
                        # print(dp[i][j] + cost)
                        # print('---------')
                    dp[ni][nj] = min(dp[ni][nj], dp[i][j] + cost)
    # for i, line in enumerate(dp):
    #     print(i, line)   
    answer = dp[-1][-1]                    
    
    
    return answer

# print(solution(10, 10, [[20,20,3,3,4], [10,15,2,1,2]]))
# print(solution(0, 0, [[0,0,2,1,2],[4,5,3,1,2],[4,11,4,0,2],[10,4,0,4,2]]))

# print(solution(0, 0, [[0, 0, 1, 1, 1], [150, 150, 1, 1, 100]]))
# print(solution(0, 0, [[4, 3, 1, 1, 100], [0, 0, 2, 2, 1]]))
# print(solution(1, 1, [[0, 2, 1, 1, 100]]))