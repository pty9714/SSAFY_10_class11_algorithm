from collections import deque


dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]


def solution(rectangle, characterX, characterY, itemX, itemY):
    characterX *= 2
    characterY *= 2
    itemX *= 2
    itemY *= 2
    answer = 0
    n = 102
    B = [[5] * n for _ in range(n)]
    for rec in rectangle:
        x1, y1, x2, y2 = map(lambda x: x * 2, rec)
        for i in range(x1, x2 + 1):
            for j in range(y1, y2 + 1):
                if x1 < i < x2 and y1 < j < y2:
                    B[i][j] = 0
                elif B[i][j] != 0: 
                    B[i][j] = 1 
    q = deque()
    q.append([characterX, characterY])
    visited = [[0] * n for _ in range(n)]
    visited[characterX][characterY] = 1
    while q:
        x, y = q.popleft()
        if x == itemX and y == itemY:
            answer = (visited[x][y] - 1) // 2
            break
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if visited[nx][ny] == 0 and B[nx][ny] == 1:
                q.append([nx, ny])
                visited[nx][ny] = visited[x][y] + 1
    return answer