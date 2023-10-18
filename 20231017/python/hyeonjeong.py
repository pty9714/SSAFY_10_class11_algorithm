from collections import deque

N, H = map(int, input().split())

moves = {i: i for i in range(1, 101)}  # 뱀과 사다리
visited = [0 for _ in range(101)]
for _ in range(N):
    s, e = map(int, input().split())
    moves[s] = e
for _ in range(H):
    s, e = map(int, input().split())
    moves[s] = e

queue = deque([(1, 0)])
while queue:
    cur, cnt = queue.popleft()
    cur = moves[cur]

    if visited[cur]:  # 전에 왔던 곳은 pass
        continue
    visited[cur] = cnt

    if cur == 100:  # 가장 빨리 100 도착하는 거 출력
        print(cnt)
        break

    for i in range(1, 7):
        if cur + i > 100:  # 100을 넘어가면 pass
            break
        queue.append((cur + i, cnt + 1))

# 34052 kb 68 ms
