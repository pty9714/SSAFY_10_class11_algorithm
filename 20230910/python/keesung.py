from collections import deque
T = int(input())

dx = [-1, 0, 1, 0] # 세로 가로 세로 가로
dy = [0, -1, 0, 1]
for test_case in range(1, T+1):
    x1, y1, x2, y2 = map(int, input().split())
    q = deque()
    for i in range(4):
        q.append([1, (i+1)%2, x1 + dx[i], y1 + dy[i]]) # 세로 이동 하면 1을 넣는다 가로는 0
    while q:
        cnt, way, x, y = q.popleft()
        if x == x2 and y == y2:
            print(f'#{test_case} {cnt}')
            break
        q.append([cnt+1, (way+1)%2, x + dx[way], y + dy[way]])
        q.append([cnt+1, (way+1)%2, x + dx[way+2], y + dy[way+2]])
            
        
    