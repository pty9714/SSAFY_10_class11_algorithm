import sys
input = sys.stdin.readline

n = int(input())
difficult = list(map(int,input().split()))
s = [0] * n
for i in range(1, n):
	s[i] = s[i - 1]
	if difficult[i] < difficult[i - 1]: s[i] += 1
for _ in range(int(input())):
	x, y = map(int,input().split())
	print(s[y - 1] - s[x - 1])
