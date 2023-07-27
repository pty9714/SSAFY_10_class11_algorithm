from collections import deque
def solution(maps):
    answer = []
    dx = [1,-1,0,0]
    dy = [0,0,1,-1]

    l = []
    for i in maps:
        l.append(list(i))

    x = len(l[0])
    y = len(l)
    for i in range(y):
        for j in range(x):
            if l[i][j] != 'X':
                check = deque()
                day = int(l[i][j])
                l[i][j] = 'X'
                check.append((j,i))
                while check:
                    k1,k2 = check.popleft()
                    for k in range(4):
                        if 0<=k1+dx[k]<x and 0<=k2+dy[k]<y:
                            if l[k2+dy[k]][k1+dx[k]]!="X":
                                day +=int(l[k2+dy[k]][k1+dx[k]])
                                l[k2+dy[k]][k1+dx[k]] = "X"
                                check.append((k1+dx[k],k2+dy[k]))

                answer.append(day)
    answer.sort()
    if answer == []:
        answer = [-1]
    return answer


m= ["X591X","X1X5X","X231X", "1XXX1"]
print(solution(m))