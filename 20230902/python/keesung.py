from collections import deque
N = int(input())

answer = 10e9

dx = [-1, 1, 0 ,0]
dy = [0, 0, -1, 1]

graph = [list(map(int, input().split())) for _ in range(N)]

for row in range(N):
    for col in range(N):
        for d1 in range(1, N-1):
            for d2 in range(1, N-1):
                corners = [[row, col], [row+d1, col-d1], [row+d2, col+d2], [row+d1+d2, col-d1+d2]]
                signal = True
                for x, y in corners:
                    if x < 0 or y < 0 or x >= N or y >= N:
                        signal = False
                        break
                if signal:
                    values = [0] * 6
                    new_graph = [[0] * N for _ in range(N)]
                    for i in range(d1):
                        new_graph[row+i][col-i] = 5
                        new_graph[corners[2][0]+i][corners[2][1]-i] = 5
                    for i in range(d2):
                        new_graph[row+i][col+i] = 5
                        new_graph[corners[1][0]+i][corners[1][1]+i] = 5
                    new_graph[corners[3][0]][corners[3][1]] = 5
                    q = deque()
                    q.append([row+1, col])
                    new_graph[row+1][col] = 5
                    while q:
                        x, y = q.popleft()
                        for nx, ny in zip(dx, dy):
                            new_x = x + nx
                            new_y = y + ny
                            if 0 <= new_x < N and 0 <= new_y < N:
                                if new_graph[new_x][new_y] == 0:
                                    new_graph[new_x][new_y] = 5
                                    q.append([new_x, new_y])
                                    
                    if d1 == 1 or d2 == 1:
                        for x in range(N):
                            for y in range(N):
                                
                                signal = True
                                for nx, ny in zip(dx, dy):
                                    new_x = x + nx
                                    new_y = y + ny
                                    if 0 <= new_x < N and 0 <= new_y < N:
                                        if new_graph[new_x][new_y] != 5:
                                            signal = False
                                            break
                                    else:
                                        signal = False
                                        break
                                if signal:
                                    new_graph[x][y] = 5
                    
                    test_graph = [[0] * N for _ in range(N)]
                    for x in range(N):
                        for y in range(N):
                            if new_graph[x][y] == 5:
                                values[5] += graph[x][y]
                                test_graph[x][y] = 5
                            # 1번 경우
                            elif x < corners[1][0] and y <= corners[0][1]:
                                values[1] += graph[x][y]
                                test_graph[x][y] = 1
                            # 2번 경우
                            elif x <= corners[2][0] and y > corners[0][1]:
                                values[2] += graph[x][y]
                                test_graph[x][y] = 2
                            # 3번 경우
                            elif y < corners[3][1]:
                                values[3] += graph[x][y]
                                test_graph[x][y] = 3
                            else:
                                values[4] += graph[x][y]
                                test_graph[x][y] = 4
                    
                    distance = max(values[1:]) - min(values[1:])
                    if distance <= answer:
                        answer = distance
                        # print(answer)
                        # for tmp in test_graph:
                        #     print(tmp)
                    
print(answer)
                
# 메모리 34320 시간 3544ms