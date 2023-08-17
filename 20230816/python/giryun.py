from collections import deque


dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]


def isOutOfRange(x, y) -> bool:
    return x < 0 or x >= n or y < 0 or y >= n


def isMine(x, y) -> bool:
    for d in range(8):
        nx, ny = x + dx[d], y + dy[d]
        if (nx, ny) in mines: return True
    return False


def bfs(i, j):
    q = deque()
    q.append((i, j))
    visited[i][j] = True
    while q:
        x, y = q.popleft()
        B[x][y] = -1
        if isMine(x, y): continue
        for d in range(8):
            nx, ny = x + dx[d], y + dy[d]
            if isOutOfRange(nx, ny) or visited[nx][ny]: continue
            if B[nx][ny] == ".":
                q.append((nx, ny))
                B[x][y] = 0
                visited[nx][ny] = True


for t in range(1, int(input())+1):
    n = int(input())
    B = [["."] * n for _ in range(n)]
    visited = [[False] * n for _ in range(n)]
    mines = set()
    for i in range(n):
        tmp = input()
        for j in range(n):
            if tmp[j] == "*":
                B[i][j] = "*"
                mines.add((i, j))
    ans = 0
    for i in range(n):
        for j in range(n):
            if B[i][j] == ".":
                if not isMine(i, j):
                    bfs(i, j)
                    ans += 1
    for i in range(n):
        for j in range(n):
            if B[i][j] == ".":
                bfs(i, j)
                ans += 1
    print(f"#{t} {ans}")
# 메모리 >> 108,548 kb, 실행시간 >> 1,183 ms