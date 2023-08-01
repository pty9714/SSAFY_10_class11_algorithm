n = int(input())
k = int(input())

if k >= n:
    print(0)
    exit()
sensor = list(map(int, input().split()))
sensor.sort()

dist = [(sensor[i+1] - sensor[i]) for i in range(n-1)]
dist.sort()

while(k > 1):
    dist.pop()
    k -= 1

print(sum(dist))


"""
결과
메모리 : 32276KB, 시간 : 52ms
"""