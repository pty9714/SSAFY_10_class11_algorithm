TC = int(input())
for tc in range(TC):
    n = int(input())
    l = [0] + list(map(int, input().split()))
    visited = [0 for _ in range(n + 1)]
    answer = [1 for _ in range(n + 1)]

    for i in range(1, n + 1):
        if visited[i] == 0:
            visited[i] = 1
            k = i
            check = False
            checkl = [k]
            while True:
                j = l[k]
                if j == i:
                    check = True
                    break
                if j in checkl:
                    break
                else:
                    checkl.append(j)
                    k = j

            if check == True:
                for t in checkl:
                    answer[t] = 0
                    visited[t] = 1

    print(sum(answer) - 1)

# 시간초과
