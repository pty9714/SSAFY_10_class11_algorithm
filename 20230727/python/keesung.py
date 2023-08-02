from heapq import heappush, heappop
T = int(input())

dx = [1, 0, -1, 0]

dy = [0, 1, 0, -1]
for test_case in range(1, T + 1):
    number = int(input())
    graph = [list(map(int, input())) for _ in range(number)]
    dp = [[10000000] * number for _ in range(number)]
    heapq = []
    heappush(heapq, (0, 0, 0))
    while heapq:
        dis, x, y = heappop(heapq)
        if x == number - 1 and y == number - 1:
            print("#" + str(test_case) + " " + str(dis))
            break
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < number and 0 <= ny < number:
                tmp = dis + graph[nx][ny]
                if dp[nx][ny] > tmp:
                    dp[nx][ny] = tmp
                    heappush(heapq, (tmp, nx, ny))
# 메모리
# 61,948 kb
# 실행시간
# 265 ms