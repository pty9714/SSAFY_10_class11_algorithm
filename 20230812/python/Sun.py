def solution(info, edges):
    visited = [0] * len(info)
    answer = []
    
    def dfs(sheep, wolf):
        if sheep > wolf:
            answer.append(sheep)
        else:
            return 
        
        for p, c in edges:
            if visited[p] and not visited[c]:
                visited[c] = 1
                if info[c] == 0:
                    dfs(sheep+1, wolf)
                else:
                    dfs(sheep, wolf+1)
                visited[c] = 0

    visited[0] = 1
    dfs(1, 0)

    return max(answer)

# 테스트 1 〉	통과 (0.01ms, 10MB)
# 테스트 2 〉	통과 (0.13ms, 10.1MB)
# 테스트 3 〉	통과 (0.01ms, 10.2MB)
# 테스트 4 〉	통과 (0.01ms, 10.2MB)
# 테스트 5 〉	통과 (0.74ms, 10.2MB)
# 테스트 6 〉	통과 (0.41ms, 10.3MB)
# 테스트 7 〉	통과 (0.06ms, 10MB)
# 테스트 8 〉	통과 (0.05ms, 10.2MB)
# 테스트 9 〉	통과 (0.40ms, 9.93MB)
# 테스트 10 〉	통과 (5.99ms, 9.98MB)
# 테스트 11 〉	통과 (0.13ms, 10.1MB)
# 테스트 12 〉	통과 (1.32ms, 10.3MB)
# 테스트 13 〉	통과 (0.03ms, 10.1MB)
# 테스트 14 〉	통과 (0.06ms, 10MB)
# 테스트 15 〉	통과 (0.43ms, 10MB)
# 테스트 16 〉	통과 (0.74ms, 10.1MB)
# 테스트 17 〉	통과 (13.04ms, 10.4MB)
# 테스트 18 〉	통과 (0.35ms, 10.2MB)