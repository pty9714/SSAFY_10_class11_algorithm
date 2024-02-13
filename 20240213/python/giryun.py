from collections import deque
import sys
input = sys.stdin.readline

n, k = map(int, input().split())

arr = list(input().split())
tgt = sorted(arr)

q = deque()
q.append((arr, 0))
vst = set()
vst.add("".join(arr))

ans = -1
while q:
	x, cnt = q.popleft()
	if x == tgt:
		ans = cnt
		break
	for i in range(n - k + 1):
		nx = x[:i] + list(reversed(x[i:i+k])) + x[i+k:]
		if "".join(nx) not in vst:
			q.append((nx, cnt + 1))
			vst.add("".join(nx))

print(ans)
