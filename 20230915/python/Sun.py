def solution(n, works):
    answer = 0
    if sum(works)<=n:
        return answer
    for i in range(n):
        works.sort()
        works[-1] -=1
    for i in works:
        answer += i**2
    return answer

# 정확성  테스트
# 테스트 1 〉	통과 (0.01ms, 10MB)
# 테스트 2 〉	통과 (0.01ms, 10.2MB)
# 테스트 3 〉	통과 (0.01ms, 10.4MB)
# 테스트 4 〉	통과 (0.02ms, 9.95MB)
# 테스트 5 〉	통과 (0.01ms, 10.2MB)
# 테스트 6 〉	통과 (0.01ms, 10MB)
# 테스트 7 〉	통과 (0.01ms, 10.1MB)
# 테스트 8 〉	통과 (0.29ms, 10.2MB)
# 테스트 9 〉	통과 (0.81ms, 10.2MB)
# 테스트 10 〉	통과 (0.01ms, 10.3MB)
# 테스트 11 〉	통과 (0.01ms, 10.2MB)
# 테스트 12 〉	통과 (0.02ms, 10.2MB)
# 테스트 13 〉	통과 (0.00ms, 10.2MB)
# 효율성  테스트
# 테스트 1 〉	실패 (시간 초과)
# 테스트 2 〉	실패 (시간 초과)

def solution(n, works):
    answer = 0
    if sum(works)<=n:
        return answer
    works.sort()
    p = len(works)-1
    for i in range(n):
        works[p]-=1
        if works[p]<works[p-1]:
            p -= 1
        else:
            p = len(works)-1


    for i in works:
        answer += i**2
    return answer

# 테스트 1 〉	통과 (0.01ms, 10.2MB)
# 테스트 2 〉	통과 (0.01ms, 10.2MB)
# 테스트 3 〉	통과 (0.01ms, 10.3MB)
# 테스트 4 〉	통과 (0.01ms, 10.1MB)
# 테스트 5 〉	통과 (0.01ms, 10.2MB)
# 테스트 6 〉	통과 (0.01ms, 10.3MB)
# 테스트 7 〉	통과 (0.01ms, 10.1MB)
# 테스트 8 〉	통과 (0.27ms, 10.2MB)
# 테스트 9 〉	통과 (0.67ms, 10.1MB)
# 테스트 10 〉	통과 (0.01ms, 10.2MB)
# 테스트 11 〉	통과 (0.01ms, 10.3MB)
# 테스트 12 〉	통과 (0.01ms, 10.2MB)
# 테스트 13 〉	통과 (0.00ms, 10.3MB)
# 효율성  테스트
# 테스트 1 〉	통과 (171.80ms, 10.3MB)
# 테스트 2 〉	통과 (171.41ms, 10.2MB)