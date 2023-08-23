dx = [1,0,-1,0]
dy = [0,1,0,-1]


tc= int(input())
for TC in range(tc):
    S = set()
    l = []
    for i in range(4):
        l.append(list(map(int,input().split())))
    
    for i in range(4):
        for j in range(4):
            stack = []
            stack.append((i,j,l[j][i],0))
            while stack:
                x,y,ans,cnt = stack.pop()
                if cnt == 6:
                    S.add(ans)
                else:
                    for k in range(4):
                        if 0<=x+dx[k]<4 and 0<=y+dy[k]<4:
                            stack.append((x+dx[k],y+dy[k],ans*10+l[y+dy[k]][x+dx[k]],cnt+1))
    print(f'#{TC+1} {len(S)}')

#65,432 kb, 258 ms