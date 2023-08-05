from collections import defaultdict


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def seat():
    global B
    for i in range(n**2):
        like = dic[p[i]]
        like_lst = []
        for y in range(n):
            for x in range(n):
                if B[y][x] == 0:
                    like_cnt = 0
                    empty_cnt = 0
                    for k in range(4):
                        nx = x + dx[k]
                        ny = y + dy[k]
                        if 0 <= nx < n and 0 <= ny < n:
                            if B[ny][nx] in like:
                                like_cnt += 1
                            elif B[ny][nx] == 0:
                                empty_cnt += 1
                    like_lst.append([like_cnt, empty_cnt, y, x])

        like_lst.sort(key=lambda x: (-x[0], -x[1], x[2], x[3]))
        B[like_lst[0][2]][like_lst[0][3]] = p[i]
    return

def check():
    global ans
    for x in range(n):
        for y in range(n):
            like = dic[B[x][y]]
            like_cnt = 0
            for k in range(4):
                nx = x + dx[k]
                ny = y + dy[k]
                if 0 <= nx < n and 0 <= ny < n:
                    if B[nx][ny] in like:
                        like_cnt += 1
            if like_cnt == 1:
                ans += 1
            elif like_cnt == 2:
                ans += 10
            elif like_cnt == 3:
                ans += 100
            elif like_cnt == 4:
                ans += 1000

n = int(input())
B = [[0] * n for _ in range(n)]
p = []
dic = defaultdict(list)
for i in range(n ** 2):
    data = list(map(int, input().split()))
    p.append(data[0])
    dic[p[i]] = data[1:]
print(p)
print(dic)
ans = 0
seat()
check()
print(ans)

"""
결과
메모리 : 34240kb 시간 : 208ms
"""