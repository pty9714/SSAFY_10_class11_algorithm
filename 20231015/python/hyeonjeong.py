N = int(input())
buildings = [int(input()) for _ in range(N)]

stack = [(1000000001, N)]
result = 0
for i in range(N-1, -1, -1):
    if buildings[i] > stack[-1][0]:
        while buildings[i] > stack[-1][0]:
            stack.pop()
        result += (stack[-1][1] - i - 1)
    stack.append((buildings[i], i))
print(result)

# 33860	kb 3028 ms
