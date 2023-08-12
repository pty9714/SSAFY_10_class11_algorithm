def solution(info, edges):
    answer = 0
    visited = [0] * len(info)
    visited[0] = 1
    def dfs(sheep, wolf):
        nonlocal answer
        if sheep > wolf:
            answer = max(answer, sheep)
        else:
            return
        for parent, child in edges:
            iswolf = info[child]
            if visited[parent] and not visited[child]:
                visited[child] = 1
                if iswolf:
                    dfs(sheep, wolf + 1)
                else:
                    dfs(sheep + 1, wolf)
                visited[child] = 0
    dfs(1, 0)
    return answer