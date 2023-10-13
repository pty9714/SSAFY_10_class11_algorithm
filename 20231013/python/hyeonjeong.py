# 실패
N, H = map(int, input().split())

cave = [0 for _ in range(H)]
for i in range(N):
    x = int(input())
    if i % 2 == 0:
        for j in range(x):
            cave[j] += 1
    else:
        for j in range(H-x-1, H):
            cave[j] += 1

min_val = min(cave)
cnt = 0
for c in cave:
    if min_val == c:
        cnt += 1

print(min_val, cnt)
