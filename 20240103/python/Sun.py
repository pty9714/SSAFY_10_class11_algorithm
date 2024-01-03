def solution(sequence):
    l1 = []
    l2 = []
    a = 1
    for i in sequence:
        l1.append(a*i)
        l2.append(-a*i)
        a *= -1
    v1 = 0
    v2 = 0
    answer = 0
    for i in range(len(sequence)):
        v1+=l1[i]
        v2+=l2[i]
        if answer<v1:
            answer = v1
        if answer<v2:
            answer = v2
        if v1<0:
            v1 = 0
        if v2<0:
            v2 = 0
    
    return answer

# 테스트20 통과 (195.94ms, 71.7MB)