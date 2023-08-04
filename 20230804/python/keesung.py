from itertools import combinations

def solution(orders, course):
    answer = []
    graph = [[0] * 27 for _ in range(len(orders))]
    for idx, order in enumerate(orders):
        for s in order:
            graph[idx][ord(s) - ord('A')] = 1
    course = {
        x : {} for x in course
    }
    for node1 in range(len(orders)-1):
        for node2 in range(node1+1, len(orders)):
            new_sum = [x + y for x, y in zip(graph[node1], graph[node2])]
            text = ''
            for idx in range(27):
                if new_sum[idx] >= 2:
                    text += chr(idx + ord('A'))
            for length in course.keys():
                add_list = list(combinations(text, length))
                for txt in add_list:
                    if txt in course[length].keys():
                        course[length][txt] += 1
                    else:
                        course[length][txt] = 1
    for key in course.keys():
        if len(course[key]) == 0:
            continue
        course[key] = sorted(course[key].items(), key=lambda x: x[1], reverse=True)
        max_val = course[key][0][1]
        # print(course[key])
        for idx in range(len(course[key])):
            if course[key][idx][1] == max_val:
                answer.append("".join(course[key][idx][0]))
            else:
                break
    answer.sort()
                    
    
    return answer


# orders = ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]
# course = [2,3,4]
# print(solution(orders, course))

# 테스트 8 〉	통과 (6.86ms, 10.4MB)


# 두개의 음식에서 중복이 되면 해당 조합은 사용 가능하다.
# graph에 0배열을 만들고, 해당하는 숫자에 1을 입력해둔다
# 두개 그래프를 더해서 2가 나오는 것만 뺴서 그 조합의 부분집합으로 구성된 것들만 더해준다,