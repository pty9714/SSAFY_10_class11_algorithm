from collections import deque

def bfs(start):
    global cnt
    q = deque([start])
    time[start] = 1
    while q:
        x = q.popleft()
        if x == k:
            cnt += 1
        for nx in (x - 1, x + 1, 2 * x):
            if 0 <= nx < MAX and (not time[nx] or time[nx] == time[x] + 1):
                q.append(nx)
                time[nx] = time[x] + 1

MAX = 100001
n, k = map(int, input().split())
time = [0] * MAX
cnt = 0

bfs(n)
print(time[k] - 1)
print(cnt)
