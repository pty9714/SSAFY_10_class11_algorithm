N = int(input())
# N가지 열 생성
board = [0]*N
answer = 0


def check(x):
    # x 전 열과 비교해서
    for i in range(x):
        # 같은 행에 있거나, 대각선(열 칸 차이 = 행 칸 차이)에 있으면 취소
        if board[x] == board[i] or abs(board[i]-board[x]) == abs(x-i):
            return False
    return True


def dfs(x):
    global answer
    # 마지막 열까지 다 돌면 +1
    if x == N:
        answer += 1
        # 다음 행으로
        return
    # 행 별로 돌면서
    for i in range(N):
        # x 열에 넣기 [i, x]
        board[x] = i
        if check(x):
            dfs(x+1)


dfs(0)
print(answer)

# Python3 시간 초과
# PyPy3 204756KB 31176ms
