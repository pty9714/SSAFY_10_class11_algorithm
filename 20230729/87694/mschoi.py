from collections import deque

maps = [[False for _ in range(102)] for _ in range(102)]
visited = [[False for _ in range(102)] for _ in range(102)]
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs(startX, startY, targetX, targetY):
    q = deque()
    q.append([startX, startY, 0])
    visited[startX][startY] = True
    
    while q:
        cx, cy, cnt = q.popleft()
        
        for dxx, dyy in zip(dx, dy):
            nx, ny = cx+dxx, cy+dyy
            if nx == targetX and ny == targetY:
                return cnt+1
            
            if 0 <= nx < 102 and 0 <= ny < 102:
                if visited[nx][ny] or maps[nx][ny] == False:
                    continue
                visited[nx][ny] = True
                q.append([nx, ny, cnt+1])
                
    

def solution(rectangle, characterX, characterY, itemX, itemY):
    global maps
    
    for item in rectangle:
        # 꼬불한 경로 최단거리 오해 -> 2배로 확대
        lx, ly, ux, uy = item[0]*2, item[1]*2, item[2]*2, item[3]*2
        
        # 테두리 색칠
        for i in range(lx, ux+1):
            maps[ly][i] = True
            maps[uy][i] = True
        for j in range(ly, uy+1):
            maps[j][lx] = True
            maps[j][ux] = True

    # 내부 공백으로 다시 색칠
    for item in rectangle:
        lx, ly, ux, uy = item[0]*2, item[1]*2, item[2]*2, item[3]*2
        for i in range(lx+1, ux):
            for j in range(ly+1, uy):
                maps[j][i] = False

    # BFS로 따라가면서 탐색
    return bfs(characterY*2, characterX*2, itemY*2, itemX*2) // 2

---
# 테스트 11 〉	통과 (0.97ms, 10.4MB)
