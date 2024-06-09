N = int(input())
num = list(map(int, input().split()))
etc = list(map(int, input().split()))
max = -1000000000
min = 1000000000
def dfs(start , current):
    global max, min
    if(start == N-1):
        if current > max:
            max = current
        if current < min:
            min = current
        return
    for i in range(4):
        if etc[i] > 0:
            etc[i] -= 1
            if i == 0:
                dfs(start+1, current + num[start+1])
            elif i == 1:
                dfs(start+1, current- num[start+1])
            elif i == 2:
                dfs(start+1, current * num[start+1])
            elif i == 3:
                dfs(start+1, int(current / num[start+1]))
            etc[i] += 1
    
        


dfs(0, num[0])


        
print(max)
print(min)