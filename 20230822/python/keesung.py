from collections import deque
T = int(input())

dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]
queue = deque()
for test_case in range(1, T+1):
    graph = [input().split() for _ in range(4)]
    case = set()
    for i in range(4):
        for j in range(4):
            queue.append((i, j, graph[i][j]))
            while queue:
                x, y, num = queue.popleft()
                if len(num) == 7:
                    case.add(num)
                    continue
                for k in range(4):
                    nx, ny = x + dx[k], y + dy[k]
                    if 0 <= nx < 4 and 0 <= ny < 4:
                        queue.append((nx, ny, num + graph[nx][ny]))
    print(f'#{test_case} {len(case)}')
        
        
# 70,524 kb, 359 ms