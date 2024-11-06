B = [[[0, 0] for _ in range(21)] for _ in range(21)]

def available(s, e):
    cnt = [0, 0, 0]
    for i in range(s[0], e[0] + 1):
        for j in range(s[1], e[1] + 1):
            cnt[B[i][j][0]] += 1

    if cnt[2] == 0:
        return 0
    if cnt[2] == 1:
        if cnt[1] == 0:
            return 1
        else:
            return 0
    if cnt[1] == 0:
        return 0
    return 2

def cut(s, e, d):
    k = available(s, e)
    if k == 0:
        return 0
    if k == 1:
        return 1

    ret = 0
    for u in range(s[1 - d] + 1, e[1 - d]):
        possible = False
        for v in range(s[d], e[d] + 1):
            if B[u][v][1 - d] == 2:
                possible = False
                break
            if B[u][v][1 - d] == 1:
                possible = True
        if not possible:
            continue

        tmp1 = [[e[0], u - 1], [u - 1, e[1]]]
        tmp2 = [[s[0], u + 1], [u + 1, s[1]]]

        first = cut(s, tmp1[d], 1 - d)
        second = cut(tmp2[d], e, 1 - d)
        if first == 0 or second == 0:
            continue

        ret += (first * second)
    return ret

def main():
    n = int(input())
    for i in range(n):
        row = list(map(int, input().split()))
        for j in range(n):
            B[i][j][0] = row[j]
            B[j][i][1] = row[j]

    s = [0, 0]
    e = [n - 1, n - 1]
    ans = cut(s, e, 1) + cut(s, e, 0)

    if ans == 0:
        print(-1)
    else:
        print(ans)

main()