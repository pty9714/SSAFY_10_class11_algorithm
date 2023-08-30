s = input()
check = input()
stack = []

for i in range(len(s)):
    stack.append(s[i])
    if ''.join(stack[-len(check):]) == check:
        for j in range(len(check)):
            stack.pop()

if stack:
    print(''.join(stack))
else:
    print('FRULA')