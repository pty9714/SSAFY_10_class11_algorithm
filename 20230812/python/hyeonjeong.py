def solution(info, edges):
    visited = [False] * len(info)
    
    answer = [] # 가능한 모든 양의 개수
    def dfs(sheep, wolf):
        # 늑대가 양 잡아먹으면 실패
        if sheep <= wolf:
            return
        # 양의 수가 더 많을 때 추가 (끝나는 노드가 정해져 있지 않음)
        else:
            answer.append(sheep)
        
        for p, c in edges:
            # 아직 방문하지 않은 자식 노드가 있으면 방문하고, 양 또는 늑대일 때 경우 계산
            if visited[p] and not visited[c]:
                visited[c] = True
                if info[c] == 0:
                    dfs(sheep + 1, wolf)
                elif info[c] == 1:
                    dfs(sheep, wolf + 1)
                visited[c] = False
    
    visited[0] = True
    dfs(1, 0)
    
    return max(answer)

# 테스트 17 〉	통과 (11.95ms, 10.2MB)
