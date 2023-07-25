from collections import deque
for _ in range(int(input())):
    num,idx = map(int,input().split())
    l = deque('1')*num
    l[idx] = '0'
    l2 = deque(map(int,input().split()))
    cnt=0
    while '0' in l:
        k = l2[0]
        for i in l2:
            if k<i:
                l.append(l.popleft())
                l2.append(l2.popleft())
                break
        else:
            l.popleft()
            l2.popleft()
            cnt+=1 

    print(cnt)