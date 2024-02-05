n, k = map(int, input().split())
ans = 0
digit = 1
nine = 9

while k > digit * nine:
    k -= (digit * nine)
    ans += nine
    digit += 1
    nine *= 10

ans = (ans + 1) + (k - 1) // digit

print(-1 if ans > n else str(ans)[(k - 1) % digit])
