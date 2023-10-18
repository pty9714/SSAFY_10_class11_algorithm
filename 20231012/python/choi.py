N, K = map(int, input().split())
isDone = False

low, high = 0, N
mid = (low + high) / 2
while low != high:
    mid = (low + high) // 2
    result = (mid + 1) * (N - mid + 1)

    if result == K:
        print("YES")
        isDone = True
        break

    if result < K:
        low = mid + 1
    else:
        high = mid

if not isDone:
    print("NO")

31120KB  40ms
