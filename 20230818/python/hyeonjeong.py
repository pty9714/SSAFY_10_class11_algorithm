def solution(routes):
    routes.sort()
    
    result = 0
    end = routes[0][1]
    for route in routes:
        if route[0] > end:
            result += 1
            end = route[1]
        
    return result + 1
