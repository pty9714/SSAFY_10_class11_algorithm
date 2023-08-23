def solution(routes):
    answer = 0
    routes.sort(key = lambda x:(x[0],x[1]))
    camera = routes[0][1]
    answer +=1
    for i in routes:
        if camera < i[0]:
            camera = i[1]
            answer +=1
    return answer

r = [[-20,-15], [-14,-5], [-18,-13], [-5,-3]]
print(solution(r))

# 테스트 1 〉	통과 (0.02ms, 10.2MB)
# 테스트 2 〉	통과 (0.02ms, 10.3MB)
# 테스트 3 〉	통과 (0.03ms, 10MB)
# 테스트 4 〉	통과 (0.03ms, 10.1MB)
# 테스트 5 〉	통과 (0.05ms, 10.1MB)
# 효율성  테스트
# 테스트 1 〉	통과 (0.86ms, 10.4MB)
# 테스트 2 〉	통과 (0.49ms, 10.3MB)
# 테스트 3 〉	통과 (2.01ms, 10.5MB)
# 테스트 4 〉	통과 (0.07ms, 10MB)
# 테스트 5 〉	통과 (2.49ms, 10.9MB)