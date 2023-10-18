n = int(input())
l = []
for _ in range(n):
    l.append(int(input()))

answer = 0
stack = []
for i in l:
    while stack and stack[-1] <= i:
        stack.pop()
    stack.append(i)

    answer += len(stack) - 1

print(answer)
