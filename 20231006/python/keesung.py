N, M = map(int, input().split())
desk = [list(map(int, input())) for _ in range(N)]
K = int(input())

result = 0

for signal in desk:
    lamp = M - sum(signal)
    if lamp > K or lamp % 2 != K % 2:
        continue
    tmp = 0
    for row in desk:
        if signal == row:
            tmp += 1
    result = max(result, tmp)

print(result)