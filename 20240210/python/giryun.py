def solution(n, results):
    answer = 0
    board = [[0] * n for _ in range(n)]
    for a,b in results:
        board[a-1][b-1] = 1
        board[b-1][a-1] = -1
        
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if i == j or board[i][j] in [1, -1]: continue
                if board[i][k] == board[k][j] == 1:
                    board[i][j] = 1
                    board[j][i] = board[k][i] = board[j][k] = -1
                    
    for row in board:
        if row.count(0) == 1:
            answer += 1
    return answer

"""
테스트 1 〉	통과 (0.03ms, 10.3MB)
테스트 2 〉	통과 (0.07ms, 10.4MB)
테스트 3 〉	통과 (0.13ms, 10.4MB)
테스트 4 〉	통과 (3.11ms, 10.4MB)
테스트 5 〉	통과 (4.72ms, 10.4MB)
테스트 6 〉	통과 (6.50ms, 10.2MB)
테스트 7 〉	통과 (37.87ms, 10.3MB)
테스트 8 〉	통과 (64.69ms, 10.4MB)
테스트 9 〉	통과 (86.51ms, 10.6MB)
테스트 10 〉	통과 (84.69ms, 10.6MB)
"""
