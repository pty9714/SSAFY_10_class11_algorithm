def solution(routes):
    answer = 0
    routes.sort(key=lambda x: x[1])
    camera = -30001
    for s, e in routes:
        if camera < s:
            answer += 1
            camera = e
    return answer

"""
# 정확성 테스트
테스트 1 〉	통과 (0.01ms, 10.2MB)
테스트 2 〉	통과 (0.01ms, 10.2MB)
테스트 3 〉	통과 (0.01ms, 10.1MB)
테스트 4 〉	통과 (0.03ms, 10.3MB)
테스트 5 〉	통과 (0.02ms, 10.2MB)

# 효율성 테스트
테스트 1 〉	통과 (0.36ms, 10.5MB)
테스트 2 〉	통과 (0.35ms, 10.3MB)
테스트 3 〉	통과 (0.75ms, 10.6MB)
테스트 4 〉	통과 (0.06ms, 10.1MB)
테스트 5 〉	통과 (0.92ms, 10.6MB)
"""