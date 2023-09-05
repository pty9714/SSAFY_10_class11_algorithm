from collections import defaultdict


def calcAllCase(x, n):
    global N
    res = [x + n, x - n, x * n]
    if n != 0: res.append(x // n)  # ZeroDivisionError 방지
    return res


def solution(n, number):
    global N
    N = n
    dic = defaultdict(set)
    now = n
    for i in range(1, 9):
        if now == number: return i
        dic[i].add(now)
        allCase = set()
        # 바로 이전값에서 나올 수 있는 값
        for x in dic[i-1]:
            for a in set(calcAllCase(x, n)):
                if a == number: return i
                allCase.add(a)
        # dp를 1부터 i//2+1까지 값들을 비교
        for j in range(1, i//2+1):
            for y in dic[j]:
                for z in dic[i-j]:
                    for b in set(calcAllCase(y, z)):
                        if b == number: return i
                        allCase.add(b)
        dic[i] = dic[i].union(allCase)
        now = now * 10 + n
    return -1
# 테스트 4 〉	통과 (27.77ms, 11.8MB)
