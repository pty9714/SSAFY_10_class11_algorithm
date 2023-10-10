import copy

answer = []
maxDiff = -1

def calc(ryan, apeach):
    sumL, sumA = 0, 0
    for idx, (l, a) in enumerate(zip(ryan, apeach)):
        if l > a:
            sumL += (10-idx)
        elif l == a == 0:
            continue
        else:
            sumA += (10-idx)
    return sumL - sumA


def dfs(apeach, ryan, n, idx):
    global maxDiff, answer
    
    # Termination 조건
    if idx == 11:
        # 화살이 남았으면 마지막 0점에 몰아주기
        if n > 0:
            ryan[10] = n
        scoreDiff = calc(ryan, apeach)
        if scoreDiff <= 0: # 라이언이 우승할 방법X
            return
        temp = copy.deepcopy(ryan)
        if scoreDiff > maxDiff:
            maxDiff = scoreDiff
            answer = [temp]
        elif scoreDiff == maxDiff:
            answer.append(temp)
        return
    
    # 점수 따는 경우
    if apeach[idx] < n:
        ryan.append(apeach[idx]+1)
        dfs(apeach, ryan, n - (apeach[idx]+1), idx+1)
        ryan.pop()
    
    # 점수 못따는 경우
    ryan.append(0)
    dfs(apeach, ryan, n, idx+1)
    ryan.pop()
    

def solution(n, info):
    global answer
    
    # 완전 탐색 - 2^11
    # 아예 0개를 쏘거나, 어피치+1 개를 쏘거나
    dfs(info, [], n, 0)
    
    # 정답형식 처리
    if len(answer) == 0:
        return [-1]
    
    # 가장 낮은 점수 개수가 많은 경우 선택
    answer.sort(key=lambda x: x[::-1], reverse=True)
    
    return answer[0]


테스트 1 〉	통과 (0.13ms, 10.2MB)
테스트 2 〉	통과 (6.24ms, 10.3MB)
테스트 3 〉	통과 (9.41ms, 10.3MB)
테스트 4 〉	통과 (1.21ms, 10.2MB)
테스트 5 〉	통과 (4.30ms, 10.3MB)
테스트 6 〉	통과 (7.16ms, 10.3MB)
테스트 7 〉	통과 (0.92ms, 10.3MB)
테스트 8 〉	통과 (0.80ms, 10.3MB)
테스트 9 〉	통과 (1.06ms, 10.3MB)
테스트 10 〉	통과 (0.33ms, 10.2MB)
테스트 11 〉	통과 (1.47ms, 10.4MB)
테스트 12 〉	통과 (0.76ms, 10.4MB)
테스트 13 〉	통과 (2.61ms, 10.4MB)
테스트 14 〉	통과 (2.67ms, 10.4MB)
테스트 15 〉	통과 (3.22ms, 10.3MB)
테스트 16 〉	통과 (1.68ms, 10.3MB)
테스트 17 〉	통과 (1.97ms, 10.4MB)
테스트 18 〉	통과 (0.15ms, 10.5MB)
테스트 19 〉	통과 (0.04ms, 10.3MB)
테스트 20 〉	통과 (4.45ms, 10.3MB)
테스트 21 〉	통과 (2.89ms, 10.4MB)
테스트 22 〉	통과 (4.14ms, 10.3MB)
테스트 23 〉	통과 (0.26ms, 10.5MB)
테스트 24 〉	통과 (7.53ms, 10.3MB)
테스트 25 〉	통과 (11.92ms, 10.4MB)
