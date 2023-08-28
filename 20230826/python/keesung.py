from heapq import heappush, heappop
def solution(play_time, adv_time, logs):
    logs = [list(map(time_to_num, x.split('-'))) for x in logs]
    # logs = [[time_to_num(x[0]), time_to_num(x[1])] for x in logs]
    play_time = time_to_num(play_time)
    adv_time = time_to_num(adv_time)
    
    arr = [0] * (play_time + 1)
    # print(logs)
    # for start_time, end_time in logs:
        # for time in range(start_time, end_time):
            # arr[time] += 1
    
    q = []
    logs.sort(reverse=True)
    time = 0
    while time <= play_time:
        while q:
            if q[0] < time:
                heappop(q)
            else:
                break
        arr[time] += len(q)
        # if time == 6000:
        #     print(arr[time], time)
        while logs:
            if time >= logs[-1][0]:
                start_time, end_time = logs.pop()
                # print(q, time, start_time, end_time)
                heappush(q, end_time)
                # print(q)
            else:
                break
        time += 1
                
            
            
    # print(arr[6313], arr[6314], arr[6315], arr[6316])
    now_time = sum(arr[:adv_time])
    max_time = now_time
    answer = 0
    for i in range(adv_time, play_time+1):
        now_time = now_time + arr[i] - arr[i-adv_time]
        if now_time > max_time:
            max_time = now_time
            answer = i - adv_time
    # print(max_time)
    tmp_time, S = answer // 60, answer % 60
    H, M = tmp_time // 60, tmp_time % 60
    answer = str(H).zfill(2) + ":" + str(M).zfill(2) + ":" + str(S).zfill(2)
    return answer

def time_to_num(tmp):
    time = list(map(int, tmp.split(":")))
    return time[0] * 60 * 60 + time[1] * 60 + time[2]

# print(solution(
#     "02:03:55",
#     "00:14:15",
#     	["01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"]
# ))
# print(solution(
#     "99:59:59",
#     "25:00:00",
#     	["69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"]
# ))
# print(solution(
#     "50:00:00",
#     "50:00:00",
#     	["15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"]
# ))

# 테스트 1 〉	통과 (3.66ms, 13.7MB)
# 테스트 2 〉	통과 (30.19ms, 14MB)
# 테스트 3 〉	통과 (71.95ms, 15.4MB)
# 테스트 4 〉	통과 (565.21ms, 33.1MB)
# 테스트 5 〉	통과 (898.58ms, 40.1MB)
# 테스트 6 〉	통과 (158.76ms, 13.7MB)
# 테스트 7 〉	통과 (1642.53ms, 68MB)
# 테스트 8 〉	통과 (1920.17ms, 68.2MB)
# 테스트 9 〉	통과 (2705.97ms, 95.1MB)
# 테스트 10 〉	통과 (2771.99ms, 93.6MB)
# 테스트 11 〉	통과 (2500.69ms, 93.5MB)
# 테스트 12 〉	통과 (2544.94ms, 93.6MB)
# 테스트 13 〉	통과 (2922.35ms, 93.5MB)
# 테스트 14 〉	통과 (2593.33ms, 90.8MB)
# 테스트 15 〉	통과 (51.86ms, 13.7MB)
# 테스트 16 〉	통과 (2784.48ms, 90.6MB)
# 테스트 17 〉	통과 (2733.07ms, 93.6MB)
# 테스트 18 〉	통과 (2687.15ms, 92MB)
# 테스트 19 〉	통과 (3.56ms, 13.6MB)
# 테스트 20 〉	통과 (1.59ms, 13.6MB)
# 테스트 21 〉	통과 (525.19ms, 31.6MB)
# 테스트 22 〉	통과 (466.99ms, 31.6MB)
# 테스트 23 〉	통과 (3124.82ms, 92.3MB)
# 테스트 24 〉	통과 (2450.51ms, 91.1MB)
# 테스트 25 〉	통과 (184.22ms, 13.7MB)
# 테스트 26 〉	통과 (114.20ms, 13.7MB)
# 테스트 27 〉	통과 (128.84ms, 13.7MB)
# 테스트 28 〉	통과 (93.33ms, 13.7MB)
# 테스트 29 〉	통과 (99.81ms, 13.7MB)
# 테스트 30 〉	통과 (67.19ms, 13.7MB)
# 테스트 31 〉	통과 (76.37ms, 13.7MB)