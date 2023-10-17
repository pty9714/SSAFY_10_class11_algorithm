from collections import deque

N, H = map(int, input().split())

moves = {}
for _ in range(N):
    s, e = map(int, input().split())
    moves[s] = e

queue = deque([1, 0])
result = 100
while queue:
    cur, cnt = queue.popleft()
    if cur == 100 and cnt < result:
        result = cnt
    for i in range(1, 7):
        if cur+i <= 100 and cur+i in moves:
            queue.append([moves[cur+i], cnt+1])

print(result)
