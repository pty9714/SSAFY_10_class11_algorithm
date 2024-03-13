import sys
input = sys.stdin.readline

n, c, w = map(int, input().split())
trees = [int(input()) for _ in range(n)]
ans = 0

for i in range(1, max(trees) + 1):
    money = 0
    for tree in trees:
        cnt, remain = divmod(tree, i)
        if remain: expense = cnt * c
        else: expense = (cnt - 1) * c

        target = (cnt * w * i) - expense
        if target < 0: continue
        money += target

    if money >= ans: ans = money

print(ans)
