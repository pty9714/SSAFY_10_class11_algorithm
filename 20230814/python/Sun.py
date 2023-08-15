s = input()
stack = []
flag = True
for i in s:
    if i == '(' or i == '[':
        stack.append(i)
    elif i == ')':
        t = 0
        while True:
            if stack == []:
                flag = False
                break
            k = stack.pop()
            if k == '(':
                if t == 0:
                    stack.append(2)
                else:
                    stack.append(2*t)
                
                break
            elif k == '[':
                flag = False
                break
            else:
                try:
                    t +=k
                except:
                    flag = False
                    break
    elif i == ']':
        t = 0
        while True:
            if stack == []:
                flag = False
                break
            k = stack.pop()
            if k == '[':
                if t == 0:
                    stack.append(3)
                else:
                    stack.append(3*t)
                
                break
            elif k == '(':
                flag = False
                break
            else:
                try:
                    t +=k
                except:
                    flag = False
                    break
                
    if flag == False:
        break
if flag == True:
    try:
        print(sum(stack))
    except:
        print(0)
else:
    print(0)


# 31256kb 40ms