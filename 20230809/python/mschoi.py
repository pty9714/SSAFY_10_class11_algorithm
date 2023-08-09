import heapq

def solution(book_time):
    answer = 0
    times = []
    
    # IN -> 1, OUT -> 0
    for start, end in book_time:
        times.append([int(start[:2])*60 + int(start[3:]), 1])
        times.append([int(end[:2])*60 + int(end[3:])+10, 0])
    times.sort()
    
    # 입실, 퇴실 구분하여 최댓값 갱신
    now = 0
    for item in times:
        if item[1] == 1:
            now += 1
        else:
            now -= 1
        answer = max(answer, now)
    
    return answer

---
테스트 11 〉	통과 (3.57ms, 10.8MB)
