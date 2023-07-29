
from collections import deque
def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    
    graph = [[0] * 52 for _ in range(52)]
    visited = [[False] * 52 for _ in range(52)]
    for x1, y1, x2, y2 in rectangle:
        for x in range(x1, x2+1):
            for y in range(y1, y2+1):
                graph[y][x] = 1
                
    # print(graph[4][1])
    dx = [0, 1, 0, -1, 1, 1, -1, -1]
    dy = [-1, 0, 1, 0, -1, 1, 1, -1]
    for x1, y1, x2, y2 in rectangle:
        for x in range(x1, x2+1):
            for y in range(y1, y2+1):
                for i in range(8):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    if graph[ny][nx] == 0:
                        graph[y][x] = 2
                        continue
    
    queue = deque()
    queue.append((characterX, characterY, 0))
    visited[y][x] = True
    while queue:
        x, y, num= queue.popleft()
        print(x, y, num)
        if x == itemX and y == itemY:
            answer = num
            break
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if graph[ny][nx] == 2 and not visited[ny][nx]:
                queue.append((nx, ny, num + 1))
                visited[ny][nx] = True
        
    
    return answer
    
rectangle = [[1,1,7,4],[3,2,5,5],[4,3,6,9],[2,6,8,8]]
print(solution(rectangle, 1, 3, 7, 8))