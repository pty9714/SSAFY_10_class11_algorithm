import copy

## 122324KB	368ms
def left(depth, temp):
    for r in range(n):
        i = 0
        j = 1
        while j < n:
            while True:
                if j == n:
                    break
                if temp[r][j] == 0:
                    j += 1
                else:
                    break
            if j == n:
                break
            elif temp[r][i] == 0:
                temp[r][i] += temp[r][j]
                temp[r][j] = 0
                j += 1
            elif temp[r][i] == temp[r][j]:
                temp[r][i] += temp[r][j]
                temp[r][j] = 0
                i += 1
                j += 1
            else:
                t = temp[r][j]
                temp[r][j] = 0
                temp[r][i + 1] = t
                i += 1
                j += 1
    move(depth + 1, temp)


def right(depth, temp):
    for r in range(n):
        i = n - 1
        j = n - 2
        while j >= 0:
            while True:
                if j == -1:
                    break
                if temp[r][j] == 0:
                    j -= 1
                else:
                    break
            if j == -1:
                break
            elif temp[r][i] == 0:
                temp[r][i] += temp[r][j]
                temp[r][j] = 0
                j -= 1
            elif temp[r][i] == temp[r][j]:
                temp[r][i] += temp[r][j]
                temp[r][j] = 0
                i -= 1
                j -= 1
            else:
                t = temp[r][j]
                temp[r][j] = 0
                temp[r][i - 1] = t
                i -= 1
                j -= 1
    move(depth + 1, temp)


def up(depth, temp):
    for c in range(n):
        i = 0
        j = 1
        while j < n:
            while True:
                if j == n:
                    break
                if temp[j][c] == 0:
                    j += 1
                else:
                    break
            if j == n:
                break
            elif temp[i][c] == 0:
                temp[i][c] += temp[j][c]
                temp[j][c] = 0
                j += 1
            elif temp[i][c] == temp[j][c]:
                temp[i][c] += temp[j][c]
                temp[j][c] = 0
                i += 1
                j += 1
            else:
                t = temp[j][c]
                temp[j][c] = 0
                temp[i + 1][c] = t
                i += 1
                j += 1
    move(depth + 1, temp)


def down(depth, temp):
    for c in range(n):
        i = n - 1
        j = n - 2
        while j >= 0:
            while True:
                if j == -1:
                    break
                if temp[j][c] == 0:
                    j -= 1
                else:
                    break
            if j == -1:
                break
            elif temp[i][c] == 0:
                temp[i][c] += temp[j][c]
                temp[j][c] = 0
                j -= 1
            elif temp[i][c] == temp[j][c]:
                temp[i][c] += temp[j][c]
                temp[j][c] = 0
                i -= 1
                j -= 1
            else:
                t = temp[j][c]
                temp[j][c] = 0
                temp[i - 1][c] = t
                i -= 1
                j -= 1
    move(depth + 1, temp)


def move(depth, temp):
    global best
    if depth == 5:
        for i in range(n):
            for j in range(n):
                best = max(best, temp[i][j])
        return
    for i in range(4):
        if i is 0:
            left(depth, copy.deepcopy(temp))
        elif i is 1:
            right(depth, copy.deepcopy(temp))
        elif i is 2:
            up(depth, copy.deepcopy(temp))
        else:
            down(depth, copy.deepcopy(temp))

n = int(input())

board = [[0 for _ in range(n)] for _ in range(n)]

for i in range(n):
    l = list(map(int, input().split()))
    for j in range(n):
        board[i][j] = l[j]

best = 0
move(0, copy.deepcopy(board))
print(best)
