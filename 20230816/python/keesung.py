from collections import deque
T = int(input())
dx = [0, 1, 0, -1, -1, 1, 1, -1]
dy = [1, 0, -1, 0, 1, 1, -1, -1]
for test_case in range(1, T + 1):
    N = int(input())
    graph = [[0] * N for _ in range(N)]
    visited = [[False] * N for _ in range(N)]
    for i in range(N):
        text = list(input())
        for j in range(N):
            if text[j] == '*':
                visited[i][j] = True
                for k in range(8):
                    nx, ny = i + dx[k], j + dy[k]
                    if 0 <= nx < N and 0 <= ny < N:
                        graph[nx][ny] += 1
    
    queue = deque()
    visit_num = 0
    for i in range(N):
        for j in range(N):
            if visited[i][j] == False and graph[i][j] == 0:
                queue.append((i, j))
                visited[i][j] = True
                visit_num += 1
            while queue:
                x, y = queue.popleft()
                if graph[x][y] == 0:
                    for k in range(8):
                        nx, ny = x + dx[k], y + dy[k]
                        if 0 <= nx < N and 0 <= ny < N:
                            if not visited[nx][ny]:
                                queue.append((nx, ny))
                                visited[nx][ny] = True
            # print(visit_num)
            # print(visited)
    
    for i in range(N):
        for j in range(N):
            if not visited[i][j] and graph[i][j] != '*':
                visit_num += 1
    print('#{} {}'.format(test_case, visit_num))


# 구현
# 69844kb, 449ms
# 1. 8방향 탐색을 하면서 주변에 지뢰가 없는 곳을 찾는다.
# 2. 지뢰가 없는 곳이 있으면 큐에 넣고, 방문처리를 한다. (+1은 이때만)
# 3. 주변을 8방탐색 하여 모두 넣고 방문 처리를 한다.
# 4. 큐가 빌때까지 반복한다.
# 5. 이후 방문하지 않은 곳을 찾아서 방문처리를 한다. (+1 하나당 한개씩)
