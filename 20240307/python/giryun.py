import sys

input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))

l, r = 0, n - 1
ansL, ansR, target = 0, 0, sys.maxsize
while l < r:
    sum_ = arr[l] + arr[r]
    if abs(sum_) < target:
        ansL, ansR, target = l, r, abs(sum_)
    if sum_ < 0:
        l += 1
    elif sum_ > 0:
        r -= 1
    else:
        break
print(arr[ansL], arr[ansR])
