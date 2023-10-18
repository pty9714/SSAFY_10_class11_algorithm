n, k = map(int, input().split())

success = False
for i in range(n+1):
    if (i+1)*(n-i+1) == k:
        success = True
        break

if success:
    print('YES')
else:
    print('NO')
