n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
check = [[0]*m for _ in range(n)]
dx = [-1,1,0,0,1,1,-1,-1]
dy = [0,0,-1,1,1,-1,1,-1]

answer = 0
p = 1 
#  이번탐색에 방문했는지 확인
s = 0
#  주변에 큰값이 있는지 없는지 확인

for i in range(n):
    for j in range(m):
        if check[i][j] == 0:
            c = graph[i][j]
            stack = []
            stack.append((i,j)) 
            while stack and s==0:
                x,y = stack.pop()
                check[x][y] = p
                for k in range(8):
                    if 0<=x+dx[k]<n and 0<=y+dy[k]<m and check[x+dx[k]][y+dy[k]] != p:
                        if c == graph[x+dx[k]][y+dy[k]]:
                            stack.append((x+dx[k],y+dy[k]))
                        if c<graph[x+dx[k]][y+dy[k]]:
                            s = 1
                            break
            else:
                if s == 0:
                    answer +=1

            s = 0
            p +=1

print(answer)
                             
