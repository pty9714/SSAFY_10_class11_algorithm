arr, bomb = input(), input()
n, m = len(arr), len(bomb)
stack = []
for a in arr:
    stack.append(a)
    if a == bomb[-1] and "".join(stack[-m:]) == bomb:
        del stack[-m:] 
print("".join(stack) if stack else "FRULA")
# 메모리 : 42436KB, 시간 : 296ms