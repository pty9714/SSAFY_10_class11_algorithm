from collections import deque

N, M = map(int, input().split())
truth = list(map(int, input().split()))[1:]  # 진실을 아는 사람들
parties = [[] for _ in range(M)]  # 각 파티마다 오는 사람 번호들 
people = [[] for _ in range(N+1)]  # 각 사람마다 간 파티 번호들

for i in range(M):
    tmp = list(map(int, input().split()))[1:]
    for t in tmp:
        parties[i].append(t)
        people[t].append(i)

queue = deque()
met = [False for _ in range(N+1)]  # 확인한 사람들
visited = [False for _ in range(M)]  # 확인한 파티들

for t in truth:
    met[t] = True
    for party in people[t]:
        if not visited[party]:
            visited[party] = True
            queue.append(party)

while queue:
    p = queue.pop()
    for person in parties[p]:
        if not met[person]:
            met[person] = True
            for party in people[person]:
                if not visited[party]:
                    visited[party] = True
                    queue.append(party)

print(M-sum(visited))

# 34072	kb 76 ms

