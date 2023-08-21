from bisect import bisect_left, bisect_right

def solution(edges, target):
    target = [0] + target
    tree = {}
    for edge in edges:
        if edge[0] not in tree:
            tree[edge[0]] = [edge[1]]
        else:
            tree[edge[0]].append(edge[1])
    for key in tree.keys():
        tree[key].sort()
    now_node = [0] * (len(target) + 1)
    order = []
    while True:
        node = 1
        while True:
            if node not in tree:
                order.append(node)
                break
            son = bisect_right(tree[node], now_node[node]) % len(tree[node])
            now_node[node] = tree[node][son]
            node = now_node[node]
        if len(order) % 2 == 0 and order[:len(order) // 2] == order[len(order) // 2:]:
            order = order[:len(order) // 2]
            break
    min_target = [0] * len(target)
    max_target = [0] * len(target)
    arr = [False] * len(target)
    for i in range(1, len(target)):
        if target[i] == 0:
            arr[i] = True
        elif i not in order:
            return [-1]
    signal = True
    while signal:
        for num in order:
            min_target[num] += 1
            max_target[num] += 3
            if min_target[num] > target[num]:
                return [-1]
            if target[num] <= max_target[num]:
                arr[num] = True
            # print(arr)
            if sum(arr) == len(arr) - 1:
                signal = False
                break
    answer = [[1] * x for x in min_target]
    for index, ans in enumerate(answer):
        new_index = 0
        if ans != []:
            while sum(ans) < target[index]:
                # print(index, new_index, ans)
                if ans[new_index] == 3:
                    new_index += 1
                ans[new_index] += 1
    
    new_answer = []
    signal = True
    while signal:
        for num in order:
            if answer[num] == []:
                signal = False
                break
            new_answer.append(answer[num].pop())
    answer = new_answer
    
    return answer

# edges = [[1, 3], [1, 2]]
# target = [0, 2, 1]
# edges = [[1, 2], [1, 3], [2, 4], [2, 5], [3, 6]]
# target = [0, 0, 0, 3, 0, 3]
# edges = [[2, 4], [1, 2], [6, 8], [1, 3], [5, 7], [2, 5], [3, 6], [6, 10], [6, 9]]
# target = [0, 0, 0, 3, 0, 0, 5, 1, 2, 3]
# print(solution(edges, target))
# edges = [[1, 2], [1, 3]]
# target = [0, 7, 3]
# print(solution(edges, target))


# 테스트 1 〉	통과 (0.03ms, 10.4MB)
# 테스트 2 〉	통과 (0.03ms, 10.1MB)
# 테스트 3 〉	통과 (0.03ms, 10.1MB)
# 테스트 4 〉	통과 (0.03ms, 10.3MB)
# 테스트 5 〉	통과 (0.03ms, 10.3MB)
# 테스트 6 〉	통과 (0.14ms, 10.2MB)
# 테스트 7 〉	통과 (0.11ms, 10.3MB)
# 테스트 8 〉	통과 (0.09ms, 10.1MB)
# 테스트 9 〉	통과 (0.10ms, 10.4MB)
# 테스트 10 〉	통과 (0.53ms, 10.5MB)
# 테스트 11 〉	통과 (0.74ms, 10.2MB)
# 테스트 12 〉	통과 (0.80ms, 10.2MB)
# 테스트 13 〉	통과 (0.34ms, 10.3MB)
# 테스트 14 〉	통과 (0.51ms, 10.3MB)
# 테스트 15 〉	통과 (110.30ms, 10.3MB)
# 테스트 16 〉	통과 (4.89ms, 10.1MB)
# 테스트 17 〉	통과 (256.06ms, 10.3MB)
# 테스트 18 〉	통과 (694.75ms, 10.5MB)
# 테스트 19 〉	통과 (127.45ms, 10.2MB)
# 테스트 20 〉	통과 (11.25ms, 10.3MB)
# 테스트 21 〉	통과 (4031.18ms, 11.1MB)
# 테스트 22 〉	통과 (0.40ms, 10.3MB)
# 테스트 23 〉	통과 (0.34ms, 10.2MB)
# 테스트 24 〉	통과 (0.32ms, 10.1MB)
# 테스트 25 〉	통과 (0.33ms, 10.3MB)