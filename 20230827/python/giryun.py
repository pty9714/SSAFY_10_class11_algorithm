def binary_search(house, start, end):
    answer = 0
    while start <= end:
        mid = (start + end) // 2
        current = house[0]
        count = 1
        for i in range(1, len(house)):
            if house[i] >= current + mid:
                current = house[i]
                count += 1
        if count >= c:
            start = mid + 1
            answer = mid
        else:
            end = mid - 1
    return answer

n, c = map(int, input().split())
house = [int(input()) for _ in range(n)]
house.sort()

print(binary_search(house, 1, house[-1] - house[0]))
