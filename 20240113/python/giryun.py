from collections import defaultdict

def solution(friends, gifts):
    n = len(friends)
    answer = [0] * n
    
    # 친구별 주고받은 선물, 준 선물, 받은 선물, 선물 지수 표
    gifts_map = defaultdict(list)
    for idx, friend in enumerate(friends):
        gifts_map[friend] = [0] * (n + 3)
    for gift in gifts:
        a, b = gift.split()
        gifts_map[a][friends.index(b)] += 1
        # 준 선물, 선물 지수 + 1
        gifts_map[a][n] += 1 
        gifts_map[a][n+2] += 1
        # 받은 선물, 선물 지수 - 1
        gifts_map[b][n+1] += 1
        gifts_map[b][n+2] -= 1
        
    # 친구별 다음 달 선물 예측
    for i in range(n):
        a = friends[i]
        for j in range(i + 1, n):
            b = friends[j]
            a_no, b_no = gifts_map[a][j], gifts_map[b][i]
            if a_no > b_no: answer[i] += 1
            elif a_no < b_no: answer[j] += 1
            else: #선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면
                a_gift_no, b_gift_no = gifts_map[a][-1], gifts_map[b][-1]
                if a_gift_no == b_gift_no: continue
                elif a_gift_no < b_gift_no: answer[j] += 1
                else: answer[i] += 1
    return max(answer)

"""
테스트 1 〉	통과 (0.06ms, 10.2MB)
테스트 2 〉	통과 (0.09ms, 10.3MB)
테스트 3 〉	통과 (0.10ms, 10.3MB)
테스트 4 〉	통과 (0.12ms, 10.3MB)
테스트 5 〉	통과 (1.58ms, 10.2MB)
테스트 6 〉	통과 (0.26ms, 10.2MB)
테스트 7 〉	통과 (0.98ms, 10.3MB)
테스트 8 〉	통과 (0.83ms, 10.4MB)
테스트 9 〉	통과 (6.22ms, 10.4MB)
테스트 10 〉	통과 (5.49ms, 10.6MB)
테스트 11 〉	통과 (7.06ms, 10.7MB)
테스트 12 〉	통과 (3.53ms, 10.5MB)
테스트 13 〉	통과 (11.10ms, 10.8MB)
테스트 14 〉	통과 (10.29ms, 10.6MB)
테스트 15 〉	통과 (12.28ms, 10.6MB)
테스트 16 〉	통과 (18.48ms, 10.8MB)
테스트 17 〉	통과 (0.07ms, 10.3MB)
테스트 18 〉	통과 (4.34ms, 10.5MB)
테스트 19 〉	통과 (12.38ms, 10.6MB)
테스트 20 〉	통과 (2.92ms, 10.3MB)
"""
