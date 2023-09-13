def solution(board, skill):
    answer = 0
    for tp,r1,c1,r2,c2,degree in skill:
        if tp == 1:
            for i in range(r1,r2+1):
                for j in range(c1,c2+1):
                    board[i][j] -=degree
        elif tp == 2:
            for i in range(r1,r2+1):
                for j in range(c1,c2+1):
                    board[i][j] +=degree
                    
    print(board)
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j]>0:
                answer +=1
    
    return answer

# 정확성  테스트
# 테스트 1 〉	통과 (0.01ms, 10.3MB)
# 테스트 2 〉	통과 (0.06ms, 10.3MB)
# 테스트 3 〉	통과 (0.19ms, 10.4MB)
# 테스트 4 〉	통과 (0.65ms, 10.1MB)
# 테스트 5 〉	통과 (1.00ms, 10.3MB)
# 테스트 6 〉	통과 (2.00ms, 10.1MB)
# 테스트 7 〉	통과 (3.15ms, 10.4MB)
# 테스트 8 〉	통과 (4.83ms, 10.2MB)
# 테스트 9 〉	통과 (6.37ms, 10.4MB)
# 테스트 10 〉	통과 (11.92ms, 10.4MB)
# 효율성  테스트
# 테스트 1 〉	실패 (시간 초과)
# 테스트 2 〉	실패 (시간 초과)
# 테스트 3 〉	실패 (시간 초과)
# 테스트 4 〉	실패 (시간 초과)
# 테스트 5 〉	실패 (시간 초과)
# 테스트 6 〉	실패 (시간 초과)
# 테스트 7 〉	실패 (시간 초과)