def solution(routes):
    routes.sort(key=lambda x: x[1], reverse=True)
    routes.sort(key=lambda x: x[0], reverse=True)
    
    answer = 0
    while routes:
        start, end = routes.pop()
        while routes:
            if routes[-1][0] <= end:
                end = min(end, routes[-1][1])
                routes.pop()
            else:
                break
        answer += 1
    
    return answer