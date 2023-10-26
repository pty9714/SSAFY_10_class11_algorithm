import sys
input = sys.stdin.readline
import heapq

N = int(input())

cla = []
rooms = []
max_room = 0
for _ in range(N):
    num, start, end = map(int, input().split())
    heapq.heappush(cla, [start, end])

while cla:
    start, end = heapq.heappop(cla)
    while rooms:
        if rooms[0] <= start:
            heapq.heappop(rooms)
        else:
            break
    heapq.heappush(rooms, end)
    max_room = max(max_room, len(rooms))

print(max_room)
