dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def dfs(x, y, num):
    if len(num) == 7:
        ans.add(num)
        return
    for d in range(4):
        nx, ny = x + dx[d], y + dy[d]
        if 0 <= nx < 4 and 0 <= ny < 4:
            dfs(nx, ny, num+str(B[nx][ny]))
            

for t in range(1, int(input())+1):
    B = [list(map(int, input().split())) for _ in range(4)]
    ans = set()
    for i in range(4):
        for j in range(4):
            dfs(i, j, str(B[i][j]))
    print(f"#{t} {len(ans)}")
# 68,576 kb, 372 ms