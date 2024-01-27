def solution(s):
    answer = []
    ns = sorted(s[2:-2].split("},{"), key=lambda x: len(x))
    for c in ns:
        for x in c.split(","):
            if x not in answer:
                answer.append(x)
    return list(map(int, answer))

"""
테스트 1 〉	통과 (0.03ms, 10.3MB)
테스트 2 〉	통과 (0.02ms, 10.1MB)
테스트 3 〉	통과 (0.02ms, 10.2MB)
테스트 4 〉	통과 (0.04ms, 10.3MB)
테스트 5 〉	통과 (0.34ms, 10.4MB)
테스트 6 〉	통과 (0.69ms, 10.2MB)
테스트 7 〉	통과 (33.51ms, 10.5MB)
테스트 8 〉	통과 (184.57ms, 10.7MB)
테스트 9 〉	통과 (53.04ms, 10.8MB)
테스트 10 〉	통과 (258.52ms, 10.7MB)
테스트 11 〉	통과 (288.22ms, 11.2MB)
테스트 12 〉	통과 (412.12ms, 12MB)
테스트 13 〉	통과 (410.94ms, 11.9MB)
테스트 14 〉	통과 (421.41ms, 11.9MB)
테스트 15 〉	통과 (0.03ms, 10.3MB)
"""
