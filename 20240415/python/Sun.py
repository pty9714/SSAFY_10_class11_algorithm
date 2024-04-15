def solution(k, tangerine):
    dic = {}
    for i in tangerine:
        dic[i] = dic.get(i,0) + 1
    
    print(dic)

    answer = 0
    l = list(dic.values())
    l.sort(reverse=True)
    for i in l:
        k -= i
        answer +=1
        if k<=0:
            return answer

k = 6
t = [1, 3, 2, 5, 4, 5, 2, 3]
print(solution(k,t))