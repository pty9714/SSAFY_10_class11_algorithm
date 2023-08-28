def solution(play_time, adv_time, logs):
    logs = [list(map(time_to_num, x.split('-'))) for x in logs]
    # logs = [[time_to_num(x[0]), time_to_num(x[1])] for x in logs]
    play_time = time_to_num(play_time)
    adv_time = time_to_num(adv_time)
    
    arr = [0] * (play_time + 1)
    # print(logs)
    for start_time, end_time in logs:
        for time in range(start_time, end_time):
            arr[time] += 1
    # print(arr[6313], arr[6314], arr[6315], arr[6316])
    now_time = sum(arr[:adv_time])
    max_time = now_time
    answer = 0
    for i in range(adv_time, play_time+1):
        now_time = now_time + arr[i] - arr[i-adv_time]
        if now_time > max_time:
            max_time = now_time
            answer = i - adv_time + 1
    print(max_time)
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