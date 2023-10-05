def solution(rows, columns, queries):
    board = [[0 for _ in range(columns)]]
    for i in range(1, rows+1):
        temp = [0]
        for j in range(1, columns+1):
            temp.append((i-1)*columns + j)
        board.append(temp)
        
    for query in queries:
        start_x, start_y, end_x, end_y = query
        start = board[start_x][end_x]
        for i in range(start_x+1, end_x+1):
            board[i-1][start_y] = board[i][start_y]
        for j in range(start_y+1, end_y+1):
            board[end_x][j-1] = board[end_x][j]
        for i in range(end_x, start_x):
            board[i][end_y] = board[i+1][end_y]
        for j in range(end_y-1, start_y):
            board[start_x][j+1] = board[start_x][j]
        board[start_x][start_y+1] = start
        
    return board
