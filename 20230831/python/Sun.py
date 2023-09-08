from collections import deque

N = int(input())
l = []
for _ in range(N):
    l.append(list(map(int, input().split())))
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
pos = []
for i in range(N):
    for j in range(N):
        if l[i][j] == 9:
            pos.append(i)
            pos.append(j)
cnt = 0
def bfs(x, y):
    visited = [[0]*N for _ in range(N)]
    queue = deque([[x,y]])
    answer = []
    visited[x][y] = 1

    while queue:
        i, j = queue.popleft()
        for idx in range(4):
            mi = i + dx[idx] 
            mj = j + dy[idx]
            if 0 <= mi and mi < N and 0 <= mj and mj < N and visited[mi][mj] == 0:
                if l[x][y] > l[mi][mj] and l[mi][mj] != 0:
                    visited[mi][mj] =  visited[i][j] + 1
                    answer.append((visited[mi][mj] - 1, mi, mj))
                elif l[x][y] == l[mi][mj]:
                    visited[mi][mj] =  visited[i][j] + 1
                    queue.append([mi,mj])
                elif l[mi][mj] == 0:
                    visited[mi][mj] =  visited[i][j] + 1
                    queue.append([mi,mj])
                    
    return sorted(answer, key = lambda x: (x[0], x[1], x[2]))


i, j = pos
size = [2, 0]
while True:
    l[i][j] = size[0]
    answer = deque(bfs(i,j))
    
    if not answer:
        break

    step, x, y = answer.popleft()
    cnt += step
    size[1] += 1
    
    if size[0] == size[1]:
        size[0] += 1
        size[1] = 0

    l[i][j] = 0
    i, j = x, y
        
print(cnt)

