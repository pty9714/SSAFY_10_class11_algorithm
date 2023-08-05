def is_ok(x):
    for i in range(x):
        if row[x] == row[i] or abs(row[x] - row[i]) == abs(x - i):
            return False
    return True

def n_queen(x):
    if x == n:
        global ans
        ans += 1
        return

    for i in range(n):
        row[x] = i
        if is_ok(x):
            n_queen(x + 1)

n = int(input())
row = [0] * n
ans = 0
n_queen(0)
print(ans)
