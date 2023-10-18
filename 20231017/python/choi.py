import heapq

N, M = map(int, input().split())
ladders, snakes = [], []
answer = []

for i in range(N):
    x, y = map(int, input().split())
    ladders.append([x, y])
for i in range(M):
    u, v = map(int, input().split())
    snakes.append([u, v])

# 큐에 넣고 완전탐색
q = []
visited = [False for _ in range(101)]
visited[1] = True
heapq.heappush(q, [0, 1])

while q:
    cnt, cur = heapq.heappop(q)
    # 주사위로 이동 (1 ~ 6)
    for move in range(1, 7):
        nxt = cur + move
        isDone, flag = False, False
        if nxt == 100:
            answer = cnt+1
            isDone = True
            break
        if nxt > 100:
            continue
        if visited[nxt]:
            continue
        # 사다리 확인
        for start, end in ladders:
            if nxt == start:
                heapq.heappush(q, [cnt+1, end])
                visited[end] = True
                flag = True
                break
        # 뱀 확인
        for start, end in snakes:
            if nxt == start:
                heapq.heappush(q, [cnt+1, end])
                visited[end] = True
                flag = True
                break
        if not flag:
            heapq.heappush(q, [cnt+1, nxt])
            visited[nxt] = True
    if isDone:
        break

print(answer)

33188KB  72ms
