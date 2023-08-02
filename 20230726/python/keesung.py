from collections import deque
def solution(maps):
    maps = [list(map(lambda x: 0 if x == "X" else int(x), maps[i])) for i in range(len(maps))]
    visited = [[0 for _ in range(len(maps[0]))] for _ in range(len(maps))]
    answer = []
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    
    for row in range(len(maps)):
        for col in range(len(maps[0])):
            if maps[row][col] == 0:
                visited[row][col] = 1
                continue
            if visited[row][col] == 1:
                continue
            queue = deque()
            queue.append((row, col))
            visited[row][col] = 1
            tmp = 0
            while queue:
                x, y = queue.popleft()
                tmp += maps[x][y]
                for i in range(4):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    if 0 <= nx < len(maps) and 0 <= ny < len(maps[0]):
                        if visited[nx][ny] == 1:
                            continue
                        if maps[nx][ny] == 0:
                            visited[nx][ny] = 1
                            continue
                        visited[nx][ny] = 1
                        queue.append((nx, ny))
            answer.append(tmp)
    answer.sort()
    if answer == []:
        return [-1]
    return answer