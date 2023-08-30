from collections import deque
N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]

for i in range(N):
    for j in range(N):
        if arr[i][j] == 9:
            arr[i][j] = 0
            shark = [i, j]

dx = [-1, 0, 0, 1] # 위, 왼, 오, 아래 (문제에 나와있는 순서)
dy = [0, -1, 1, 0]
queue = deque()
queue.append(shark + [0])
shark_size = 2
fish_num = 0
result = 0
visited = [[False] * N for _ in range(N)]
visited[shark[0]][shark[1]] = True
while queue:
    # print(queue)
    x, y, cnt = queue.popleft()
    for nx, ny in zip(dx, dy):
        new_x, new_y = x + nx, y + ny
        if 0 <= new_x < N and 0 <= new_y < N:
            if visited[new_x][new_y] == True: # 방문한 곳은 다시 방문 안함
                continue
            if arr[new_x][new_y] > shark_size: # 크기가 크면 못지나감
                continue
            elif arr[new_x][new_y] == shark_size or arr[new_x][new_y] == 0: # 크기 같거나 0인 경우 지나가기만 함
                visited[new_x][new_y] = True
                queue.append([new_x, new_y, cnt + 1])
            elif arr[new_x][new_y] > 0: # 잡아 먹는 경우, 큐 초기화, 방문 초기화, 사이즈 먹은 물고기 확인 후 크기 증가
                # 남아 있는 큐 다 체크 후 초기화
                while queue:
                    x, y, tmp_cnt = queue.popleft()
                    if tmp_cnt > cnt:
                        break
                    for nx, ny in zip(dx, dy):
                        tmp_x, tmp_y = x + nx, y + ny
                        if 0 <= tmp_x < N and 0 <= tmp_y < N:
                            if arr[tmp_x][tmp_y] >= shark_size:
                                continue
                            elif arr[tmp_x][tmp_y] > 0:
                                if tmp_x < new_x:
                                    new_x, new_y = tmp_x, tmp_y
                                elif tmp_x == new_x and tmp_y < new_y:
                                    new_x, new_y = tmp_x, tmp_y
                arr[new_x][new_y] = 0
                result += cnt + 1
                fish_num += 1
                queue = deque()
                queue.append([new_x, new_y, 0])
                visited = [[False] * N for _ in range(N)]
                visited[new_x][new_y] = True
                if fish_num == shark_size:
                    fish_num = 0
                    shark_size += 1
                break
                
print(result)

# 메모리 34240, 시간 68ms

# dx, dy를 하는 과정에서 단순하게 bfs를 돌면 안되고,
# bfs를 돌 때 x가 작아야 하고, x가 같으면 y가 작은 것을 보장해주어야 한다.
# 따라서 생선을 먹을 수 있다는게 확정이 났을 때도 
# cnt 값이 같은 queue는 다 돌아주면서 다시 한번 사방탐색을 마치고 나서야 실제 작업을 끝낼 수 있다.