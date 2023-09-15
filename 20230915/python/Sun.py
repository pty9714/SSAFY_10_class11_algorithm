def solution(n, works):
    answer = 0
    if sum(works)<=n:
        return answer
    for i in range(n):
        works.sort()
        works[-1] -=1
        if works[-1] == 0:
            works.pop()
    
    for i in works:
        answer += i**2
    return answer