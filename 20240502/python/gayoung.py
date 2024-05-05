
n,m =map(int,input().split())
square =[[0]*(m+1) for _ in range(n+1)]
answer = 0


def dfs(depth):
    global answer
    if(depth==n*m):
        answer+=1
        return
    x=depth//m+1
    y=depth%m+1

    if(square[x-1][y]==0 or square[x-1][y-1]==0 or square[x][y-1]==0):
        square[x][y]=1
        dfs(depth+1)
        square[x][y]=0 
    dfs(depth+1) 

dfs(0)
print(answer)