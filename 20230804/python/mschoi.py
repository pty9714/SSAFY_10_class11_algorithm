from itertools import combinations as cb
from collections import defaultdict as dd

def solution(orders, course):
    answer = []
    
    for cnt in course:
        info = dd(int)
        result = []
        # 가능한 조합 누적
        for order in orders:
            res = cb(order, cnt)
            for item in res:
                item = ''.join(sorted(item))
                info[item] += 1
        # 개수별로 가장 큰 조합 찾기
        maxNum, maxKey = -987654321, ()
        for k,v in info.items():
            if maxNum < v:
                maxNum, maxKey = v, k
        # 최소 2번이 아니라면 후보로 추가X
        if maxNum < 2:
            continue
        # 후보 추가
        for k,v in info.items():
            if v == maxNum:
                result.append(''.join(k))
        answer.extend(result)
    
    return sorted(answer)

---
# 테스트 8 〉	통과 (4.87ms, 10.3MB)
