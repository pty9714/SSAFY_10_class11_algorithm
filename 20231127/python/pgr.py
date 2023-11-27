n, k = map(int, input().split())
arr = list(map(int, input().split()))
dic = {0: 1}
sum_, ans = 0, 0
for i in arr:
    sum_ += i
    if sum_ - k in dic.keys():
        ans += dic[sum_ - k]
    if sum_ in dic.keys(): dic[sum_] += 1
    else: dic[sum_] = 1
print(ans)
# 45572	160
