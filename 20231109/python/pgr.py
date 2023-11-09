n, s = map(int, input().split())
tmp = list(map(int, input().split()))

arr = [0]
for t in tmp:
    arr.append(t + arr[-1])

ans = 1e9
end = 0
for start in range(n):
    while arr[end] - arr[start] < s and end < n: end += 1
    if arr[end] - arr[start] >= s:
        if end - start < ans:
            ans = end - start

print(ans if ans != 1e9 else 0)
#	41620kb	160ms
