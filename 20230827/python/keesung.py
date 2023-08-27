from bisect import bisect_left, bisect_right
# import sys
# input = sys.stdin.read

N, C = map(int, input().split())
houses = []
for _ in range(N):
    houses.append(int(input()))
houses.sort()

distance = (houses[-1] - houses[0]) // (C - 1) # 가장 인접한 공유기 사이의 거리를 distance로 둔다
start = 1
end = distance * 2

# print(start, end)
while start < end-1:
    # print(start, end)
    mid = (end - start) // 2 + start
    now_num = houses[0]
    
    for _ in range(C-1):
        now_num += mid
        next_node = bisect_left(houses, now_num)
        # print(start, end, mid, next_node, distance)
        # input()
        if next_node >= N:
            end = mid
            break
        now_num = houses[next_node]
    if end != mid:
        start = mid

print(start)

# a = [1, 5, 6, 8]
# print(bisect_right(a, 5))


# 41052kb	7968ms
# 공유기의 거리를 distance로 잡고 이분 탐색을 통해 house를 탐색하며
# distance 또한 반씩 줄이고 늘려가면서 탐색한다.