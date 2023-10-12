n, k = map(int, input().split())
s, e = 0, n // 2 #가로로 자른 횟수
while s <= e:
    mid = (s + e) // 2 #가로로 자른 횟수
    cnt = (mid + 1) * (n - mid + 1) #만들어진 종 개수
    if cnt < k: s = mid + 1
    elif cnt > k: e = mid - 1
    else:
        print("YES")
        break
if cnt != k: print("NO")
# 31120KB,	40ms
