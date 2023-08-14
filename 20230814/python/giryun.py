s = input()
stack = []
answer = 0
for c in s:
    if c == "(" or c == "[":
        stack.append(c)
    elif c == ")":
        tmp = []
        while True:
            if not stack:
                print(0)
                exit(0)
            now = stack.pop()                
            if now == "(":
                if not tmp:
                    stack.append(2)
                else:         
                    stack.append(2 * sum(map(int, tmp)))
                break
            elif now == "[":
                print(0)
                exit(0)
            else:
                tmp.append(now)
    elif c == "]": 
        tmp = []
        while True:
            if not stack:
                print(0)
                exit(0)
            now = stack.pop()                
            if now == "[":
                if not tmp:
                    stack.append(3)
                else:         
                    stack.append(3 * sum(map(int, tmp)))
                break
            elif now == "(":
                print(0)
                exit(0)
            else:
                tmp.append(now)
for c in stack:
    if type(c) != int:
        print(0)
        exit(0)
print(sum(stack))