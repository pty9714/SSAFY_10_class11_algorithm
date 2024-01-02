def solution(board):
    cnt_o = 0
    cnt_x = 0
    for i in range(3):
        for j in range(3):
            if board[i][j] == "O":
                cnt_o +=1
            elif board[i][j] == "X":
                cnt_x +=1 

    if cnt_o-cnt_x != 1 and cnt_o-cnt_x != 0 :
        return 0
    
    
    cnt_otic = 0
    cnt_xtic = 0
    for i in range(3):
        if board[i][0] =="O" and board[i][1] == "O" and board[i][2] == "O":
            cnt_otic +=1
        if board[i][0] =="X" and board[i][1] == "X" and board[i][2] == "X":
            cnt_xtic +=1
        if board[0][i] =="O" and board[1][i] == "O" and board[2][i] == "O":
            cnt_otic +=1
        if board[0][i] =="X" and board[1][i] == "X" and board[2][i] == "X":
            cnt_otic +=1
    
    if board[0][0] == "O" and board[1][1] == "O" and board[2][2] == "O":
        cnt_otic+=1
    if board[2][0] == "O" and board[1][1] == "O" and board[0][2] == "O":
        cnt_otic+=1    
    if board[0][0] == "X" and board[1][1] == "X" and board[2][2] == "X":
        cnt_xtic+=1
    if board[2][0] == "X" and board[1][1] == "X" and board[0][2] == "X":
        cnt_xtic+=1    
        
    if cnt_otic and cnt_xtic:
        return 0
    if cnt_otic and cnt_o-cnt_x == 0:
        return 0
    if cnt_xtic and cnt_o-cnt_x >= 1:
        return 0
    return 1