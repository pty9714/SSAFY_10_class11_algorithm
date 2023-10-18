from collections import deque
import sys

def solution(n, start, end, roads, traps):
    routes = [[0 for _ in range(n + 1)] for _ in range(n + 1)]
    for s, e, c in roads:
        if not routes[s][e] or routes[s][e] > c:
            routes[s][e] = c

    # flipped[start] = -1이면 안뒤집은 상태, 1이면 뒤집은 상태
    flipped = [-1 for _ in range(n + 1)]
    isTrap = [False for _ in range(n+1)]
    for t in traps:
        isTrap[t] = True

    # 위치, 시간, flipped 배열
    queue = deque([(start, 0, flipped)])
    visited = [[-1 for _ in range(n + 1)] for _ in range(n + 1)]
    
    answer = sys.maxsize
    while queue:
        pos, time, flip = queue.popleft()

        if time > answer:
            continue
        
        # 끝에 도착했고, 최단 시간이면 update
        if pos == end:
            if time < answer:
                answer = time
            else:
                continue
        
        # 지금 있는 위치에 trap 있으면 뒤집기
        if isTrap[pos]:
            flip[pos] *= -1
        
        for i in range(1, n+1):
            # 그대로
            if flip[pos] == flip[i]:
                if routes[pos][i] and visited[pos][i] != time:
                    queue.append((i, time + routes[pos][i], flip))
                    visited[pos][i] = time
            # 뒤집어 있음
            else:
                if routes[i][pos] and visited[pos][i] != time:
                    queue.append((i, time + routes[i][pos], flip))
                    visited[i][pos] = time

    return answer

# 5, 26 시간 초과
# 6, 7, 8, 18, 19, 24 실패
