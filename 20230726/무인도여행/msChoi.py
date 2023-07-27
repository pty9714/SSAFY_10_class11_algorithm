from collections import deque

vis = [[False for i in range(101)] for j in range(101)]

def bfs(row, col, maps):
    global vis
    vis[row][col] = True
    
    if maps[row][col] == "X":
        return 0
    
    q = deque()
    item = int(maps[row][col])
    q.append([row, col, item])
    
    val = 0
    while(q):
        curRow, curCol, tot = q.popleft()
        vis[curRow][curCol] = True
        val += tot
        dx, dy = [0, 0, -1, 1], [1, -1, 0, 0]
        
        for dxx, dyy in zip(dx,dy):
            nxtRow, nxtCol = curRow + dxx, curCol + dyy

            if 0 <= nxtRow < len(maps) and 0 <= nxtCol < len(maps[0]):
                if maps[nxtRow][nxtCol] != "X" and vis[nxtRow][nxtCol] == False:
                    nxtItem = int(maps[nxtRow][nxtCol])
                    q.append([nxtRow, nxtCol, nxtItem])
                    vis[nxtRow][nxtCol] = True
    return val


def solution(maps):
    global vis
    
    answer = []
    row, col = len(maps), len(maps[0])
    
    # BFS
    for i in range(row):
        for j in range(col):
            if vis[i][j] == False:
                val = bfs(i,j,maps)
                if val > 0:
                    answer.append(val)
    
    if len(answer) == 0:
        answer.append(-1)
        
    answer.sort()
    return answer

---
# 테스트 18 〉	통과 (20.08ms, 10.5MB)
