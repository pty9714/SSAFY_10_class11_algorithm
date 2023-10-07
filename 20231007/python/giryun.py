from copy import deepcopy


max_diff, max_board = 0, []


def solution(n, info):
    def dfs(ascore, lscore, cnt, idx, board):
        global max_diff, max_board
        if cnt > n:
            return
        if idx > 10:
            diff = lscore - ascore
            if diff > max_diff:
                board[10] = n - cnt
                max_board = board
                max_diff = diff
            return
        if cnt < n:
            board2 = deepcopy(board)
            board2[10 - idx] = info[10 - idx] + 1
            dfs(ascore, lscore + idx, cnt + info[10 - idx] + 1, idx + 1, board2)
            
        board1 = deepcopy(board)
        if info[10 - idx] > 0:
            dfs(ascore + idx, lscore, cnt, idx + 1, board1)            
        else:
            dfs(ascore, lscore, cnt, idx + 1, board1)
            
    dfs(0, 0, 0, 0, [0] * 11)
    return max_board if max_board else [-1]

"""
테스트 1 〉	통과 (2.11ms, 10.3MB)
테스트 2 〉	통과 (14.82ms, 10.3MB)
테스트 3 〉	통과 (12.04ms, 10.2MB)
테스트 4 〉	통과 (6.23ms, 10.2MB)
테스트 5 〉	통과 (15.28ms, 10.3MB)
테스트 6 〉	통과 (13.67ms, 10.4MB)
테스트 7 〉	통과 (12.75ms, 10.1MB)
테스트 8 〉	통과 (4.94ms, 10.3MB)
테스트 9 〉	통과 (8.47ms, 10.3MB)
테스트 10 〉	통과 (2.90ms, 10.2MB)
테스트 11 〉	통과 (4.42ms, 10.3MB)
테스트 12 〉	통과 (5.43ms, 10.3MB)
테스트 13 〉	통과 (14.22ms, 10.3MB)
테스트 14 〉	통과 (14.72ms, 10.3MB)
테스트 15 〉	통과 (17.16ms, 10.3MB)
테스트 16 〉	통과 (10.68ms, 10.3MB)
테스트 17 〉	통과 (13.89ms, 10.4MB)
테스트 18 〉	통과 (2.87ms, 10.3MB)
테스트 19 〉	통과 (0.50ms, 10.2MB)
테스트 20 〉	통과 (12.91ms, 10.2MB)
테스트 21 〉	통과 (15.04ms, 10.4MB)
테스트 22 〉	통과 (16.34ms, 10.4MB)
테스트 23 〉	통과 (7.48ms, 10.3MB)
테스트 24 〉	통과 (20.28ms, 10.4MB)
테스트 25 〉	통과 (13.70ms, 10.1MB)
"""
