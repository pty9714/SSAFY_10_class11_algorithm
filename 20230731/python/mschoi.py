N = int(input())
K = int(input())
sensor = list(map(int, input().split()))
sensor.sort()

dist_diff = []
for i in range(0, N-1):
    dist_diff.append(sensor[i+1] - sensor[i])

dist_diff.sort()

print(sum(dist_diff[:N-K]))

---
# 32276 KB	| 48 ms
