from collections import deque
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(i, j, size):
    q = deque()
    q.append((i, j, 0))
    visited = [[0] * n for _ in range(n)]
    visited[i][j] = 1
    res = []
    while q:
        x, y, cnt = q.popleft()
        for i in range(4):
            nx, ny =  x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if visited[nx][ny]: continue  # 방문한 노드라면 pass
                if B[nx][ny] <= size:
                    if B[nx][ny] < size and B[nx][ny]:
                        res.append((nx, ny, cnt + 1))
                    q.append((nx, ny, cnt+1))
                visited[nx][ny] = 1
    return res


n = int(input())
B = []
sx, sy = 0, 0  # 상어 초기 위치
for i in range(n):
    tmp = list(map(int, input().split()))
    for j in range(n):
        if tmp[j] == 9: sx, sy = i, j
    B.append(tmp)
now, cnt, ans = 2, 0, 0  # 처음 상어 사이즈, 작은 물고기 먹은 횟수, 정답
while True:
    res = bfs(sx, sy, now)
    if not res: break
    res.sort(key=lambda x: (x[2], x[0], x[1]))  # 거리, x좌표, y좌표 순으로 정렬
    x, y, dist = res.pop(0)
    # 값 추가
    cnt += 1
    if cnt == now:
        now += 1
        cnt = 0
    ans += dist
    # 상어 이동
    B[sx][sy] = 0
    B[x][y] = 9
    sx, sy = x, y
print(ans)
# 34340KB,	168ms
