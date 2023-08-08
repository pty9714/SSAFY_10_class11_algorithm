H, W = map(int, input().split())
blocks = list(map(int, input().split()))
answer = 0
prevVal = -1

# 높이 위로 올라가면서 탐색
for row in range(1, H+1):
    temp = []
    for idx, b in enumerate(blocks):
        if b >= row:
            temp.append(idx)
    for idx in range(len(temp)):
        if idx+1 >= len(temp):
            break
        answer += (temp[idx+1] - temp[idx] - 1)

print(answer)

------------------
31256 KB  |  84 ms
