import sys
sys.setrecursionlimit(10**8)

N, M, R, C, K = -1, -1, -1, -1, -1
answer = ""

# d, l, r, u
dx, dy = [1, 0, 0, -1], [0, -1, 1, 0]
direction = ["d", "l", "r", "u"]

def dfs(cx, cy, cnt, res):
    global answer
    
    # (지금까지 온 거리 + 남은거리) 가 K보다 크다면 이미 실패
    if K < cnt + abs(cx - R) + abs(cy - C):
        return
    
    # 조건 부합
    if cx == R and cy == C and cnt == K:
        answer = res
        return
    
    for idx, (dxx, dyy) in enumerate(zip(dx, dy)):
        nx, ny = cx+dxx, cy+dyy
        if 1 <= nx <= N and 1 <= ny <= M and res < answer:
            dfs(nx, ny, cnt+1, res+direction[idx])

def solution(n, m, x, y, r, c, k):
    global N, M, R, C, K, answer
    N, M, R, C, K = n, m, r, c, k
    answer = "z"*N
    
    # k 자체가 최단거리보다 작거나
    # (k-최단거리) == 홀수 일경우 다시 돌아올 수 X
    dist = abs(x - r) + abs(y - c)
    if dist > k or (k - dist) % 2 == 1:
        return "impossible"
    
    dfs(x, y, 0, "")
    
    return answer

--------------------------------------
테스트 29 〉	통과 (24.07ms, 16.1MB)
--------------------------------------

import sys
sys.setrecursionlimit(10**8)

이 두 줄 넣어줘야 성공.
아니면 시간초과...
