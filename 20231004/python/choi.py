from collections import deque

T = int(input())
MAX = 10001
graph = [[] for _ in range(MAX)]

# Graph 초기화
cur = 1
for i in range(1, 150):
    for j in range(i):
        # 양방향 연결
        if cur+i < MAX-1:
            graph[cur].append(cur+i)
            graph[cur+i].append(cur)
        if cur+i+1 < MAX-1:
            graph[cur].append(cur+i+1)
            graph[cur+i+1].append(cur)

        # 대각선 방향 연결
        if i > 1 and j < i-1 and cur+1 < MAX-1:
            graph[cur].append(cur+1)
            graph[cur+1].append(cur)
        cur += 1

for test_case in range(1, T + 1):
    a, b = map(int, input().split())
    # BFS - 민지 위치에서 시작해 보물이 있는 방으로
    answer = 987654321
    if a == b:
        answer = 0
        print("#" + str(test_case) + " " + str(answer))
        continue
    q = deque()
    visited = [False for _ in range(MAX)]
    cnt = 0
    q.append([a, cnt])
    visited[a] = True

    while q:
        cur, curCnt = q.popleft()
        for item in graph[cur]:
            if not visited[item]:
                q.append([item, curCnt+1])
                visited[item] = True
                if item == b: # 보물 방 진입
                    answer = curCnt+1
                    break
    print("#" + str(test_case) + " " + str(answer))

