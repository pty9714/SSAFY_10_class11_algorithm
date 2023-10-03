def solution(record):
    lst = []
    dic = {}
    answer = []
    for s in record:
        if s[0] == 'E':
            e,id,nickname = s.split()
            lst.append((1,id))
            dic[id] = nickname
        elif s[0] == 'C':
            c,id,nickname = s.split()
            dic[id] = nickname
        else:
            l,id = s.split()
            lst.append((2,id))

    for i in lst:
        if i[0] == 1:
            t = dic[i[1]] + "님이 들어왔습니다."
            answer.append(t)
        else:
            t = dic[i[1]] + "님이 나갔습니다."
            answer.append(t)
    
    return answer




record = ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
print(solution(record))

# 테스트 1 〉	통과 (0.01ms, 10.4MB)
# 테스트 2 〉	통과 (0.01ms, 10.3MB)
# 테스트 3 〉	통과 (0.03ms, 10.3MB)
# 테스트 4 〉	통과 (0.03ms, 10.4MB)
# 테스트 5 〉	통과 (0.63ms, 10.4MB)
# 테스트 6 〉	통과 (0.65ms, 10.4MB)
# 테스트 7 〉	통과 (0.50ms, 10.4MB)
# 테스트 8 〉	통과 (0.72ms, 10.4MB)
# 테스트 9 〉	통과 (0.71ms, 10.7MB)
# 테스트 10 〉	통과 (0.76ms, 10.5MB)
# 테스트 11 〉	통과 (0.35ms, 10.4MB)
# 테스트 12 〉	통과 (0.39ms, 10.5MB)
# 테스트 13 〉	통과 (0.62ms, 10.5MB)
# 테스트 14 〉	통과 (0.70ms, 10.4MB)
# 테스트 15 〉	통과 (0.01ms, 10.3MB)
# 테스트 16 〉	통과 (0.01ms, 10.4MB)
# 테스트 17 〉	통과 (0.11ms, 10.1MB)
# 테스트 18 〉	통과 (0.10ms, 10.2MB)
# 테스트 19 〉	통과 (0.80ms, 10.6MB)
# 테스트 20 〉	통과 (0.48ms, 10.3MB)
# 테스트 21 〉	통과 (0.49ms, 10.3MB)
# 테스트 22 〉	통과 (0.51ms, 10.3MB)
# 테스트 23 〉	통과 (0.68ms, 10.6MB)
# 테스트 24 〉	통과 (0.70ms, 10.5MB)
# 테스트 25 〉	통과 (91.53ms, 46.7MB)
# 테스트 26 〉	통과 (101.59ms, 52.2MB)
# 테스트 27 〉	통과 (88.84ms, 54.8MB)
# 테스트 28 〉	통과 (92.80ms, 56.8MB)
# 테스트 29 〉	통과 (93.74ms, 57MB)
# 테스트 30 〉	통과 (70.65ms, 39.4MB)
# 테스트 31 〉	통과 (72.65ms, 46.2MB)
# 테스트 32 〉	통과 (63.24ms, 41.4MB)