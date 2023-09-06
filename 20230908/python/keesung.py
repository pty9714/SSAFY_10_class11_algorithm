from collections import deque
M, N = map(int, input().split())

graph = [list(map(int, input())) for _ in range(N)]
visited = [[False] * M for _ in range(N)]
visited[0][0] = True
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

q = deque()
q.append([0, 0])

cnt = 0
while True:
    next_q = []
    while q:
        x, y = q.popleft()
        for nx, ny in zip(dx, dy):
            new_x, new_y = x + nx, y + ny
            if 0 <= new_x < N and 0 <= new_y < M:
                if not visited[new_x][new_y]:
                    visited[new_x][new_y] = True
                    if graph[new_x][new_y] == 1:
                        next_q.append([new_x, new_y])
                    else:
                        q.append([new_x, new_y])
    
    if visited[-1][-1]:
        break
    q = deque(next_q)
    cnt += 1
print(cnt)

# bfs
# 두개의 큐로 관리, 현재 갈수 있는 곳 모두 방문 
# 다음에 갈 수 있는곳 저장 했다가, 현재 갈수 있는 곳이 비면 다음 갈 수 있는 곳 방문

# 메모리 34160kb 시간 92ms



# 예전에 풀었던 코드 (우선순위 큐 이용)
import heapq
from heapq import heappop, heappush
N, M = map(int, input().split())
graph = [list(map(int, input())) for _ in range(M)]
visited = set()
queue = [(0, 0, 0)]
while queue:
    cost, row, col = heappop(queue)
    if (row, col) in visited:
        continue
    else:
        visited.add((row, col))
    if row == M - 1 and col == N - 1:
        break
    if row < M - 1 and (row + 1, col) not in visited: # 밑으로 이동
        heappush(queue, (cost + graph[row + 1][col], row + 1, col))
    if row > 0 and (row - 1, col) not in visited: # 위로 이동
        heappush(queue, (cost + graph[row - 1][col], row - 1, col))
    if col < N - 1 and (row, col + 1) not in visited: # 오른쪽 이동
        heappush(queue, (cost + graph[row][col + 1], row, col + 1))
    if col > 0 and (row, col - 1) not in visited: # 왼쪽 이동
        heappush(queue, (cost + graph[row][col - 1], row, col - 1))

print(cost)

# 메모리 32908, 시간 108ms