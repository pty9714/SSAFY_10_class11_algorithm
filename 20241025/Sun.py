import sys
input = sys.stdin.readline

def dfs(n, arr):
    arr[n] = -2
    for i in range(len(arr)):
        if n == arr[i]:
            dfs(i, arr)

N = int(input())
l = list(map(int, input().split()))
k = int(input())
cnt = 0

dfs(k, l)
cnt = 0
for i in range(len(l)):
    if l[i] != -2 and i not in l:
        cnt += 1
print(cnt)