num = int(input())
l = []
for _ in range(num):
    l.append(list(input()))

d = [(1,0),(-1,0),(0,-1),(0,1),]

result = []
for i in range(num):
    for j in range(num):
        if l[i][j] == '1':
            a = 0
            stack = []
            stack.append((i,j))

            while stack:
                x,y = stack.pop()

                for k in d:
                    dx,dy = k
                    lx = x + dx
                    ly = y + dy
                    if 0 <= lx <num and 0 <= ly < num:
                        if l[lx][ly] == '1':
                            a+=1
                            l[lx][ly] = '0'
                            stack.append((lx,ly))
            
            if a == 0:
                a = 1
            result.append(a)

result = sorted(result)
print(len(result))
print(*result,sep='\n')