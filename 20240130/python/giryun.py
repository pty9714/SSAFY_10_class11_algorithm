def dfs(idx, cnt):
    if cnt == k - 5:
        res = 0
        for word in words:
            check = True
            for w in word:
                if not learn[w]:
                    check = False
                    break
            if check:
                res += 1
        global ans
        if ans < res:
            ans = res
        return
    for i in range(idx, 26):
        x = chr(i + 97)
        if not learn[x]:
            learn[x] = 1
            dfs(i, cnt + 1)
            learn[x] = 0 

n, k = map(int, input().split())
if k < 5:
    print(0)
elif k == 26:
    print(n)
else:
    words = [set(input()) for _ in range(n)]
    learn = {chr(i + 97) : 0 for i in range(26)}
    for x in ['a', 'c', 'i', 'n', 't']:
        learn[x] = 1
    ans = 0
    dfs(0, 0)
    print(ans)
