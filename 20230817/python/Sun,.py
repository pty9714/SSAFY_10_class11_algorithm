from collections import deque

dx = [1,0,-1,0]
dy = [0,1,0,-1]

r,c = map(int,input().split())
l = []
for i in range(r):
    l.append(list(map(int,input().split())))
time = -1
air = 0
cheeze = 0
while True:
    visited = [[0] * c for _ in range(r)]
    time +=1
    check_cheeze = cheeze
    air = 1    
    cheeze = 0
    deq = deque()
    deq.append((0,0))
    while deq:
        x,y = deq.popleft()
        for i in range(4):
            if 0<=y+dy[i]<r and 0<=x+dx[i]<c:
                if visited[y+dy[i]][x+dx[i]] == 0:
                    visited[y+dy[i]][x+dx[i]] = 1
                    if l[y+dy[i]][x+dx[i]] == 0: 
                            deq.append((x+dx[i],y+dy[i]))
                            air +=1
                    else:
                        l[y+dy[i]][x+dx[i]] = 0
                        cheeze +=1
    if cheeze == 0:
        break

print(time)
print(check_cheeze)

#34160kb 132ms