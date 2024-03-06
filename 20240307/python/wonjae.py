N = int(input())

arr = list(map(int, input().split()))
arr.sort()
start = 0
end = N - 1

mini = 2000000001
answer = [0, 0]
while start < end:
    sum = arr[start] + arr[end]
    if abs(sum) < mini:
        answer[0] = arr[start]
        answer[1] = arr[end]
        mini = abs(sum)
    if sum is 0:
        break
    elif sum < 0:
        start += 1
    else:
        end -= 1
print(answer[0], answer[1])
