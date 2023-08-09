N = int(input())

mapping = {}
numbers = []
for _ in range(N**2):
    tmp = list(map(int, input().split()))
    mapping[tmp[0]] = set(tmp[1:])
    numbers.append(tmp[0])
    
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
graph = [[0] * (N+2) for _ in range(N+2)]
for number in numbers:
    max_val = -1
    max_blank = -1
    for i in range(1, N+1):
        for j in range(1, N+1):
            count = 0
            blank = 0
            if graph[i][j] == 0:
                for k in range(4):
                    if 0 < i+dx[k] <= N and 0 < j+dy[k] <= N:
                        if graph[i+dx[k]][j+dy[k]] == 0:
                            blank += 1
                            continue
                    if graph[i+dx[k]][j+dy[k]] in mapping[number]:
                        count += 1
                if count > max_val:
                    max_val = count
                    max_blank = blank
                    x, y = i, j
                elif count == max_val:
                    if blank > max_blank:
                        max_blank = blank
                        x, y = i, j
    graph[x][y] = number


# print(graph)
sumval = 0
for i in range(1, N+1):
    for j in range(1, N+1):
        happy = 0
        for k in range(4):
            # if graph[i][j] == 0:
            #     continue
            if graph[i+dx[k]][j+dy[k]] in mapping[graph[i][j]]:
                happy += 1
        if happy == 0:
            # sumval += 1
            continue
        else:
            sumval += 10**(happy-1)
                
print(sumval)