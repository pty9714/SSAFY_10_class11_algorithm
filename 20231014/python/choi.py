from collections import defaultdict
from bisect import bisect_left
information = dict()

def init():
    global information
    information["cpp"] = "1"
    information["java"] = "2"
    information["python"] = "3"
    information["backend"] = "1"
    information["frontend"] = "2"
    information["junior"] = "1"
    information["senior"] = "2"
    information["chicken"] = "1"
    information["pizza"] = "2"
    information["-"] = "-"
    
    

def solution(info, query):
    global information
    result = defaultdict(list)
    answer = []
    
    init()
    
    for item in info:
        lang, sub, stat, food, score = item.split()
        temp = ""
        # 개발언어, 직군, 경력구분, 소울푸드
        temp += information[lang]
        temp += information[sub]
        temp += information[stat]
        temp += information[food]
        
        # 마스킹 처리 후 저장
        result[temp].append(int(score))
        for idx in range(4):
            tmp = list(temp)
            tmp[idx] = '-'
            result[''.join(tmp)].append(int(score))
        for idx in range(3):
            for j in range(idx+1, 4):
                tmp = list(temp)
                tmp[idx] = '-'
                tmp[j] = '-'
                result[''.join(tmp)].append(int(score))
        for idx in range(2):
            for j in range(idx+1, 3):
                for k in range(j+1, 4):
                    tmp = list(temp)
                    tmp[idx] = '-'
                    tmp[j] = '-'
                    tmp[k] = '-'
                    result[''.join(tmp)].append(int(score))
        result["----"].append(int(score))
    
    # 정렬
    for value in result.values():
        value.sort()
    
    # 질의
    for qitem in query:
        ans = 0
        qList = qitem.split()
        qtemp, qscore = "", 0
        for item in qList:
            if item != "and":
                if item in information.keys():
                    qtemp += information[item]
                else:
                    qscore = int(item)
        # 비교
        count = 0
        for k, v in result.items():
            if k == qtemp:
                idx = bisect_left(v, qscore) # 이분 탐색으로 최적화
                count = len(v) - idx
        answer.append(count)   
    
    return answer

효율성  테스트
테스트 1 〉	통과 (1412.93ms, 61.1MB)
테스트 2 〉	통과 (1313.10ms, 60.9MB)
테스트 3 〉	통과 (1246.17ms, 60.5MB)
테스트 4 〉	통과 (1256.92ms, 61.2MB)
