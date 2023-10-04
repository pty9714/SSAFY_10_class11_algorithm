Ch = int(input())
BB = int(input())
answer = [abs(int(Ch)-100)]
l = [i for i in range(0,10)]
if BB!=0:
    l2 = list(map(int,input().split()))
    for i in l2:
        l.remove(i)
Ch_up = Ch
Ch_down = Ch

if BB !=10:
    while len(answer) == 1:
        for i in str(Ch_up):
            if int(i) not in l:
                Ch_up+=1
                break
        else:
            answer.append(Ch_up-Ch+len(str(Ch_up)))
            
    
        if Ch_down>=0:
            for i in str(Ch_down):
                if int(i) not in l:
                    Ch_down-=1
                    break
            else:
                answer.append(Ch-Ch_down+len(str(Ch_down)))
print(min(answer))