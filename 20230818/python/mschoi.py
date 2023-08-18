def solution(routes):
    routes.sort(key=lambda x: x[1])
    answer, cameraLoc = 1, routes[0][1]
    
    for start, end in routes:
        if start <= cameraLoc <= end:
            continue
        else: # 끝지점에 카메라 설치
            cameraLoc = end
            answer += 1
            
    return answer

# ===================================
정확성  테스트
테스트 1 〉	통과 (0.01ms, 10.1MB)
테스트 2 〉	통과 (0.02ms, 10.2MB)
테스트 3 〉	통과 (0.03ms, 10.2MB)
테스트 4 〉	통과 (0.03ms, 10.1MB)
테스트 5 〉	통과 (0.02ms, 9.98MB)
효율성  테스트
테스트 1 〉	통과 (0.37ms, 10.4MB)
테스트 2 〉	통과 (0.22ms, 10.4MB)
테스트 3 〉	통과 (0.74ms, 10.6MB)
테스트 4 〉	통과 (0.06ms, 10.1MB)
테스트 5 〉	통과 (0.94ms, 10.5MB)
