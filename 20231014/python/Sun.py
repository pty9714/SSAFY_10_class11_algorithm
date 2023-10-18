def solution(info, query):
    answer = []
    for s in query:
        cnt = 0
        l2 = list(s.split())
        for m in info:
            l = list(m.split())
            if l[0] == l2[0] or l2[0] == "-":
                if l[1] == l2[2] or l2[2] == "-":
                    if l[2] == l2[4] or l2[4] == "-":
                        if l[3] == l2[6] or l2[6] == "-":
                            if int(l[4]) >= int(l2[7]):
                                cnt += 1

        answer.append(cnt)
    return answer


# 테스트 1 〉	실패 (시간 초과)
# 테스트 2 〉	실패 (시간 초과)
# 테스트 3 〉	실패 (시간 초과)
# 테스트 4 〉	실패 (시간 초과)
