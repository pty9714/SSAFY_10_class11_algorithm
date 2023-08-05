from collections import defaultdict
from itertools import combinations


def solution(orders, course):
    answer = [] 
    for c in course:
        dic = defaultdict(int)
        for order in orders:
            for cb in combinations(order, c):
                dic["".join(sorted(cb))] += 1
        
        res = []
        for k, v in dic.items():
            if v == 1:
                continue
            elif not res or res[-1][1] == v:
                res.append([k, v])
            elif res[-1][1] < v:
                res = [[k, v]]
                
        for k, v in res:
            answer.append(k)
            
    answer.sort()
    return answer

"""
결과
테스트 15 > 통과 (3.32ms, 10.3MB)
"""
