import sys

sys.setrecursionlimit(10 ** 6)


def dfs(idx):
    global cnt
    checked[idx] = True
    tmp.append(idx)

    if checked[nums[idx]]:
        if nums[idx] in tmp:
            cnt -= len(tmp[tmp.index(nums[idx]):])
        return

    dfs(nums[idx])


T = int(input())
for _ in range(T):
    n = int(input())
    cnt = n
    nums = [0] + list(map(int, input().split()))
    checked = [False for _ in range(n + 1)]

    for i in range(1, n + 1):
        if checked[i]:
            continue
        tmp = []
        dfs(i)

    print(cnt)

# 61892	kb 2524 ms
