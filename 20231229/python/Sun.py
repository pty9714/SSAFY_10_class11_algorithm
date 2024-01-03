n,m = map(int,input().split())
MAX_VALUE = 100000000
dx = [1,-1,0,0]
dy = [0,0,1,-1]

l = []
for i in range(n):
    l.append(list(input()))

# print(l)
visited = [[0 for _ in range(m)] for _ in range(n)]
# print(visited)

answer = MAX_VALUE
def bfs(x,y,flag,cnt):
    if x==m-1 and y==n-1:
        global answer
        answer = min(answer,cnt)
        return
    
    for i in range(4):
        if 0<=x+dx[i]<m and 0<=y+dy[i]<n:
            # print(x+dx[i],y+dy[i])
            if l[y+dy[i]][x+dx[i]] == '0' and visited[y+dy[i]][x+dx[i]] == 0:
                visited[y+dy[i]][x+dx[i]] = 1
                bfs(x+dx[i],y+dy[i],flag,cnt+1)
                visited[y+dy[i]][x+dx[i]] = 0
            if l[y+dy[i]][x+dx[i]] == '1' and visited[y+dy[i]][x+dx[i]] == 0:
                if flag == 1:
                    visited[y+dy[i]][x+dx[i]] = 1
                    bfs(x+dx[i],y+dy[i],0,cnt+1)
                    visited[y+dy[i]][x+dx[i]] = 0


visited[0][0] = 1
bfs(0,0,1,1)
if answer == MAX_VALUE:
    print(-1)
else:
    print(answer)


#Recursion error