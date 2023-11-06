from collections import deque
N, M = map(int, input().split())
known = list(map(int, input().split()))
parties = [list(map(int, input().split())) for _ in range(M)]
people = [[] for _ in range(N + 1)]
for idx, party in enumerate(parties):
    for p in party[1:]:
        people[p].append(idx)
visited_person = [True] + [False] * N
visited_party = [False] * M

queue = deque()

for p in known[1:]:
    queue.append(p)
    visited_person[p] = True

while queue:
    p = queue.popleft()
    indexList = people[p]
    for idx in indexList:
        if visited_party[idx]:
            continue
        else:
            visited_party[idx] = True
            friends = parties[idx][1:]
            for p in friends:
                if visited_person[p] == False:
                    queue.append(p)
                    visited_person[p] = True

print(M - sum(visited_party))