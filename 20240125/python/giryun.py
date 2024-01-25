N = int(input())
board = [list(map(str, input().rstrip())) for _ in range(N)]

answer = 2147000000

# 1. 행이 뒤집힌 배열 생성
board_reversed = [["H"] * N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if board_reversed[i][j] == board[i][j]:
            board_reversed[i][j] = "T"
# 2. 비트마스크로 경우의 수 탐색
for case in range(1 << N):
    board_temp = []
    for i in range(N):
        if case & (1 << i):
            board_temp.append(board_reversed[i])
        else:
            board_temp.append(board[i])
    # 3. 열방향 탐색으로 뒤집는 것과 안뒤집는 것중 최대값 저장
    total_count = 0
    for j in range(N):
        count = 0
        for i in range(N):
            if board_temp[i][j] == "T":
                count += 1
        total_count += min(count, N-count)
    # 4. 현재 답보다 작다면 최소값이므로 저장
    answer = min(answer, total_count)

print(answer)
