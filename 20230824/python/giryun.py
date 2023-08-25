from collections import defaultdict
import math


def solution(fees, records):
    record_dic = defaultdict(list) # 차량별 주차 시간 기록
    result_dic = defaultdict(int) # 차량별 주차 시간 계산
    for rc in records:
        t, n, x = rc.split() # 시각, 차량 번호, 내역
        if x == 'IN':
            record_dic[n].append(t)
        else:
            tx, ty = map(int, record_dic[n].pop().split(":"))
            x, y = map(int, t.split(":"))
            result_dic[n] += (x - tx) * 60 + (y - ty)

    for k, v in record_dic.items(): # 23:59에 출차된 차량들 주차 시간 계산
        if v != []:
            tx, ty = map(int, record_dic[k].pop().split(":"))
            result_dic[k] += (23 - tx) * 60 + (59 - ty)
            
    return [fees[1] + math.ceil((v - fees[0]) / fees[2]) * fees[3] if v > fees[0] else fees[1] for k, v in sorted(result_dic.items())]
