import sys
sys.setrecursionlimit(10**8)
dic = {"d": [1, 0], "l": [0, -1], "r": [0, 1], "u": [-1, 0]}
answer = "z"


def dfs(n, m, x, y, r, c, k, path, cnt):
    global answer
    if k < cnt + abs(x-r) + abs(y-c):
        return
    if x == r and y == c and cnt == k:
        answer = path
        return
    for dp, [dx, dy] in dic.items():
        nx, ny = x + dx, y + dy
        if 1 <= nx < n+1 and 1 <= ny < m+1 and path < answer:
            dfs(n, m, nx, ny, r, c, k, path+dp, cnt+1)
        
    
def solution(n, m, x, y, r, c, k):
    dist = abs(x-r) + abs(y-c)
    if dist > k or (k - dist) % 2 == 1: # 테스트 31
        return "impossible"
    dfs(n, m, x, y, r, c, k, "", 0)
    return answer


"""
결과
테스트 28 : 통과 (18.49ms, 15.7MB)
"""