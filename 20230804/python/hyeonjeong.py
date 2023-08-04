from itertools import combinations

def solution(orders, course):
    # 모든 조합과 개수를 저장할 딕셔너리
    cnt = dict()
    for order in orders:
        for c in course:
            if len(order) >= c:
                # 각 주문 마다 코스 개수별 조합을 만들어 개수 누적
                for x in list(combinations(list(order), c)):
                    x = ''.join(sorted(x))
                    if x in cnt:
                        cnt[x] += 1
                    else:
                        cnt[x] = 1
    
    answer = []
    # (1) 조합 길이 (2) 높은 개수 기준으로 정렬
    cnt = sorted(cnt.items(), key=lambda x: (len(x[0]), x[1]), reverse=True)
    # 가장 많은 조합 저장
    max_cnt = cnt[0]
    for k, v in cnt:
        # 개수가 1이거나, 같은 길이인데 개수가 최고 미만일때 스킵
        if v < 2 or (len(k) == len(max_cnt[0]) and v < max_cnt[1]):
            continue
        # 같은 길이에 개수가 같으면 추가
        elif len(k) == len(max_cnt[0]) and v == max_cnt[1]:
            answer.append(k)
        # 다른 길이의 가장 많은 조합 저장
        else:
            answer.append(k)
            max_cnt = [k, v]
        
    return sorted(answer)
        
    # 테스트 10 (3.58ms, 10.9MB)
