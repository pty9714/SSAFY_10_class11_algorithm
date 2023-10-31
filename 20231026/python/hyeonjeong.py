import heapq

N = int(input())

lectures = []
for _ in range(N):
    i, s, e = map(int, input().split())
    lectures.append([s, e])
lectures.sort()

rooms = []
heapq.heappush(rooms, 0)
for start, end in lectures:
    if rooms[0] <= start:
        heapq.heappop(rooms)
    heapq.heappush(rooms, end)

print(len(rooms))

# 48952 KB	4196 ms
