from collections import deque

N = int(input())

graph = [list(map(int, list(input()))) for _ in range(N)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

number = 1
result = []
for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            number += 1
            graph[i][j] = number
            q = deque()
            q.append([i,j])
            cnt = 1
            while q:
                x, y = q.popleft()
                for nx, ny in zip(dx, dy):
                    nx += x
                    ny += y
                    if 0 <= nx < N and 0 <= ny < N:
                        if graph[nx][ny] == 1:
                            graph[nx][ny] = number
                            cnt += 1
                            q.append([nx, ny])
            result.append(cnt)

result.sort()
print(len(result))
for i in result:
    print(i)

# 메모리 34160 시간 68ms
