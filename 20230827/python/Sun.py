n, c = map(int, input().split())
house = sorted([int(input()) for _ in range(n)])

max_diff = house[-1] - house[0]
start, end = 1, max_diff
answer = 0

while start <= end:
    mid = (start + end) // 2
    current = house[0]
    count = 1
    diff = max_diff
    for i in range(1, n): 
        if house[i] - current >= mid: 
            diff = min(diff, house[i] - current)
            count += 1
            current = house[i]

    if count >= c: 
        start = mid + 1
        answer = max(answer, diff)
    else:
        end = mid - 1
print(answer)