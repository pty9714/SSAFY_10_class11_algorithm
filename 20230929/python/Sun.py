def solution(scores):
    wx = scores[0][0]
    wy = scores[0][1]
    scores.sort(key = lambda x: (-x[0],x[1]))
    answer = 0
    maxscr1 = 0
    for score in scores:
        if wx<score[0] and wy<score[1]:
            return -1

        if score[1]>=maxscr1:
            maxscr1=score[1]
            if score[0] + score[1] > wx+wy:
                answer +=1
    
    return answer+1


s = [[7, 1], [6, 6], [5, 4], [5, 4], [6, 6]]
print(solution(s))