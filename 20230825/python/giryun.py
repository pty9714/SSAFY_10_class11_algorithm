arr = input()
n = len(arr)
bomb = input()
m = len(bomb)
stack = []
for a in arr:
    stack.append(a)
    if "".join(stack[-m:]) == bomb:
        del stack[-m:] 
print("".join(stack) if stack else "FRULA")
