from collections import deque

def solution(maps):
    
    answer = []
    queue = deque()
    direction = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    maps = [list(map) for map in maps]
    
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if (maps[i][j]) != 'X':
                queue.append([i, j])
                cnt = 0
                while queue:
                    [i, j] = queue.pop()
                    if (maps[i][j]) != 'X':
                        cnt += int(maps[i][j])
                        maps[i][j] = 'X'
                        for d in direction:
                            x = i+d[0]
                            y = j+d[1]
                            if 0<=x<len(maps) and 0<=y<len(maps[0]) and maps[x][y] != 'X':
                                queue.append([x, y])
                if cnt:
                    answer.append(cnt)
                    
    return sorted(answer) if answer else [-1]
