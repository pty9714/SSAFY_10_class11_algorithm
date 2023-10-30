from collections import defaultdict

def addOne(x):
    return x+1

def solution(gems):
    n = len(gems)
    m = len(set(gems))
    answer = [0, n-1]
    dic = defaultdict(int)
    dic[gems[0]] = 1
    s, e = 0, 0
    while s < n and e < n:
        if len(dic) == m:
            if e - s < answer[1] - answer[0]:
                answer = [s, e]
            if dic[gems[s]] == 1:
                del dic[gems[s]]
            else:
                dic[gems[s]] -=1
            s += 1
        else:
            e += 1
            if e == n:
                break
            if gems[e] in dic.keys():
                dic[gems[e]] += 1
            else:
                dic[gems[e]] = 1
    return list(map(addOne, answer))
