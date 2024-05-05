m,n = map(int,input().split())
l = [[0 for _ in range(m)] for _ in range(n)]
answer = 0

def dfs(d):
    global answer
    if d == m*n:
        answer+=1
        # for i in range(n):
        #     print(l[i])
        # print("")
        return
    x = d%m
    y = d//m

    if 0 <= x - 1 and 0 <= y - 1:
        if l[y-1][x-1] == 0 or l[y][x-1] == 0 or l[y-1][x] == 0 :
            l[y][x] = 1
            dfs(d+1)
            l[y][x] = 0
    else:
        l[y][x] = 1
        dfs(d+1)
        l[y][x] = 0
            
    dfs(d+1)

    
dfs(0)
print(answer)
