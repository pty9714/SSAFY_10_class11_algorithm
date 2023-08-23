def solution(alp, cop, problems):
    answer = 0
    flag = True
    while flag:
        for p in problems:
            if alp<p[0] or cop<p[0]:
                break
        else:
            flag = False

        #alp,cop 늘리는 작업 진행
        
            

    return answer

alp = 10
cop = 10
problems = [[10,15,2,1,2],[20,20,3,3,4]]

print(solution(alp, cop, problems))