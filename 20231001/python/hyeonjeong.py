from collections import deque

def solution(n, roads, sources, destination):
    result = []
    
    nodes = [[] for i in range(n+1)]
    for road in roads:
        nodes[road[0]].append(road[1])
        nodes[road[1]].append(road[0])
    
    distance = [-1 for i in range(n+1)]
    queue = deque()
    queue.append([destination, 0])

    while queue:
        x, cnt = queue.popleft()
        if distance[x] == -1 or distance[x] > cnt:
            distance[x] = cnt
        for i in nodes[x]:
            if distance[i] == -1:
                queue.append([i, cnt+1])
                
    for source in sources:
        result.append(distance[source])
            
    return result

# 테스트 11 〉	통과 (4049.90ms, 161MB)
