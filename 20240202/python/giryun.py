import sys
input = sys.stdin.readline

n = int(input())
lst = sorted(list(map(int, input().split())))

res = sys.maxsize
sol_candi = []

for i in range(n - 2):
    tmp = lst[i]
    l, r = i+1, n-1
    while l < r:
        sum_ = tmp + lst[l] + lst[r]
        if abs(sum_) <= abs(res):
            sol_candi = [tmp, lst[l], lst[r]]
            res = tmp + lst[l] + lst[r]
        if sum_ < 0: l += 1
        elif sum_ > 0: r -= 1
        else:
            print(*sol_candi)
            sys.exit()

print(*sol_candi)
