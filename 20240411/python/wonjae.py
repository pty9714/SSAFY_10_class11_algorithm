import copy

n = int(input())

cards = list(map(int,input().split()))
arr = copy.deepcopy(cards)
arr.sort()

max = arr[-1]

scores = [0 for _ in range(max + 1)]
exist = [False for _ in range(max + 1)]

for a in arr:
    exist[a] = True
for a in arr:
    cur = a * 2
    while cur <= max:
        if exist[cur]:
            scores[a] += 1
            scores[cur] -= 1
        cur += a
for c in cards:
    print(scores[c],end=" ")