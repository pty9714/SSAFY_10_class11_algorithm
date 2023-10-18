# 실패
T= int(input())
for _ in range(T):
    n = int(input())
    nums = [0] + list(map(int, input().split()))
    checked = [False for _ in range(n+1)]
    groups = []

    for i in range(1, n+1):
        if checked[i]:
            continue
        tmp = [i]
        while True:
            nxt = nums[tmp[-1]]
            if nxt == i:
                groups.extend(tmp)
                for t in tmp:
                    checked[t] = True
                break
            if nxt == tmp[-1]:
                checked[i] = True
                checked[nxt] = True
                groups.append(nxt)
                break
            if checked[nxt]:
                checked[i] = True
                break
            tmp.append(nxt)

    print(n-len(groups))
