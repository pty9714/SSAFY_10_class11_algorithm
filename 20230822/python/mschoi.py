from collections import deque

T = int(input())
answerCand = set()
grid = [[] for _ in range(4) for _ in range(4)]

def bfs(row, col):
    global grid
    temp = grid[row][col]
    start = [row, col, 1, temp]
    q = deque()
    q.append(start)

    while q:
        cur = q.popleft()
        curRow, curCol, curCnt, curStr = cur[0], cur[1], cur[2], cur[3]

        if curCnt == 7:
            answerCand.add(int(curStr))
            continue

        dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
        for xx, yy in zip(dx, dy):
            nxtRow, nxtCol = curRow+xx, curCol+yy
            if 0 <= nxtRow < 4 and 0 <= nxtCol < 4:
                q.append([nxtRow, nxtCol, curCnt+1, curStr+grid[nxtRow][nxtCol]])


for test_case in range(1, T + 1):
    answerCand.clear()
    grid = [[] for _ in range(4) for _ in range(4)]

    for i in range(4):
        nums = list(map(str, input().split()))
        for num in nums:
            grid[i].append(num)

    # BFS
    for row in range(4):
        for col in range(4):
            bfs(row, col)

    print("#" + str(test_case) + " " + str(len(answerCand)))

# 68,644 kb  399 ms
