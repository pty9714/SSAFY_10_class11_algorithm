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
                text = ''
                for s in course[key][idx][0]:
                    text += s
                answer.append(text)
            else:
                break
    answer.sort()
                    
    
    return answer


# orders = ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]
# course = [2,3,4]
# print(solution(orders, course))

# 테스트 8 〉	통과 (7.59ms, 10.4MB)