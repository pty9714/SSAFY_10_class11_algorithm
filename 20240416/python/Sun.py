def ttm(k):
    a,b = k.split(":")
    return int(a)*60 + int(b)

def solution(plans):
    answer = []
    plans.sort(key = lambda x :x[1])
    stack = [plans[0]]
    t1 = ttm(plans[0][1])
    for i in plans[1:]:
        s = i[0]
        t2 = ttm(i[1])
        l = i[2]

        t = t2-t1
        t1 = t2        
        
        while t>0 and stack:
            a = stack.pop()
            if int(a[2]) > t:
                a[2]=str(int(a[2])-t)
                stack.append(a)
                break
            else:
                t-=int(a[2])
                answer.append(a[0])
        stack.append(i)
    
    while stack:
        s = stack.pop()
        answer.append(s[0])

    return answer

p = [["aaa", "12:00", "10"], ["bbb", "12:20", "30"], ["ccc", "13:40", "10"]]
print(solution(p))