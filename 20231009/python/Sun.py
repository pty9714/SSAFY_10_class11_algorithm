n,k = input().split()
l = list(n)
if len(l) != 1:
    if '0' in set(l) and len(set(l)) == 2 and len(l) == 2:
        print(-1)
    else:
        k = int(k)
        cnt = 0
        answer = ''
        flag = True
        def switch(lst):
            global cnt
            m = max(lst)
            for i in range(len(lst)-1,-1,-1):
                if lst[i] == m:
                    num = i
                    break

            if num != 0:
                lst[i] = lst[0]
                lst[0] = m
                cnt +=1   

        while cnt != k:
            if len(l)==2:
                if (k-cnt)%2 == 0:
                    break
                else:
                    l = list(l[1]+l[0])
                    break

            switch(l)
            answer = answer + l[0]
            l = l[1:]

        if l:
            for i in l:
                answer = answer + i
        print(answer)
else:
    print(-1)


#반례

# 1220 2
# 2210