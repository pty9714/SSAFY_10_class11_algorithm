
def solution(n, costs):
    costs = sorted(costs, key=lambda x: x[2], reverse=True)
    visited = [0] * n
    if n == 1:
        return 0
    x, y, cost = costs.pop()
    visited[x] = 1
    visited[y] = 1
    answer = cost
    
    while sum(visited) < n:
        for i in range(len(costs)-1, -1, -1):
            x, y, cost = costs[i]
            if visited[x] == 1 and visited[y] == 1:
                continue
            elif visited[x] == 1 or visited[y] == 1:
                visited[x] = 1
                visited[y] = 1
                answer += cost
                costs.pop(i)
                break
            
            
                
    return answer


# 프림 알고리즘
# 테스트 1 〉	통과 (0.01ms, 10.2MB)
# 테스트 2 〉	통과 (0.01ms, 10.2MB)
# 테스트 3 〉	통과 (0.02ms, 10.2MB)
# 테스트 4 〉	통과 (0.03ms, 10.2MB)
# 테스트 5 〉	통과 (0.02ms, 10.3MB)
# 테스트 6 〉	통과 (0.04ms, 10.1MB)
# 테스트 7 〉	통과 (0.04ms, 10.2MB)
# 테스트 8 〉	통과 (0.01ms, 10.2MB)