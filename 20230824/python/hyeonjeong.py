import math

def solution(fees, records):
    cars = dict() # key: 차량번호, value: [압차 시간, 출차 시간, ...]
    
    for record in records:
        time, no, way = record.split()
        hr, mins = time.split(":")
        time = int(hr) * 60 + int(mins) # 분으로 변환
        if no in cars:
            cars[no].append(time)
        else:
            cars[no] = [time]
    
    result = []
    for no in sorted(cars): # 차량번호 오름차순으로 정렬
        times = cars[no]
        
        temp = 0 # 누적 시간 계산
        if len(times)%2 != 0:
            times.append(1439) # 마지막 출차 시간 23:59
        for i in range(0, len(times), 2):
            temp += times[i+1] - times[i]
        
        cost = fees[1] # 주차 요금
        if temp > fees[0]:
            cost += math.ceil((temp-fees[0]) / fees[2]) * fees[3]
        result.append(cost) 

    return result

# 테스트 11 〉	통과 (1.88ms, 10.5MB)
