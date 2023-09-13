# dx = [1,-1,0,0]
# dy = [0,0,1,-1]
# n,m = map(int,input().split())
# l = [[] for _ in range(m)]
# for i in range(m):
#     l[i] = list(input())
# print(l)
# max_wall = n+m-2
# visited = [[0 for _ in range(n)] for _ in range(m)]

# def dfs(x,y,cnt):
#     global max_wall
#     if x == n-1 and y == m-1:
#         max_wall = min(cnt,max_wall)
#         return
#     for i in range(4):
#         mx = x+dx[i]
#         my = y+dy[i]
#         if 0<=mx<n and 0<=my<m:
#             if visited[my][mx] == 0:
#                 visited[my][mx] = 1
#                 if l[my][mx] == '0':
#                     dfs(mx,my,cnt)
#                 else:
#                     dfs(mx,my,cnt+1)
#                 visited[my][mx] = 0

# dfs(0,0,0)
# print(max_wall)

#런타임 에러 (RecursionError)

# dx = [1,-1,0,0]
# dy = [0,0,1,-1]
# n,m = map(int,input().split())
# l = [[] for _ in range(m)]
# for i in range(m):
#     l[i] = list(input())
# print(l)
# max_wall = n+m-2
# visited = [[0 for _ in range(n)] for _ in range(m)]

# def dfs(x,y,cnt):
#     global max_wall
#     if x == n-1 and y == m-1:
#         max_wall = min(cnt,max_wall)
#         return
#     for i in range(4):
#         mx = x+dx[i]
#         my = y+dy[i]
#         if 0<=mx<n and 0<=my<m:
#             if visited[my][mx] == 0:
#                 visited[my][mx] = 1
#                 if l[my][mx] == '0':
#                     dfs(mx,my,cnt)
#                 else:
#                     dfs(mx,my,cnt+1)
#                 visited[my][mx] = 0

# dfs(0,0,0)
# print(max_wall)

#런타임 에러 (RecursionError)

from collections import deque
dx = [1,-1,0,0]
dy = [0,0,1,-1]
m,n = map(int, input().split())
l = [list(map(int, input())) for _ in range(n)]
dist = [[-1] * m for _ in range(n)]  # 가중치

q = deque()
q.append((0,0))
dist[0][0] = 0
while q:
    x,y = q.popleft()
    for k in range(4):
        mx = x + dx[k]
        my = y + dy[k]
        if 0 <= mx < m and 0 <= my < n:
            if dist[my][mx] == -1:
                if l[my][mx] == 0:
                    dist[my][mx] = dist[y][x]
                    q.appendleft((mx, my))
                else:
                    dist[my][mx] = dist[y][x] + 1
                    q.append((mx, my))
print(dist[n-1][m-1])