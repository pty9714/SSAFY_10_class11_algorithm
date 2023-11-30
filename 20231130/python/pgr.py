n = int(input())
arr = list(map(int, input().split()))
arr.sort()

l, r = 0, n-1
ans = abs(arr[l] + arr[r])
res = [arr[l], arr[r]]
while l < r:
    left, right = arr[l], arr[r]
    sum_ = left + right
    if abs(sum_) < ans:
        ans = abs(sum_)
        res = [left, right]
        if ans == 0: break
    if sum_ < 0: l += 1
    else: r -= 1

print(res[0], res[1])
# 42036	128
