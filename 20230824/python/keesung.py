def solution(fees, records):
    cars = {}
    for record in records:
        time, car, state = record.split(" ")
        time = time.split(':')
        time = int(time[0]) * 60 + int(time[1])
        if car not in cars:
            cars[car] = {
                'state': state,
                'time' : time,
                'fee' : 0
            }
        if state == 'IN':
            cars[car]['time'] = time
            cars[car]['state'] = state
        else:
            cars[car]['fee'] += time - cars[car]['time']
            cars[car]['state'] = state
            
    for car in cars:
        if cars[car]['state'] == 'IN':
            tmp_time = (23 * 60 + 59) - cars[car]['time']
            cars[car]['fee'] += tmp_time
        add_time = (cars[car]['fee'] - fees[0]) / fees[2]
        print(car, add_time, cars[car]['fee'] )
        if add_time <= 0:
            add_time = 0
        else:
            if add_time == int(add_time):
                add_time = int(add_time)
            else:
                add_time = int(add_time) + 1
        cars[car]['fee'] = fees[1] + add_time * fees[3]
            
    answer = []
    for car in sorted(cars):
        answer.append(cars[car]['fee'])
    
    return answer

# fees = [180, 5000, 10, 600]
# records = ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]
# print(solution(fees, records))

# 테스트 1 〉	통과 (0.06ms, 10.3MB)
# 테스트 2 〉	통과 (0.05ms, 10.3MB)
# 테스트 3 〉	통과 (0.09ms, 10.4MB)
# 테스트 4 〉	통과 (0.11ms, 10.3MB)
# 테스트 5 〉	통과 (0.28ms, 10.4MB)
# 테스트 6 〉	통과 (0.33ms, 10.5MB)
# 테스트 7 〉	통과 (2.39ms, 10.8MB)
# 테스트 8 〉	통과 (0.92ms, 10.3MB)
# 테스트 9 〉	통과 (0.35ms, 10.4MB)
# 테스트 10 〉	통과 (1.92ms, 10.7MB)
# 테스트 11 〉	통과 (3.24ms, 10.6MB)
# 테스트 12 〉	통과 (3.22ms, 10.7MB)
# 테스트 13 〉	통과 (0.05ms, 10.4MB)
# 테스트 14 〉	통과 (0.04ms, 10.6MB)
# 테스트 15 〉	통과 (0.03ms, 10.4MB)
# 테스트 16 〉	통과 (0.04ms, 10.4MB)