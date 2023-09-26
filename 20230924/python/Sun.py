# from collections import deque
# n,m,r = map(int,input().split())
# l = list(map(int,input().split()))
# graph = [[] for _ in range(n+1)]
# answer = [0 for _ in range(n)]
# for _ in range(r):
#     a,b,t = map(int,input().split())
#     graph[a].append((b,t))
#     graph[b].append((a,t))

# for i in range(1,n+1):
#     queue = deque()
#     visited = [0] *(n+1)
#     answer[i-1] = l[i-1]
#     queue.append((i,m))
#     while queue:
#         p,range = queue.popleft()
#         for x,y in graph[p]:
#             if range>=y and visited[x] == 0:
#                 visited[x] = 1
#                 answer[i-1] += l[x-1]
#                 if range-y>0:
#                     queue.append((x,range-y))

# print(max(answer))

# 더 큰 range를 가지고 노드에 방문에도 visit 처리가 되어있으면 진행을안함

# n,m,r = map(int,input().split())
# l = list(map(int,input().split()))
# graph = [[0 for _ in range(n)] for _ in range(n)]
# for _ in range(r):
#     a,b,t = map(int,input().split())
#     graph[a-1][b-1] = t
#     graph[b-1][a-1] = t

from collections import deque
n,m,r = map(int,input().split())
l = list(map(int,input().split()))
graph = [[] for _ in range(n+1)]
answer = [0 for _ in range(n)]
for _ in range(r):
    a,b,t = map(int,input().split())
    graph[a].append((b,t))
    graph[b].append((a,t))

for i in range(1,n+1):
    queue = deque()
    visited = [0] *(n+1)
    answer[i-1] = l[i-1]
    queue.append((i,m))
    while queue:
        p,range = queue.popleft()
        visited[p] = 1
        for x,y in graph[p]:
            if range>=y and visited[x] == 0:
                answer[i-1] += l[x-1]
                if range-y>0:
                    queue.append((x,range-y))

print(max(answer))