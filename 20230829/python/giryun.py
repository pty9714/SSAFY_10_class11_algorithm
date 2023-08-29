n, k = map(int, input().split())
res = []
while True:
    now = 1
    # 현재 n보다 작은 최대 크기의 2의 배수 구하기
    b
    # 현재 n보다 2의 배수가 크면 종료
    if n < now: break
    res.append(now)
    n -= now
print(0 if len(res) <= k else res[k-1] - sum(res[k:]))
# 	31256	44
