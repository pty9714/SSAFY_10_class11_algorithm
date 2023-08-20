from collections import deque
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs() -> int:
    q = deque()
    q.append((0, 0))
    visited = set()
    visited.add((0, 0))
    cnt = 0
    while q:
        x, y = q.popleft()
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            if nx < 0 or nx >= r or ny < 0 or ny >= c: continue
            if (nx, ny) in visited: continue
            if not B[nx][ny]:
                q.append((nx, ny))
                visited.add((nx, ny))
            else:  # 치즈 바깥이면 0으로 바꿔주고 값 세주기
                B[nx][ny] = 0
                visited.add((nx, ny))
                cnt += 1
    return cnt


r, c = map(int, input().split())
B = [[0] * c for _ in range(r)]
cnt = 0
for i in range(r):
    tmp = list(map(int, input().split()))
    for j in range(c):
        if tmp[j] == 1:
            B[i][j] = 1
            cnt += 1     
ans = [cnt]
while cnt:
    cnt -= bfs()
    ans.append(cnt)
print(len(ans)-1)
print(ans[-2])
# 메모리 34184 kb >>, 시간 >> 96 ms