for t in range(1, int(input()) + 1) :
    n, a, b = map(int, input().split())
    ans = int(1e9)
    for r in range(1, n + 1) :
        c = 1
        while r * c <= n :
            ans = min(ans, a * (abs(r - c)) + b * (n - (r * c)))
            c += 1

    print(f"#{t} {ans}")