from collections import deque


for _ in range(int(input())):
    n, m = list(map(int, input().split()))
    arr = list(map(int, input().split()))
    q = deque([arr[i], i] for i in range(n))
    imp = sorted(arr)
    now = n-1
    ans = 0
    while q:
        x, p = q.popleft()
        if x == imp[now]:
            now -= 1
            ans += 1
            if p == m:
                print(ans)
                break
        else:
            q.append([x, p])