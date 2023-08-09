times = [0] * 25 * 60

def solution(book_time):
    for time in book_time:
        start, end = map(lambda x: x.split(':'), time)
        start = int(start[0]) * 60 + int(start[1])
        end = int(end[0]) * 60 + int(end[1]) + 10
        for i in range(start, end):
            times[i] += 1
    answer = max(times)
    return answer


# 접근법 : 시간을 배열로 만들어서 더해줌
# 테스트 1 〉	통과 (0.17ms, 10.2MB)
# 테스트 2 〉	통과 (13.39ms, 10.4MB)
# 테스트 3 〉	통과 (37.49ms, 10.4MB)
# 테스트 4 〉	통과 (29.73ms, 10.5MB)
# 테스트 5 〉	통과 (0.12ms, 10.3MB)
# 테스트 6 〉	통과 (39.18ms, 10.6MB)
# 테스트 7 〉	통과 (50.86ms, 10.4MB)
# 테스트 8 〉	통과 (15.40ms, 10.2MB)
# 테스트 9 〉	통과 (7.44ms, 10.4MB)
# 테스트 10 〉	통과 (21.54ms, 10.5MB)
# 테스트 11 〉	통과 (35.89ms, 10.5MB)
# 테스트 12 〉	통과 (31.96ms, 10.4MB)
# 테스트 13 〉	통과 (6.43ms, 10.3MB)
# 테스트 14 〉	통과 (14.79ms, 10.4MB)
# 테스트 15 〉	통과 (32.20ms, 10.5MB)
# 테스트 16 〉	통과 (6.41ms, 10.3MB)
# 테스트 17 〉	통과 (17.36ms, 10.4MB)
# 테스트 18 〉	통과 (10.77ms, 10.4MB)
# 테스트 19 〉	통과 (8.16ms, 10.4MB)