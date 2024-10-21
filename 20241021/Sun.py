n, m = map(int,input().split())
arr = []
for i in range(n):
    k = list(map(int,input()))
    arr.append(k)

visited = [[False] * m for _ in range(n)]

def calculate_sum():
    total = 0
    
    for row in range(n):
        sum_value = 0
        for col in range(m):
            if visited[row][col]:
                sum_value = sum_value * 10 + arr[row][col]
            else:
                total += sum_value
                sum_value = 0
        total += sum_value

    for col in range(m):
        sum_value = 0
        for row in range(n):
            if not visited[row][col]:
                sum_value = sum_value * 10 + arr[row][col]
            else:
                total += sum_value
                sum_value = 0
        total += sum_value

    return total

result = 0

def dfs(x, y):
    global result
    if x == n:
        result = max(result, calculate_sum())
        return
    
    if y == m:
        dfs(x + 1, 0)
        return

    visited[x][y] = True
    dfs(x, y + 1)

    visited[x][y] = False
    dfs(x, y + 1)

dfs(0, 0)
print(result)