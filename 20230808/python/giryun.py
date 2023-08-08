h, w = map(int, input().split())
B = list(map(int, input().split()))

left, right = 0, w - 1
maxleft, maxright = B[left], B[right]

ans = 0
while left < right:
    maxleft, maxright = max(maxleft, B[left]), max(maxright, B[right])
    if maxleft <= maxright:
        ans += maxleft - B[left]
        left += 1
    else:
        ans += maxright - B[right]
        right -= 1

print(ans)