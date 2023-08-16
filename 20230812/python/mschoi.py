inf, edge = [], []
visited = [0 for _ in range(18)]
answer = []

def dfs(sheep, wolf):
    global inf, edg, visited, answer
    if sheep <= wolf:
        return
    else:
        answer.append(sheep)
    
    for parent, child in edg:
        # 부모는 방문, 자식은 방문X
        if visited[parent] and not visited[child]:
            visited[child] = 1
            if inf[child] == 0: # 양이면
                dfs(sheep+1, wolf)
            else: # 늑대이면
                dfs(sheep, wolf+1)
            visited[child] = 0 # 백트래킹
    

def solution(info, edges):
    global inf, edg, answer
    inf, edg = info, edges
    
    # 루트 노드
    visited[0] = 1
    dfs(1, 0)
    
    return max(answer)

# 테스트 17 〉	통과 (13.50ms, 10.3MB)
