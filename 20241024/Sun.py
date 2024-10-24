
from bisect import bisect_left

n, h = map(int,input().split())
up = []
down = []

for i in range(n):
    t = int(input())
    if i % 2 == 0:
        down.append(t)
    else:
        up.append(t)

up.sort()
down.sort()

min_num = 10E9
cnt = 1

for i in range(1, h+1):
    ui, di = bisect_left(up, (h+1)-i), bisect_left(down, i)
    now_cnt = n - (ui + di)
    
    if now_cnt < min_num:
        min_num = now_cnt
        cnt = 1
        
    elif now_cnt == min_num:
        cnt += 1
            
print(min_num, cnt)