def solution(n, t, m, timetable):
    answer = ''
    crewTime = []
    for tt in timetable:
        hh, mm = map(int, tt.split(":"))
        crewTime.append(hh * 60 + mm)
    crewTime.sort()
    busTime = [540 + t * i for i in range(n)]
    i = 0 # 셔틀 버스 수
    for bt in busTime:
        cnt = 0 # 현재 셔틀에 탄 크루 수
        while cnt < m and i < len(crewTime) and crewTime[i] <= bt:
            i += 1
            cnt += 1
        if cnt < m: answer = bt
        else: answer = crewTime[i - 1] - 1
    return str(answer // 60).zfill(2) + ":" + str(answer % 60).zfill(2)

"""
테스트 1 〉	통과 (0.05ms, 10.4MB)
테스트 2 〉	통과 (0.04ms, 10.4MB)
테스트 3 〉	통과 (0.05ms, 10.5MB)
테스트 4 〉	통과 (0.05ms, 10.4MB)
테스트 5 〉	통과 (0.07ms, 10.4MB)
테스트 6 〉	통과 (0.04ms, 10.4MB)
테스트 7 〉	통과 (0.64ms, 10.4MB)
테스트 8 〉	통과 (0.04ms, 10.5MB)
테스트 9 〉	통과 (0.03ms, 10.5MB)
테스트 10 〉	통과 (0.04ms, 10.3MB)
테스트 11 〉	통과 (0.04ms, 10.4MB)
테스트 12 〉	통과 (0.71ms, 10.4MB)
테스트 13 〉	통과 (0.60ms, 10.4MB)
테스트 14 〉	통과 (0.10ms, 10.4MB)
테스트 15 〉	통과 (0.16ms, 10.5MB)
테스트 16 〉	통과 (0.15ms, 10.5MB)
테스트 17 〉	통과 (0.68ms, 10.5MB)
테스트 18 〉	통과 (0.50ms, 10.3MB)
테스트 19 〉	통과 (0.32ms, 10.5MB)
테스트 20 〉	통과 (0.36ms, 10.4MB)
테스트 21 〉	통과 (1.13ms, 10.5MB)
테스트 22 〉	통과 (0.75ms, 10.5MB)
테스트 23 〉	통과 (0.59ms, 10.4MB)
테스트 24 〉	통과 (2.46ms, 10.5MB)
"""
