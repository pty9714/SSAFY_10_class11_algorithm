from collections import deque


for t in range(int(input())):
    n = int(input())
    x, y = map(int, input().split())
    store = [[x, y]] + [list(map(int, input().split())) for _ in range(n)]
    fx, fy = map(int, input().split())
    store.append([fx, fy])
    q = deque()
    q.append((x, y))
    visited = [0] * (n+2)
    visited[0] = 1
    while q:
        x, y = q.popleft()
        for i in range(1, n+2):
            if not visited[i]:
                nx, ny = store[i]
                if abs(x - nx) + abs(y - ny) <= 1000:
                    q.append((nx, ny))
                    visited[i] = 1
    print("happy" if visited[n+1] else "sad")