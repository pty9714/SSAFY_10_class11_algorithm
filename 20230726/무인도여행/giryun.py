from collections import deque   


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def solution(maps):
    answer = []
    n, m = len(maps), len(maps[0])
    visited = [[0]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if maps[i][j] != 'X' and not visited[i][j]:
                q = deque()
                q.append((i, j))
                visited[i][j] = 1
                res = int(maps[i][j])
                while q:
                    x, y = q.popleft()
                    for d in range(4):
                        nx, ny = x + dx[d], y + dy[d]
                        if 0 <= nx < n and 0 <= ny < m:
                            if maps[nx][ny] != 'X' and not visited[nx][ny]:
                                q.append((nx, ny))
                                visited[nx][ny] = 1
                                res += int(maps[nx][ny])
                answer.append(res)
    answer.sort()
    return answer if answer else [-1]