from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    graph = [[0] * 101 for i in range(101)]
    dx = [1,-1,0,0]
    dy = [0,0,1,-1]
    for x1, y1, x2, y2 in rectangle:
        for i in range(2*x1, 2*x2+1):
            for j in range(2*y1, 2*y2+1):
                graph[j][i] = 1
    
    for x1, y1, x2, y2 in rectangle:
        for i in range(2*x1+1, 2*x2):
            for j in range(2*y1+1, 2*y2):
                graph[j][i] = 0

    Cx = characterX *2
    Cy = characterY *2
    Ix = itemX *2
    Iy = itemY *2
    
    visited = [[0] * 101 for i in range(101)]
    visited[Cy][Cx] = 1
    queue = deque([(Cx, Cy)])
    
    while queue:
        x, y = queue.popleft()
        
        if x == Ix and y == Iy:
            answer = (graph[y][x] - 1) // 2
            break
        
        for i in range(4):
            mx = x + dx[i]
            my = y + dy[i]
            
            if 0 <= mx < 101 and 0 <= my < 101 and graph[my][mx] != 0 and visited[my][mx] == 0:
                graph[my][mx] = graph[y][x] + 1
                visited[my][mx] = 1
                queue.append((mx, my))
        
    return answer