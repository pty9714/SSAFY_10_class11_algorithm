from itertools import combinations
from collections import Counter

def solution(orders, course):
    answer = []
    
    for c in course:
        t = []
        
        for order in orders:
            cb = combinations(sorted(order), c)
            t += cb
            
        ct = Counter(t)
        
        if len(ct) != 0 and max(ct.values()) != 1:
            answer += [''.join(f) for f in ct if ct[f] == max(ct.values())]

    return sorted(answer)

#테스트 10 〉	통과 (98.72ms, 10.4MB)