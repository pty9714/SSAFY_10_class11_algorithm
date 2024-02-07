def check():
    for start in range(n):
        k = start
        for j in range(h):
            if board[j][k]: k += 1
            elif k > 0 and board[j][k - 1]: k -= 1
        if k != start: return 0
    return 1

def dfs(x, y, cnt):
    global ans
    if check():
        ans = min(ans, cnt)
        return
    elif cnt == 3 or ans <= cnt: return
    for i in range(x, h):
        if i == x: k = y
        else: k = 0
        for j in range(k, n - 1):
            if not board[i][j] and not board[i][j + 1]:
                if j > 0 and board[i][j - 1]: continue
                board[i][j] = 1
                dfs(i, j + 2, cnt + 1) 
                board[i][j] = 0

n, m, h = map(int, input().split())
if m == 0:
    print(0)
    exit()
board = [[0] * n for _ in range(h)]
for _ in range(m):
    a, b = map(int, input().split())
    board[a - 1][b - 1] = 1

ans = 4
dfs(0, 0, 0)
print(ans if ans < 4 else -1)
