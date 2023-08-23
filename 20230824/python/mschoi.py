from collections import defaultdict
import math

def solution(fees, records):
    answer = []
    statusDict, timeDict = defaultdict(lambda: False), defaultdict(lambda: 0)
    resultDict = defaultdict(lambda: 0)
    
    for record in records:
        time, carNum, status = record.split(" ")
        hr, m = map(int, time.split(":"))
        getTime = hr*60 + m
        
        # IN
        if statusDict[carNum] == False and status == "IN":
            statusDict[carNum] = True
            timeDict[carNum] += getTime
        # OUT
        elif statusDict[carNum] and status == "OUT":
            statusDict[carNum] = False
            timeDiff = getTime - timeDict[carNum]            
            resultDict[carNum] += timeDiff
            timeDict[carNum] = 0
    
    # IN, 하지만 자정까지 OUT 기록은 없는 경우
    for items, values in statusDict.items():
        if values:
            maxTime = 23*60 + 59
            resultDict[items] += maxTime - timeDict[items]
    
    # 주차 요금 환산
    nTime, nFee, perTime, perFee = map(int, fees)
    for i,v in sorted(resultDict.items()):
        totalPrice = 0
        # 기본 시간 초과
        if v > nTime:
            v -= nTime
            totalPrice += nFee
            totalPrice += math.ceil(v/perTime)*perFee
        else:
            totalPrice += nFee
        
        answer.append(totalPrice)
        
    return answer

테스트 1 〉	통과 (0.06ms, 10.4MB)
테스트 2 〉	통과 (0.03ms, 10.4MB)
테스트 3 〉	통과 (0.07ms, 10.2MB)
테스트 4 〉	통과 (0.08ms, 10.4MB)
테스트 5 〉	통과 (0.21ms, 10.3MB)
테스트 6 〉	통과 (0.36ms, 10.3MB)
테스트 7 〉	통과 (1.69ms, 10.5MB)
테스트 8 〉	통과 (1.57ms, 10.4MB)
테스트 9 〉	통과 (0.82ms, 10.4MB)
테스트 10 〉	통과 (1.45ms, 10.4MB)
테스트 11 〉	통과 (3.17ms, 10.5MB)
테스트 12 〉	통과 (3.40ms, 10.6MB)
테스트 13 〉	통과 (0.04ms, 10.3MB)
테스트 14 〉	통과 (0.04ms, 10.5MB)
테스트 15 〉	통과 (0.03ms, 10.2MB)
테스트 16 〉	통과 (0.02ms, 10.3MB)
