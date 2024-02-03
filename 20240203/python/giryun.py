from collections import deque


dx = [1, 0, -1]
dy = [0, 1, -1]


def solution(n):
    B = [[0] * (i+1) for i in range(n)]
    q = deque()
    q.append([0, 0, 1])
    d = 0
    while q:
        x, y, s = q.popleft()
        if 0 > x or x >= n and 0 > y or y >= n or B[x][y]:
            break
        B[x][y] = s
        nx, ny, ns = x+dx[d], y+dy[d], s+1
        if nx == n or ny == n or B[nx][ny] != 0:
            d = (d+1)%3
            q.append((x+dx[d], y+dy[d], ns))
        else:
            q.append([nx, ny, ns])
    return sum(B, [])
