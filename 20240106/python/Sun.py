from collections import deque
dx = [1,-1,0,0]
dy = [0,0,1,-1]
N,L,R = map(int,input().split())
l = []
for i in range(N):
    l.append(list(map(int,input().split())))
CNT = 0
while True:
    
    c = [[-1 for _ in range(N)] for _ in range(N)]
    CN = 0
    poplist = [[] for _ in range(N*N)]
    for i in range(N):
        for j in range(N):
            if c[i][j] == -1:
                q = deque()
                q.append((i,j)) 
                
                while q:
                    x,y = q.popleft()
                    if c[x][y] == -1:
                        c[x][y] = CN
                        poplist[CN].append(l[x][y])
                        for k in range(4):
                            if 0<=x+dx[k]<N and 0<=y+dy[k]<N:
                                if L<=abs(l[x][y]-l[x+dx[k]][y+dy[k]])<=R and c[x+dx[k]][y+dy[k]]==-1:
                                    q.append((x+dx[k],y+dy[k]))
                                

                CN+=1

    cnt = 0
    for i in range(N):
        for j in range(N):
            if l[i][j] == (sum(poplist[c[i][j]])//len(poplist[c[i][j]])):
                cnt +=1
            l[i][j] = (sum(poplist[c[i][j]])//len(poplist[c[i][j]]))

    # for i in range(N):
    #     print(l[i])

    # print()
    if cnt == N*N:
        break
    CNT+=1
print(CNT)

# 80퍼 시간초과
# pypy 통과 211880kb 1904ms

