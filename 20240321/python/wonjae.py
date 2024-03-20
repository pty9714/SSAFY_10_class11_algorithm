from sys import stdin

point = []

n = int(stdin.readline())

for _ in range(n):
    a, b = map(int, stdin.readline().split())
    point.append([a, b])
point.append(point[0])
sum_x = sum_y = 0
for i in range(n):
    sum_x += point[i][0] * point[i + 1][1]
    sum_y += point[i][1] * point[i + 1][0]
print(round(abs((sum_x - sum_y) / 2), 1))
