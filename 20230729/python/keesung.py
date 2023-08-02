
from collections import deque
def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    
    graph = [[0] * 102 for _ in range(102)]
    visited = [[False] * 102 for _ in range(102)]
    for (x1, y1, x2, y2) in rectangle:
        x1, y1, x2, y2 = map(lambda x: x*2, [x1, y1, x2, y2])
        for x in range(x1, x2+1):
            for y in range(y1, y2+1):
                graph[x][y] = 1
    dx = [1, 1, -1, -1, 0, 0, 1, -1]
    dy = [1, -1, 1, -1, 1, -1, 0, 0]
    for i in range(102):
        for j in range(102):
            if graph[i][j] == 1:
                for k in range(8):
                    nx = i + dx[k]
                    ny = j + dy[k]
                    if graph[nx][ny] == 0:
                        graph[i][j] = 2
                        break
    
    for row in graph:
        print(row)
    q = deque()
    q.append((characterX*2, characterY*2, 0))
    visited[characterX*2][characterY*2] = True
    while q:
        x, y, cnt = q.popleft()
        # print(x, y, cnt)
        if x == itemX*2 and y == itemY*2:
            answer = cnt // 2
            break
        for k in range(4,8):
            nx = x + dx[k]
            ny = y + dy[k]
            # if nx == 3 and ny == 8:
                # print("=====")
                # print(visited[ny][nx], graph[ny][nx])
                # print("=====")
            if visited[nx][ny] == False and graph[nx][ny] == 2:
                q.append((nx, ny, cnt+1))
                visited[nx][ny] = True
    
    return answer
    
rectangle = [[1,1,7,4],[3,2,5,5],[4,3,6,9],[2,6,8,8]]
print(solution(rectangle, 1, 3, 7, 8))

# 최대 시간 13.97ms
# 메모리 10.4MB