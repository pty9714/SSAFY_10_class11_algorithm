# 실패

def solution(game_board, table):
    N = len(game_board)
    board = [[0 for _ in range(N)] for _ in range(N)]
    directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    
    # game_board 칠하기 (board)
    def fill_board(r, c):
        visited[r][c] = True
        for d in directions:
            nr = r + d[0]
            nc = c + d[1]
            if nr < 0 or nr >= N or nc < 0 or nc >= N or game_board[nr][nc]:
                continue
            board[nr][nc] += 1
            if not visited[nr][nc]:
                fill_board(nr, nc)
    
    visited = [[False for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if not game_board[i][j] and not visited[i][j]:
                fill_board(i, j)
    
    # table 칠하기 (table)
    def fill_table(r, c):
        visited[r][c] = True
        for d in directions:
            nr = r + d[0]
            nc = c + d[1]
            if nr < 0 or nr >= N or nc < 0 or nc >= N or not table[nr][nc]:
                continue
            table[nr][nc] += 1
            if not visited[nr][nc]:
                fill_table(nr, nc)
    
    visited = [[False for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if table[i][j] and not visited[i][j]:
                fill_table(i, j)
    
    # 퍼즐 맞추기
    def check(tr, tc, br, bc):
        pvisited[tr][tc] = True
        for ti, td in enumerate(directions):
            ntr = tr + td[0]
            ntc = tc + td[1]
            if ntr < 0 or ntr >= N or ntc < 0 or ntc >= N or not table[ntr][ntc]:
                continue
            if not pvisited[nr][nc]:
                for bi, bd in enumerate(directions):
                    nbr = br + bd[0]
                    nbc = bc + bd[1]
                    if (nbr < 0 or nbr >= N or nbc < 0 or nbc >= N) and board[nbr][nbc] == table[ntr][ntc]:
                        check(ntr, ntc, nbr, nbc)
        pvisited[tr][tc] = False
    
    pvisited = [[False for _ in range(N)] for _ in range(N)]
    bvisited = [[False for _ in range(N)] for _ in range(N)]
    for pi in range(N):
        for pj in range(N):
            if not pvisited[pi][pj] and table[pi][pj]:
                for bi in range(N):
                    for bj in range(N):
                        if board[bi][bj] == table[pi][pj]:
                            check(pi, pj, bi, bj)
    
    return 0
