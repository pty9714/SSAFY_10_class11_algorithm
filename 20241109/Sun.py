import sys
input = sys.stdin.readline
import heapq
tc = int(input())
l = []
for i in range(tc):
    a,b = map(int,input().split())
    l.append((a,b))
l= sorted(l)
room = []
heapq.heappush(room,l[0][1])
for i in range(1,tc):
    if l[i][0]<room[0]:
        heapq.heappush(room,l[i][1])
    else:
        heapq.heappop(room)
        heapq.heappush(room,l[i][1])
print(len(room))