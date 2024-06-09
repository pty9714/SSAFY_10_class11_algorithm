n = int(input())
l = []
for i in range(n):
    t = list(input().split())
    l.append(t[1:])

l.sort()
print(l)

for i in range(n):
    if i == 0:
        for j in range(len(l[i])):
            print('--' *j + l[i][j])
    
    else:
        p = 0
        for j in range(len(l[i])):
            if l[i-1][j] != l[i][j] or len(l[i-1])<j:
                break
            else:
                p = j

        for j in range(p+1,len(l[i])):
            print('--' *j + l[i][j])