from collections import deque

for _ in range(int(input())):

    _, M = map(int, input().split())
    queue = deque(map(int, input().split()))
    idx = deque(i for i in range(len(queue)))

    count = 0
    while True:
        x = queue.popleft()
        i = idx.popleft()
        if len(queue) == 0:
            break
        if max(queue) > x:
            queue.append(x)
            idx.append(i)
        else:
            if M == i:
                break
            count += 1

    print(count+1)
