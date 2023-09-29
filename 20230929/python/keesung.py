def solution(scores):
    wanho = scores[0]
    scores = [[x+y, x, y] for x, y in scores]
    scores.sort(key = lambda x: x[1], reverse=True)
    scores.sort(key = lambda x: x[0], reverse=True)
    print(scores)
    ranking = [[scores[0][0], 0]]
    maxPerson = scores[0][2]
    
    answer = 0
    for score in scores:
        if score[1] == wanho[0] and score[2] == wanho[1]:
            if score[2] < maxPerson:
                return -1
            if ranking[-1][0] == score[0]:
                answer += 1
            break
        if score[2] >= maxPerson:
            if score[0] < ranking[-1][0]:
                ranking.append([score[0], 1])
            else:
                ranking[-1][1] += 1
            maxPerson = score[2]
        else:
            continue
    for rank in ranking:
        answer += rank[1]
    
    
    return answer

# 첫번째 스코어가 계속 정렬 되어 있을 것이라고 생각함. 실패코드, priority queue를 이용해서 넣는 방법으로 다시 시도해 볼 것!
# 첫번째 스코어 기준으로 정렬하고, 두번째 스코어가 더 크면 해당 스코어 기록 해두기, 이때 만족하면 리스트에 넣고, 리스트를 마지막에 한번 더 정렬 해서 순위를 파악함