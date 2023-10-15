from bisect import bisect_left
from collections import defaultdict
from itertools import combinations

def solution(info, query):
    answer = []
    volunteers = defaultdict(list)
    for i in info:
        cases = []
        i = i.split(" ")
        for j in range(5):
            for cb in combinations(range(4), j):
                case = ""
                for k in range(4):
                    if k not in cb: 
                        case += "-"
                    else: 
                        case += i[k]
                cases.append(case)
        for case in cases: 
            volunteers[case].append(int(i[4]))
    for k in volunteers.keys(): 
        volunteers[k].sort()
    for q in query:
        q = q.replace("and", "").split()
        k, v = "".join(q[:-1]), int(q[-1])
        if k in volunteers.keys(): 
            answer.append(len(volunteers[k]) - bisect_left(volunteers[k], v))
        else:
            answer.append(0)
    return answer
"""
정확성  테스트
테스트 1 〉	통과 (0.43ms, 10.3MB)
테스트 2 〉	통과 (0.76ms, 10.3MB)
테스트 3 〉	통과 (0.52ms, 10.2MB)
테스트 4 〉	통과 (1.60ms, 10.4MB)
테스트 5 〉	통과 (2.91ms, 10.7MB)
테스트 6 〉	통과 (9.03ms, 10.4MB)
테스트 7 〉	통과 (5.79ms, 10.7MB)
테스트 8 〉	통과 (84.94ms, 11.3MB)
테스트 9 〉	통과 (86.97ms, 13.2MB)
테스트 10 〉	통과 (89.79ms, 13.6MB)
테스트 11 〉	통과 (2.92ms, 10.5MB)
테스트 12 〉	통과 (9.65ms, 10.7MB)
테스트 13 〉	통과 (3.20ms, 10.6MB)
테스트 14 〉	통과 (44.22ms, 11.9MB)
테스트 15 〉	통과 (43.83ms, 12MB)
테스트 16 〉	통과 (2.88ms, 10.5MB)
테스트 17 〉	통과 (9.25ms, 10.5MB)
테스트 18 〉	통과 (53.52ms, 12MB)
효율성  테스트
테스트 1 〉	통과 (1019.53ms, 60.5MB)
테스트 2 〉	통과 (1167.95ms, 60.9MB)
테스트 3 〉	통과 (1020.81ms, 60.4MB)
테스트 4 〉	통과 (1057.96ms, 61MB)
"""
