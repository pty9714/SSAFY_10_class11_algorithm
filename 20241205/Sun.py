from collections import defaultdict

import sys
input = sys.stdin.readline

n = int(input())
l = []
for i in range(n):
    c, s = map(int, input().split())
    l.append((c, s,i))

l.sort(key=lambda x: x[1])
d = defaultdict(int)
sumball = defaultdict(int)

t = 0
j = 0
for i in range(n):
    while l[j][1] < l[i][1]:
        t += l[j][1]
        sumball[l[j][0]] += l[j][1]
        j += 1
    d[l[i][2]] = t - sumball[l[i][0]]
for i in range(n):
    print(d[i])