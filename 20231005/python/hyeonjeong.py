def solution(rows, columns, queries):
    board = [[0 for _ in range(columns)]]
    for i in range(1, rows+1):
        temp = [0]
        for j in range(1, columns+1):
            temp.append((i-1)*columns + j)
        board.append(temp)
        
    result = []
    for query in queries:
        sr, sc, er, ec = query
        nums = []
        start = board[sr][sc]
        nums.append(start)
        for i in range(sr, er):
            board[i][sc] = board[i+1][sc]
            nums.append(board[i+1][sc])
        for j in range(sc, ec):
            board[er][j] = board[er][j+1]
            nums.append(board[er][j+1])
        for i in range(er, sr, -1):
            board[i][ec] = board[i-1][ec]
            nums.append(board[i-1][ec])
        for j in range(ec, sc, -1):
            board[sr][j] = board[sr][j-1]
            nums.append(board[sr][j-1])
        board[sr][sc+1] = start
        result.append(min(nums))
        
    return result

# 테스트 3 〉	통과 (188.32ms, 11.7MB)
