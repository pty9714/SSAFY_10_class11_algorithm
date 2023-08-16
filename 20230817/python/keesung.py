from collections import deque
R, C = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(R)]
cheese = sum(sum(arr, []))
visited = [[0] * C for _ in range(R)]
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
result = 0
queue = deque()
queue.append((0, 0))
visited[0][0] = 1
time = 0
while True:
    time += 1
    tmp = []
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<=nx<R and 0<=ny<C:
                if visited[nx][ny] == 1:
                    continue
                visited[nx][ny] = 1
                if arr[nx][ny] == 1:
                    tmp.append((nx, ny))
                elif arr[nx][ny] == 0:
                    queue.append((nx, ny))
    cheese -= len(tmp)
    # print(cheese)
    if cheese == 0:
        print(time)
        print(len(tmp))
        break
    for i in tmp:
        arr[i[0]][i[1]] = 0
    queue.extend(tmp)
    
# 메모리 34176kb, 시간 72ms
# 처음에 비어있는 가장자리 탐색해서 방문 처리 후, 0인 곳은 큐에 넣고 1인 곳은 tmp에 넣어둠
# 치즈의 총 칸수를 계산해서 tmp와 치즈가 같으면 다 녹은 것
# 당시의 time을 따로 기록하고 만약 총 칸수가 다르면 tmp를 다시 queue에 넣고 한번 더 돌림