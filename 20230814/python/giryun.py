s = input()
stack = []
dic = {")" : ["(", 2], "]" : ["[", 3]}
for c in s:
    if c == "(" or c == "[":
        stack.append(c)
    else:
        tmp = []
        while True:
            if not stack or (type(stack[-1]) != int and stack[-1] != dic[c][0]):
                print(0)
                exit(0)
            now = stack.pop()                
            if now == dic[c][0]:
                if not tmp: stack.append(dic[c][1])
                else: stack.append(dic[c][1] * sum(tmp))
                break
            else:
                tmp.append(now)
    
for c in stack:
    if type(c) != int:
        print(0)
        exit(0)
print(sum(stack))
# 메모리 >> 31256 KB, 시간 >> 44 ms