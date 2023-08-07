import sys
sys.setrecursionlimit(10**6)

def solution(n, m, x, y, r, c, k):
    
    dir = {'d':[1, 0], 'l':[0, -1], 'r':[0, 1], 'u':[-1, 0]}
    answer = ""
    
    def dfs(x, y, temp):
        nonlocal answer
        # 이동 거리가 k이고 위치가 탈출 지점이면 경로를 저장하고 나가기
        if len(temp) == k and x == r and y == c:
            answer = temp
            return
        # 지금까지 온 거리와 남은 거리가 정해진 k 이동 거리를 초과하면 나가기
        if abs(r-x) + abs(c-y) + len(temp) > k:
            return
        # 상하좌우 돌면서
        for letter, pos in dir.items():
            # 바깥으로 안나가면서 아직 정답이 안정해졌으면 이동하기
            if 1 <= x + pos[0] <= n and 1 <= y + pos[1] <= m and len(answer) == 0:
                dfs(x + pos[0], y + pos[1], temp + letter)
    
    # 최단 이동거리가 k를 초과하거나 k번 째에 탈출 지점으로 이동할 수 없으면 실패
    dist = abs(r-x) + abs(c-y)
    if dist > k or (k-dist) % 2 != 0:
        return "impossible"
    
    dfs(x, y, "")
    
    return answer
    
    
