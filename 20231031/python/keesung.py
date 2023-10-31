from collections import deque
N = int(input())

graph = [list(input()) for _ in range(N)]
visited = [[[False] * N for _ in range(N)] for _ in range(2)]

q_normal = deque()
result_normal = 0
q_abnormal = deque()
result_abnormal = 0
for i in range(N):
    for j in range(N):
        if visited[0][i][j] == False:
            q_normal.append([i, j])
            visited[0][i][j] = True
            result_normal += 1
            while q_normal:
                x, y = q_normal.popleft()
                for dx, dy in (1, 0), (-1, 0), (0, 1), (0, -1):
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < N and 0 <= ny < N:
                        if visited[0][nx][ny] == False and graph[x][y] == graph[nx][ny]:
                            q_normal.append([nx, ny])
                            visited[0][nx][ny] = True
        if visited[1][i][j] == False:
            q_abnormal.append([i, j])
            visited[1][i][j] = True
            result_abnormal += 1
            while q_abnormal:
                x, y = q_abnormal.popleft()
                for dx, dy in (1, 0), (-1, 0), (0, 1), (0, -1):
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < N and 0 <= ny < N:
                        if visited[1][nx][ny] == False:
                            if graph[x][y] == graph[nx][ny]:
                                q_abnormal.append([nx, ny])
                                visited[1][nx][ny] = True
                            elif graph[x][y] == 'R' and graph[nx][ny] == 'G':
                                q_abnormal.append([nx, ny])
                                visited[1][nx][ny] = True
                            elif graph[x][y] == 'G' and graph[nx][ny] == 'R':
                                q_abnormal.append([nx, ny])
                                visited[1][nx][ny] = True

print(result_normal, result_abnormal)

# 34136kb, 100ms