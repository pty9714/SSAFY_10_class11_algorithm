from collections import deque

dx = [0,1,1, 0]
dy = [1,1,0,-1]

def bfs(x, y):
    q = deque()
    q.append((x, y, 0))
    visited[x][y] = 1
    while q:
        x, y, cnt = q.popleft()
        if B[x][y] == b: return cnt
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if (nx < 0 or nx >= 141 or ny < 0 or ny >= 141): continue
            if B[nx][ny] == 0: continue
            if visited[nx][ny]: continue
            q.append((nx, ny, cnt+1))
            visited[nx][ny] = 1
    return -1

for t in range(1, int(input())+1):
    a, b = map(int, input().split())
    if a > b: a, b = b, a # a가 항상 작은 수
    elif a == b:
        print(f"#{t} 0")
        continue
    B = [[0] * 141 for _ in range(141)]
    n = 1;
    for i in range(141):
        for j in range(i+1):
            B[i][j] = n
            if n == 10000: break
            elif n == a: ax, ay = i, j
            elif n == b: bx, by = i, j
            n += 1
    visited = [[0] * 141 for _ in range(141)]
    print(f"#{t} {bfs(ax, ay)}")

# 메모리 94,288 kb, 실행시간 940 ms
