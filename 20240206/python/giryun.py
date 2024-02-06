from collections import deque

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def turn(d, c):
    return (d - 1) % 4 if c == 'L' else (d + 1) % 4 

n = int(input())
B = [[0] * n for _ in range(n)]
for _ in range(int(input())):
    i, j = map(int, input().split()) 
    B[i - 1][j - 1] = 1
dir = {}
for _ in range(int(input())):
    x, c = input().split()
    dir[int(x)] = c

x, y = 0, 0
q = deque()
q.append([x, y])
B[x][y] = 2
d, cnt = 0, 1  # 처음 방향과 시간
while True:
    x, y = x + dx[d], y + dy[d]
    if 0 <= x < n and 0 <= y < n and B[x][y] != 2:
        if B[x][y] == 0:
            tx, ty = q.popleft()
            B[tx][ty] = 0
        q.append([x, y])
        B[x][y] = 2
        if cnt in dir:
            d = turn(d, dir[cnt])
        cnt += 1
    else:
        print(cnt)
        break
