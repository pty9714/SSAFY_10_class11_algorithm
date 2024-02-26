def solution(n, s):
    answer = []
    q, r = divmod(s, n)
    if (n > s): return [-1]
    for i in range(n):
        answer.append(q)
    for i in range(r):
        answer[i] += 1
    return sorted(answer)

"""
정확성  테스트
테스트 1 〉	통과 (0.21ms, 10.5MB)
테스트 2 〉	통과 (0.95ms, 10.7MB)
테스트 3 〉	통과 (0.54ms, 10.5MB)
테스트 4 〉	통과 (0.29ms, 10.3MB)
테스트 5 〉	통과 (0.15ms, 10.2MB)
테스트 6 〉	통과 (0.17ms, 10.5MB)
테스트 7 〉	통과 (0.06ms, 10.4MB)
테스트 8 〉	통과 (0.12ms, 10.3MB)
테스트 9 〉	통과 (0.42ms, 10.3MB)
테스트 10 〉	통과 (0.44ms, 10.3MB)
테스트 11 〉	통과 (0.53ms, 10.4MB)
테스트 12 〉	통과 (0.42ms, 10.4MB)
테스트 13 〉	통과 (0.68ms, 10.5MB)
테스트 14 〉	통과 (0.00ms, 10.2MB)
효율성  테스트
테스트 1 〉	통과 (0.41ms, 10.5MB)
테스트 2 〉	통과 (0.83ms, 10.5MB)
테스트 3 〉	통과 (1.07ms, 10.6MB)
테스트 4 〉	통과 (0.89ms, 10.6MB)
테스트 5 〉	통과 (1.17ms, 11.1MB)
테스트 6 〉	통과 (0.00ms, 10.1MB)
"""
