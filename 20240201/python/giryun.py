import sys

INF = sys.maxsize
input = sys.stdin.readline
n, m = map(int, input().split())
building = [[INF] * (n + 1) for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    building[a][b] = 1
    building[a][b] = 1

for k in range(1, n + 1):
    building[k][k] = 0
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            building[i][j] = min(building[i][j], building[i][k] + building[k][j])

answer = list()
for i in range(1, n):
    for j in range(i + 1, n + 1):
        cnt = 0
        for k in range(1, n + 1):
            cnt += min(building[k][i], building[k][j]) * 2
            if cnt >= INF:
                break
        if cnt < INF:
            INF = cnt
            answer = [i, j, INF]
print(*answer)
