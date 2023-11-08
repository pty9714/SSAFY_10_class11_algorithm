from collections import deque

def solution(board):
    
    size = len(board)
    cost = [[600*25 for _ in range(size)] for _ in range(size)]
    directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    straight = 100
    corner = 500
    
    queue = deque()
    cost[0][0] = 0
    if not board[0][1]:
        cost[0][1] = straight
        queue.append((0, 1, 0, straight))
    if not board[1][0]:
        cost[1][0] = straight
        queue.append((1, 0, 1, straight))
    
    while queue:
        (r, c, d, p) = queue.popleft()
        change = False
        for i, d in enumerate(directions):
            nr = r + d[0]
            nc = c + d[1]
            np = p + straight 
            if nr < 0 or nr >= size or nc < 0  or nc >= size or board[nr][nc]:
                continue
            if d != i:
                change = True
            if cost[nr][nc] < 0 or cost[nr][nc] > np:
                cost[nr][nc] = np
                queue.append((nr, nc, i, np))
        if change:
            cost[r][c] += corner

    return cost[size-1][size-1]
