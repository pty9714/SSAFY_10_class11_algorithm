from collections import deque
dx = [1,-1,0,0]
dy = [0,0,1,-1]

TC = int(input())
for tc in range(1, TC+1):
    n = int(input())
    graph = [list(map(int, input())) for _ in range(n)]
    distance = [[1e9]*n for _ in range(n)]
    distance[0][0] = graph[0][0]
    deq = deque()
    deq.append((0,0))
    while deq:
        x, y = deq.popleft()
        for i in range(4):
            if 0 <= x + dx[i] < n and 0 <= y + dy[i] < n:
                if distance[y][x] + graph[y + dy[i]][x + dx[i]] < distance[y + dy[i]][x + dx[i]]:
                    distance[y + dy[i]][x + dx[i]] = graph[y + dy[i]][x + dx[i]] + distance[y][x]
                    deq.append((x + dx[i], y + dy[i]))
    print(f'#{tc} {distance[n-1][n-1]}')