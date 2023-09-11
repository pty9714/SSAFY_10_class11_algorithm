from collections import deque
def solution(n, t, m, timetable):
    # 시간 테이블 만들기 (pop 때문에 deque)
    timetable = deque(sorted(list(map(change, timetable))))
    # 버스 시간표 만들기
    bus_times = [540 + i * t for i in range(n)]
    answer = 0
    for bus in bus_times:
        cnt = 0
        if timetable:
            now_time = timetable[0]
            # 타임테이블이 버스보다 느리면, 콘은 버스에 맞춰서 도착
            if now_time > bus:
                answer = max(answer, bus)
                continue
            # 아니면 버스보다 1분 도착하는 것부터 카운트
            answer = max(answer, now_time-1)
            # 스택 초기화
            stack = []
            # timetable 있고, 스택 길이 m보다 작고, timetable[0]이 버스시간보다 작거나 같을때 실행
            while timetable and len(stack) < m and timetable[0] <= bus:
                # 시간이 같으면 무조건 넣어줌
                if now_time == timetable[0]:
                    stack.append(timetable.popleft())
                # 시간 달라지면 answer 업데이트, 다시 기준점 시간도 업데이트
                else:
                    now_time = timetable[0]
                    answer = max(answer, now_time - 1)
            # 다 태웠는데도 스택이 m보다 작으면 버스랑 맞춰서 도착
            if len(stack) < m:
                answer = max(answer, bus)
    answer = str(answer // 60).zfill(2) + ":" + str(answer % 60).zfill(2)
    return answer

def change(time):
    H, M = map(int, time.split(":"))
    return H * 60 + M



# 테스트 1 〉	통과 (0.03ms, 10.5MB)
# 테스트 2 〉	통과 (0.03ms, 10.5MB)
# 테스트 3 〉	통과 (0.04ms, 10.5MB)
# 테스트 4 〉	통과 (0.03ms, 10.5MB)
# 테스트 5 〉	통과 (0.05ms, 10.3MB)
# 테스트 6 〉	통과 (0.04ms, 10.4MB)
# 테스트 7 〉	통과 (0.45ms, 10.4MB)
# 테스트 8 〉	통과 (0.03ms, 10.4MB)
# 테스트 9 〉	통과 (0.04ms, 10.4MB)
# 테스트 10 〉	통과 (0.03ms, 10.3MB)
# 테스트 11 〉	통과 (0.04ms, 10.4MB)
# 테스트 12 〉	통과 (0.37ms, 10.6MB)
# 테스트 13 〉	통과 (0.40ms, 10.3MB)
# 테스트 14 〉	통과 (0.10ms, 10.5MB)
# 테스트 15 〉	통과 (0.11ms, 10.3MB)
# 테스트 16 〉	통과 (0.29ms, 10.5MB)
# 테스트 17 〉	통과 (0.38ms, 10.4MB)
# 테스트 18 〉	통과 (0.35ms, 10.4MB)
# 테스트 19 〉	통과 (0.50ms, 10.4MB)
# 테스트 20 〉	통과 (0.38ms, 10.4MB)
# 테스트 21 〉	통과 (1.67ms, 10.5MB)
# 테스트 22 〉	통과 (0.45ms, 10.5MB)
# 테스트 23 〉	통과 (0.37ms, 10.4MB)
# 테스트 24 〉	통과 (2.78ms, 10.5MB)