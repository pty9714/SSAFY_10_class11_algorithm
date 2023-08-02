from collections import deque

tc = int(input())
def bfs():
    q = deque()
    q.append((home_x,home_y))
    while q:
        x, y = q.popleft()
        if abs(x - fest_x) + abs(y - fest_y) <= 1000:
            print("happy")
            return
        for i in range(n):
            if not visited[i]:
                new_x, new_y = cu[i]
                if abs(x - new_x) + abs(y - new_y) <= 1000:
                    q.append([new_x, new_y])
                    visited[i] = 1
    print("sad")
    return

for TC in range(1,tc+1):
    n = int(input())
    cu = []
    home_x,home_y = map(int,input().split())
    for i in range(n):
        cu_x, cu_y = map(int,input().split())
        cu.append((cu_x,cu_y))
    fest_x, fest_y = map(int,input().split())
    visited = [0 for _ in range(n+1)]
    bfs()