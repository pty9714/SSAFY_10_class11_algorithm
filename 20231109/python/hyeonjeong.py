N, S = map(int, input().split())
nums = list(map(int, input().split()))
start = 0
end = 0

cnt = N + 1
total = nums[start]
while end < N:
    while total < S and end + 1 < N:
        end += 1
        total += nums[end]

    while total > S and start < end:
        total -= nums[start]
        start += 1
    if total < S:
        start -= 1
        total += nums[start]

    if cnt > end - start + 1:
        if end == start:
            print(1)
            exit()
        cnt = end - start + 1

    if end + 1 == N:
        if cnt > N:
            print(0)
        else:
            print(cnt)
        exit()

    total -= nums[start]
    start += 1

# 42204	kb 140 ms
