# n = int(input())
# l = input().split()
# o = list(map(int,input().split()))
# f = ['+','-','*','/']
# answer = []
# def cal(cnt,s):
#     print(cnt,s)
#     global n, l, o, f, answer

#     if cnt == n-1:
#         t = eval(s)
#         answer.append(t)
    
#     for i in range(4):
#         if o[i] != 0:
#             o[i] -= 1
#             cal(cnt+1, s+ f[i] + l[cnt+1])
#             o[i] += 1


# cal(0,l[0])
# print(min(answer))
# print(max(answer))


n = int(input())
l = list(map(int,input().split()))
o = list(map(int,input().split()))

answer = []

def cal(cnt,s):
    # print(cnt,s)
    global n, l, o,answer

    if cnt == n-1:
        answer.append(s)
    
    for i in range(4):
        if o[i] != 0:
            o[i] -= 1
            if i == 0:
                t = s+ l[cnt+1]
            elif i == 1:
                t = s- l[cnt+1]
            elif i == 2:
                t = s * l[cnt+1]
            elif i == 3:
                if s >=0:
                    t = s // l[cnt+1]
                else:
                    t = -((-s) //l[cnt+1])
            cal(cnt+1, t)
            o[i] += 1


cal(0,l[0])
print(max(answer))
print(min(answer))
