T = int(input())
import heapq

for test_case in range(1, T + 1):
    N = int(input())
    graph = [[] for _ in range(N)]
    distGraph = [[float('inf') for _ in range(N)] for _ in range(N)]
    answer = -1

    for i in range(N):
        tmp = list(map(int, input()))
        for t in tmp:
            graph[i].append(t)

    # BFS
    start = [0, 0, 0]
    q = [start]
    distGraph[0][0] = 0

    while q:
        curItem = heapq.heappop(q)
        curRow, curCol, dist = curItem[0], curItem[1], curItem[2]

        dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]

        if curRow == N - 1 and curCol == N - 1:
            answer = dist
            break

        if dist > distGraph[curRow][curCol]:
            continue
        for xx, yy in zip(dx, dy):
            nxtRow, nxtCol = curRow + xx, curCol + yy
            if 0 <= nxtRow < N and 0 <= nxtCol < N:
                newDist = dist + graph[nxtRow][nxtCol]
                if newDist < distGraph[nxtRow][nxtCol]:
                    distGraph[nxtRow][nxtCol] = newDist
                    heapq.heappush(q, [nxtRow, nxtCol, newDist])

    print("#" + str(test_case) + " " + str(answer))
