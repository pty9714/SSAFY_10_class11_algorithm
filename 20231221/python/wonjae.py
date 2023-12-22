import sys
input = sys.stdin.readline

class Robot:
    x = -1
    y = -1
    dir = -1

dx = [0, -1, 0, 1]  # N, W, S, E
dy = [1, 0, -1, 0]
direction = {'N': 0, 'W': 1, 'S': 2, 'E': 3}

a, b = map(int, input().split())
n, m = map(int, input().split())

# 맵 초기화
field = [[-1 for _ in range(a + 2)] for _ in range(b + 2)]
for i in range(1, a + 1):
    for j in range(1, b + 1):
        field[j][i] = 0

robots = [Robot() for _ in range(n + 1)]

# 로봇 입력
for i in range(1, n + 1):
    x, y, dir = input().split()
    field[int(y)][int(x)] = i
    robots[i].dir = direction[dir]
    robots[i].x = int(x)
    robots[i].y = int(y)

flag = True
# 명령 입력
for j in range(m):
    r, c, it = input().split()
    if c == 'L':
        robots[int(r)].dir += int(it)
        robots[int(r)].dir %= 4
    elif c == 'R':
        robots[int(r)].dir -= int(it)
        robots[int(r)].dir %= 4
    elif c == 'F':
        curr = robots[int(r)]

        for di in range(1, int(it) + 1):
            ny = dy[curr.dir] * di
            nx = dx[curr.dir] * di
            if field[curr.y + ny][curr.x + nx] == -1:
                print('Robot', r, 'crashes into the wall')
                flag = False
                break
            elif field[curr.y + ny][curr.x + nx] != 0:
                print('Robot', r, 'crashes into robot', field[curr.y + ny][curr.x + nx])
                flag = False
                break
        if flag is not True:
            break
        field[curr.y][curr.x] = 0
        field[curr.y + dy[curr.dir] * int(it)][curr.x + dx[curr.dir] * int(it)] = int(r)
        robots[int(r)].x += (dx[curr.dir] * int(it))
        robots[int(r)].y += (dy[curr.dir] * int(it))

    if j is m - 1:
        print('OK')

# 31120KB	40ms
# 로봇 이동 시뮬레이션
