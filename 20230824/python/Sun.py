import math

def solution(fees, records):
    answer_pair = []
    answer = []
    dic = {}
    for i in records:
        time, number, io = i.split()
        hour,minute = time.split(':')
        dic[number] = dic.get(number,[]) + [int(hour)*60+int(minute)]
    
    for i,j in dic.items():
        t = 0
        if len(j)%2 == 0:
            for k in range(0,len(j),2):
                t += j[k+1]-j[k]
        else:
            for k in range(0,len(j)-1,2):
                t += j[k+1]-j[k]
            t += 23*60+59-j[-1]
        
        if t<=fees[0]:
            answer_pair.append((i,fees[1]))
        else:
            answer_pair.append((i,fees[1] + math.ceil((t-fees[0])/fees[2])*fees[3]))
    answer_pair.sort(key = lambda x: x[0])
    for i,j in answer_pair:
        answer.append(j)
    return answer

f = [120, 0, 60, 591]
r = ["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"]

print(solution(f,r))