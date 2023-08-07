import sys
sys.setrecursionlimit(5000)

dx = [1, 0, 0, -1]
dy = [0, -1, 1, 0]
letters = ['d', 'l', 'r', 'u']
def solution(n, m, x, y, r, c, k):
    
            
    
    answer = dfs('', n, m, x, y, r, c, k)
    if type(answer) != str:
        answer = "impossible"
    return answer

def dfs(letter, n, m, x, y, r, c, cnt):
    if cnt == 0 and x == r and y == c:
        return letter
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if nx <= 0 or nx > n or ny <= 0 or ny > m:
            continue
        if abs(r - nx) + abs(c - ny) > cnt:
            continue
        return dfs(letter + letters[i], n, m, nx, ny, r, c, cnt - 1)

print(solution(6, 6, 2, 6, 6, 5, 11))
# 아래쪽이 제일 먼저
# 왼쪽
# 오른쪽
# 위쪽 순서로 체크해야함

            
            
    