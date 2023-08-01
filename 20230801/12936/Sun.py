# from itertools import permutations

# def solution(n, k):
#     l = [x for x in range(1,n+1)]
#     nPr = permutations(l, n)
#     answer = []
#     for i in list(nPr)[k-1]:
#         answer.append(i)
#     return answer

##시간초과

from math import factorial
def solution(n, k):
    l = [x for x in range(1,n+1)]
    
    answer = [] 
    for _ in range(n):
        t = l[(k-1)//factorial(len(l)-1)]
        answer.append(t)
        k = k % factorial(len(l)-1)
        l.pop(l.index(t))
        
    return answer
    

print(solution(4,6))
#테스트 5 〉	통과 (0.03ms, 10.3MB)