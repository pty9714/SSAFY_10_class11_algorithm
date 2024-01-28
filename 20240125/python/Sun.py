N = int(input())
l = []
for i in range(N):
    l.append(list(input()))

while True:
    check1 = [0]*N
    check2 = [0]*N

    for i in range (N):
        for j in range(N):
            if l[i][j] == "T":
                check1[i] +=1
            if l[j][i] == "T":
                check2[j] +=1
    
    M = max(max(check1), max(check2))
    if M in check1 and M> N//2:
        c = check1.index(M)
        for i in range(N):
            if l[c][i] == "T":
                l[c][i] = "H"
            else:
                l[c][i] = "T"
        
        else:
            continue
    
    elif M in check2 and M>N//2:
        c = check2.index(M)
        for i in range(N):
            if l[i][c] == "T":
                l[i][c] = "H"
            else:
                l[i][c] = "T"
        else:
            continue
    
    else:
        break

print(l)     
answer = 0
for i in range(N):
    for j in range(N):
        if l[i][j] == "H":
            answer +=1

print(answer)