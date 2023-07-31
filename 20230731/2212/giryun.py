n = int(input())
k = int(input())
sensor = list(map(int, input().split()))
sensor.sort()
dist = [abs(sensor[i] - sensor[i+1]) for i in range(n-1)]
dist.sort()
while(k > 1):
    dist.pop()
    k -= 1
print(sum(dist))