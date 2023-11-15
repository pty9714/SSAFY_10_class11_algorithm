def isPalindrome(x):
    if x == x[::-1]: return True
    
def solution(s):
    answer = 0
    n = len(s)
    for i in range(n):
        for j in range(i+1, n+1):
            if isPalindrome(s[i:j]):
                if answer < len(s[i:j]):
                    answer = len(s[i:j])
    return answer
"""
정확성  테스트
테스트 1 〉	통과 (0.03ms, 10.1MB)
테스트 2 〉	통과 (0.03ms, 10.1MB)
테스트 3 〉	통과 (1.45ms, 10.1MB)
테스트 4 〉	통과 (1.52ms, 10.2MB)
테스트 5 〉	통과 (1.74ms, 10.2MB)
테스트 6 〉	통과 (1.50ms, 10.1MB)
테스트 7 〉	통과 (1.47ms, 10.1MB)
테스트 8 〉	통과 (1.45ms, 10MB)
테스트 9 〉	통과 (1.60ms, 10.1MB)
테스트 10 〉	통과 (1.35ms, 10.2MB)
테스트 11 〉	통과 (1.61ms, 10.1MB)
테스트 12 〉	통과 (2.18ms, 10MB)
테스트 13 〉	통과 (1.37ms, 10.1MB)
테스트 14 〉	통과 (5.92ms, 10.2MB)
테스트 15 〉	통과 (5.19ms, 10.1MB)
테스트 16 〉	통과 (5.53ms, 10.2MB)
테스트 17 〉	통과 (0.00ms, 10.1MB)
테스트 18 〉	통과 (0.01ms, 10.1MB)
테스트 19 〉	통과 (1.28ms, 10.2MB)
테스트 20 〉	통과 (1.53ms, 10.2MB)
테스트 21 〉	통과 (1.61ms, 10.1MB)
테스트 22 〉	통과 (0.01ms, 10.2MB)
테스트 23 〉	통과 (0.01ms, 10.1MB)
테스트 24 〉	통과 (0.01ms, 10.3MB)
효율성  테스트
테스트 1 〉	통과 (3402.89ms, 10.2MB)
테스트 2 〉	통과 (3473.75ms, 10.2MB)
"""
