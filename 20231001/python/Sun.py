from collections import deque
def solution(n, roads, sources, destination):
    graph = [[] for _ in range(n+1)]
    for a,b in roads:
        graph[a].append(b)
        graph[b].append(a)
    answer = []
    for source in sources:
        visited = [0] *(n+1)
        queue = deque()
        queue.append((source,0))
        while queue:
            k,num = queue.popleft()
            if k == destination:
                answer.append(visited[k])
                break
            for i in graph[k]:
                if visited[i] == 0:
                    visited[i] = num+1
                    queue.append((i,num+1))
        else:
            answer.append(-1)

    return answer

n = 5
r = [[1, 2], [1, 4], [2, 4], [2, 5], [4, 5]]
s = [1, 3, 5]
d = 5

print(solution(n,r,s,d))


# 테스트 1 〉	통과 (0.02ms, 10.4MB)
# 테스트 2 〉	통과 (0.01ms, 10.2MB)
# 테스트 3 〉	통과 (0.02ms, 10.2MB)
# 테스트 4 〉	통과 (0.01ms, 10.3MB)
# 테스트 5 〉	통과 (0.02ms, 10.2MB)
# 테스트 6 〉	통과 (615.02ms, 16.3MB)
# 테스트 7 〉	통과 (1584.82ms, 16.9MB)
# 테스트 8 〉	통과 (1995.76ms, 22.1MB)
# 테스트 9 〉	통과 (53.56ms, 14MB)
# 테스트 10 〉	통과 (307.90ms, 14.3MB)
# 테스트 11 〉	실패 (시간 초과)
# 테스트 12 〉	실패 (시간 초과)
# 테스트 13 〉	실패 (시간 초과)
# 테스트 14 〉	실패 (시간 초과)
# 테스트 15 〉	실패 (시간 초과)
# 테스트 16 〉	통과 (113.16ms, 38.8MB)