def solution(fees, records):
    cars = dict()
    
    for record in records:
        time, no, way = record.split()
        hr, mins = time.split(":")
        time = int(hr) * 60 + int(mins)
        if no in cars:
            cars[no].append(time)
        else:
            cars[no] = [time]
    
    result = []
    for times in sorted(cars):
        temp = 0
        if len(times)%2 != 0:
            temp += 1439 - temp[-1]
        if len(times) >= 2:
            for i in len(times)//2:
                 temp += time[i+1] - time[i]
        cost = fees[1]
        if temp > fees[0]:
            cost += Math.ceil((temp-fees[0]) / fees[2]) * fees(3)
        result.append(cost)

    return result
