def solution(n, info):
    diff = 0
    for score in range(10, -1, -1):
        if info[score] > 0:
            diff -= score
        else:
            diff += score
