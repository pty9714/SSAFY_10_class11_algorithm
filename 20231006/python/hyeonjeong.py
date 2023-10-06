N, M = map(int, input().split())

rows = {}
for i in range(N):
    row = input()
    if row in rows:
        rows[row] += 1
    else:
        rows[row] = 1
k = int(input())

result = 0
rows = sorted(rows.items(), key=lambda x: x[1], reverse=True)
for row, cnt in rows:
    zero = row.count('0')
    if k >= zero and (k - zero) % 2 == 0:
        result = cnt
        break

print(result)

# 31256 KB	44 ms
