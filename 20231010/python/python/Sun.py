
def solution(m, n, puddles):
    l =[[0 for _ in range(m+1)] for _ in range(n+1)]
    for x,y in puddles:
        l[y][x] = -1

    for i in range(1,m+1):
        for j in range(1,n+1):
            if l[j][i] != -1:
                if l[j-1][i]!=-1 and l[j][i-1]!=-1:
                    l[j][i] = l[j-1][i]+ l[j][i-1]
                    if i==1 and j==1:
                        l[j][i] = 1
                elif l[j-1][i]==-1:
                    l[j][i] = l[j][i-1]
                elif l[j][i-1]==-1:
                    l[j][i] = l[j-1][i]
                else:
                    l[j][i] = 0

            # for k in range(n+1):
            #     print(l[k])
            # print()
    answer = l[n][m] % 1000000007
    return answer


m = 4
n = 3
p = [[2,2]]
print(solution(m,n,p))


# 정확성  테스트
# 테스트 1 〉	통과 (0.01ms, 10.3MB)
# 테스트 2 〉	통과 (0.02ms, 10.3MB)
# 테스트 3 〉	통과 (0.03ms, 10.2MB)
# 테스트 4 〉	통과 (0.05ms, 10.3MB)
# 테스트 5 〉	통과 (0.07ms, 10.4MB)
# 테스트 6 〉	통과 (0.05ms, 10.3MB)
# 테스트 7 〉	통과 (0.09ms, 10.3MB)
# 테스트 8 〉	통과 (0.12ms, 10.3MB)
# 테스트 9 〉	통과 (0.06ms, 10.3MB)
# 테스트 10 〉	통과 (0.04ms, 10.3MB)
# 효율성  테스트
# 테스트 1 〉	통과 (5.68ms, 10.3MB)
# 테스트 2 〉	통과 (2.16ms, 10.4MB)
# 테스트 3 〉	통과 (1.74ms, 10.4MB)
# 테스트 4 〉	통과 (2.41ms, 10.2MB)
# 테스트 5 〉	통과 (2.00ms, 10.3MB)
# 테스트 6 〉	통과 (5.33ms, 10.4MB)
# 테스트 7 〉	통과 (1.39ms, 10.2MB)
# 테스트 8 〉	통과 (2.51ms, 10.4MB)
# 테스트 9 〉	통과 (2.85ms, 10.3MB)
# 테스트 10 〉	통과 (2.51ms, 10.3MB)