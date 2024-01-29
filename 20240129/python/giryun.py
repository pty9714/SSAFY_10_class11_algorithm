import sys

input = sys.stdin.readline
s = input().rstrip()
cum_sum = { 0 : [0] * 26 }
for i, c in enumerate(s):
    cum_sum[i + 1] = cum_sum[i][:]
    cum_sum[i + 1][ord(c) - 97] += 1
q = int(input().rstrip())
for i in range(q):
    a, l, r = input().split()
    a, l, r = ord(a) - 97, int(l), int(r)
    print(cum_sum[r + 1][a] - cum_sum[l][a])
