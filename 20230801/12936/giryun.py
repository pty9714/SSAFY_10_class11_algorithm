import math


def solution(n, k):
    answer = []
    f = [math.factorial(i) for i in range(n+1)]
    p = [i+1 for i in range(n)]
    
    while n:
        now = f[n-1]
        answer.append(p[(k-1)//now])
        p.pop((k-1)//now)
        k, n = k%now, n-1
        
    return answer


"""
결과
효율성 테스트 2 > 통과 (0.03ms, 10.1MB)
"""