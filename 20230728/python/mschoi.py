from collections import deque

def bfs():
    q = deque()
    q.append([home[0], home[1]])
    while q:
        curX, curY = q.popleft()
        # 도착 체크
        if abs(curX - target[0]) + abs(curY - target[1]) <= 1000:
            print("happy")
            return
        # 편의점들 체크
        for i in range(N):
            if not visited[i]:
                curStore = store[i]
                if abs(curX - curStore[0]) + abs(curY - curStore[1]) <= 1000:
                    visited[i] = True
                    q.append(curStore)
    print("sad")


T = int(input())
for t in range(T):
    # 입력
    N = int(input())
    home = list(map(int, input().split()))
    store = [list(map(int, input().split())) for _ in range(N)]
    target = list(map(int, input().split()))

    # bfs
    visited = [False for _ in range(N + 1)]
    bfs()

---
# 156 ms
