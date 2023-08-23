tempa = input().split()
tempb = input().split()

common = set()
common.add(tempa)
common.update(tempb)

a = []
for x in tempa:
    if x in common:
        a.append(x)

def dfs(seq, cnt, aidx, idx):
    if cnt > answer:
        answer = cnt
    if len(a)-aidx-1 + cnt < answer:
        return
    for i in range(aidx+1, len(a)):
        while idx<len(b) and b[idx] != a[i]: idx++
        if b[idx] == a[i]:
             dfs(seq.append(a[i], cnt+1, i, idx)
    return

answer = 0
idx = 0
for aidx in len(a):
    while idx<len(b) and b[idx] != a[aidx]: idx++
    if b[idx] == a[aidx]: 
        dfs([aidx], 1, aidx, idx)
print(answer)
