h, w = map(int, input().split())
blocks = list(map(int, input().split()))

answer = 0

for i in range(1, w-1):
    start = max(blocks[:i])
    end = max(blocks[i+1:])
    height = min(start, end)
    if blocks[i] < height:
        answer += height - blocks[i]

print(answer)

# Python3 31256 kb 44 ms
