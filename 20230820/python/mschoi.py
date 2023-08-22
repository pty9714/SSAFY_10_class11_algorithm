def solution(alp, cop, problems):
    answer = -1
    INF = 987654321
    # 최대 alp, cop 구하기
    maxAlp, maxCop = -1, -1
    for pr in problems:
        maxAlp = max(maxAlp, pr[0])
        maxCop = max(maxCop, pr[1])
    alp, cop = min(alp, maxAlp), min(cop, maxCop)
    graph = [[INF for _ in range(maxCop+1)] for _ in range(maxAlp+1)]
    problems = sorted(problems, key=lambda x : (x[0], x[1]))
    
    # 초기화
    count = 0
    for i in range(alp, maxAlp+1):
        graph[i][cop] = count
        count += 1
    count = 0
    for i in range(cop, maxCop+1):
        graph[alp][i] = count
        count += 1
    
    # 행 순회하면서 dp배열 채우기
    for i in range(alp, maxAlp+1):
        for j in range(cop, maxCop+1):
            # 직전 칸에서의 문제해결, 독학, 직전 칸으로부터 독학 중 가장 작은 값으로 갱신
            if i+1 <= maxAlp:
                graph[i+1][j] = min(graph[i+1][j], graph[i][j]+1)
            if j+1 <= maxCop:
                graph[i][j+1] = min(graph[i][j+1], graph[i][j]+1)
            
            for pb in problems:
                if i >= pb[0] and j >= pb[1]:
                    nextAlp, nextCop = min(maxAlp, i+pb[2]), min(maxCop, j+pb[3])
                    graph[nextAlp][nextCop] = min(graph[nextAlp][nextCop], graph[i][j]+pb[4])
            
    return graph[maxAlp][maxCop]

# 정확성  테스트
테스트 1 〉	통과 (0.20ms, 10.3MB)
테스트 2 〉	통과 (0.25ms, 10.4MB)
테스트 3 〉	통과 (0.09ms, 10.4MB)
테스트 4 〉	통과 (0.04ms, 10.4MB)
테스트 5 〉	통과 (0.16ms, 10.2MB)
테스트 6 〉	통과 (0.22ms, 10.3MB)
테스트 7 〉	통과 (0.05ms, 10.3MB)
테스트 8 〉	통과 (0.04ms, 10.3MB)
테스트 9 〉	통과 (0.08ms, 10.4MB)
테스트 10 〉	통과 (0.05ms, 10.3MB)
# 효율성  테스트
테스트 1 〉	통과 (19.19ms, 10.4MB)
테스트 2 〉	통과 (31.41ms, 10.4MB)
테스트 3 〉	통과 (4.41ms, 10.4MB)
테스트 4 〉	통과 (22.54ms, 10.5MB)
테스트 5 〉	통과 (143.18ms, 10.4MB)
테스트 6 〉	통과 (35.89ms, 10.4MB)
테스트 7 〉	통과 (205.56ms, 10.3MB)
테스트 8 〉	통과 (148.05ms, 10.3MB)
테스트 9 〉	통과 (360.37ms, 10.3MB)
테스트 10 〉	통과 (5.77ms, 10.4MB)
