n, m = map(int, input().split())
dic = {}
l = []
answer = []
visited = [0] * 101
for _ in range(n + m):
    a, b = map(int, input().split())
    l.append(a)
    dic[a] = b


def go(a, cnt):
    if a > 100:
        return
    if a == 100:
        answer.append(cnt)
        return
    for i in range(1, 7):
        b = a + i
        if b > 100:
            break
        if visited[b] > cnt + 1 or visited[b] == 0:
            visited[b] = cnt + 1
            if b in l:
                visited[dic[b]] = cnt + 1
                go(dic[b], cnt + 1)
            else:
                visited[b] = cnt + 1
                go(b, cnt + 1)


go(1, 0)
print(min(answer))

# 31252kb 52ms
