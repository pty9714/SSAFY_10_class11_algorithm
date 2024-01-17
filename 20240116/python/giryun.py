from collections import defaultdict

def solution(edges):
    answer = [0, 0, 0, 0]

    dic = defaultdict(list)
    for a, b in edges:
        if not dic.get(a): dic[a] = [0, 0]
        if not dic.get(b): dic[b] = [0, 0]
        
        # 준 것, 받은 것 카운팅
        # a, b는 a가 b에 준 것, b가 a에게 받은 것
        dic[a][0] += 1
        dic[b][1] += 1
    
    for key, val in dic.items():
        # 그래프는 최소 2개 이상으로 준 것만 2개 이상인 정점이 생성점
        if val[0] >= 2 and val[1] == 0: answer[0] = key
        # 받은 것만 있는 정점의 개수는 막대 그래프의 개수
        elif val[0] == 0 and val[1] > 0: answer[2] += 1
        # 준 것, 받은 것 각각 2개 이상인 점의 개수는 8자 그래프의 개수
        elif val[0] >= 2 and val[1] >= 2: answer[3] += 1
    
    # 전체 그래프 개수인 생성점의 준 것에서 2종류의 그래프를 빼면 도넛 그래프의 개수
    answer[1] = (dic[answer[0]][0] - answer[2] - answer[3])

    return answer
  """
  테스트 1 〉	통과 (0.06ms, 10.3MB)
테스트 2 〉	통과 (0.11ms, 10.2MB)
테스트 3 〉	통과 (0.13ms, 10.4MB)
테스트 4 〉	통과 (0.06ms, 10.2MB)
테스트 5 〉	통과 (0.41ms, 10.4MB)
테스트 6 〉	통과 (0.36ms, 10.4MB)
테스트 7 〉	통과 (1.41ms, 10.3MB)
테스트 8 〉	통과 (438.04ms, 92.2MB)
테스트 9 〉	통과 (276.07ms, 70.3MB)
테스트 10 〉	통과 (660.23ms, 134MB)
테스트 11 〉	통과 (467.19ms, 92.5MB)
테스트 12 〉	통과 (410.50ms, 92.9MB)
테스트 13 〉	통과 (447.13ms, 91.3MB)
테스트 14 〉	통과 (922.92ms, 172MB)
테스트 15 〉	통과 (477.54ms, 92.1MB)
테스트 16 〉	통과 (244.64ms, 70.4MB)
테스트 17 〉	통과 (722.79ms, 131MB)
테스트 18 〉	통과 (558.03ms, 92.2MB)
테스트 19 〉	통과 (442.34ms, 92.2MB)
테스트 20 〉	통과 (353.39ms, 85.4MB)
테스트 21 〉	통과 (789.49ms, 166MB)
테스트 22 〉	통과 (693.01ms, 138MB)
테스트 23 〉	통과 (591.84ms, 138MB)
테스트 24 〉	통과 (626.76ms, 138MB)
테스트 25 〉	통과 (595.01ms, 139MB)
테스트 26 〉	통과 (625.75ms, 139MB)
채점 결과
정확성: 100.0
"""
