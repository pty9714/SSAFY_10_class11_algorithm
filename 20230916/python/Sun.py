dic = {3211 : 0, 2221:1, 2122:2, 1411:3, 1132:4, 1231:5, 1114:6, 1312:7, 1213:8, 3112:9}

import sys
sys.stdin = open("input.txt", "r")
input = sys.stdin.readline

TC = int(input())

for tc in range(TC):
    answer = 0
    m,n = map(int,input().split())
    l = []
    s = set()
    for i in range(m):
        l.append(input())
    
    t = ""
    for i in range(m):
        for j in range(n):
            if l[i][j] != "0":
                t = t+l[i][j]
            elif l[i][j] == "0":
                s.add(t)
                t = ""

        s.add(t)
        t = ""

    s = list(s)
    s.sort()
    s.pop(0)
    # print(s)
    for i in s:
        k='0x'+i
        ans = str(bin(int(k, 16))[2:].rstrip('0'))
        ans = (56-len(ans)%56)*'0'+ans
        # print(ans)
        ra = [0 for _ in range(8)]
        for j in range(8):
            a,b,c,d = 0,0,0,0
            flag1,flag2 = 0,0
            for k in range(j*7*len(ans)//56,(j+1)*7*len(ans)//56): 
                if flag2 == 1 and ans[k] == '1':
                    d += 1
                elif flag2 == 1 and ans[k] == '0':
                    c += 1  
                elif flag1 == 1 and ans[k] == '0':
                    flag2 = 1
                    c += 1  
                elif flag1 == 1 and ans[k] == '1':     
                    b += 1        
                elif flag1 == 0 and ans[k] == '1':     
                    flag1 = 1
                    b += 1
                elif flag1==0 and ans[k] == '0':
                     a +=1

            m = min(a,b,c,d)
            a //=m
            b //=m
            c //=m
            d //=m
            ra[j] = dic[1000*a+100*b+10*c+d]

        if ((ra[0] + ra[2] + ra[4] + ra[6])*3+ra[1]+ra[3]+ra[5]+ra[7])%10 ==0:
            answer += sum(ra)
            
    print(f'#{tc+1} {answer}')

    #실패
    #중간에 0이들어간 암호를 처리를 못함