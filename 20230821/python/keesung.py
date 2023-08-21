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
        
    now_value = [0] * (len(target))
    result = dfs(target, [], order, now_value)
    if result == False:
        answer = [-1]
    else:
        answer = [[] for _ in range(len(target))]
        for i in range(len(result)):
            answer[order[i % len(order)]].append(result[i])
        for ans in answer:
            ans.sort()
        new_answer = []
        signal = True
        while signal:
            for index in order:
                if len(answer[index]) >= 1:
                    new_answer.append(answer[index].pop(0))
                else:
                    signal = False
                    break
        answer = new_answer
    return answer

def dfs(target, result, order, now_value):
    # print(result)
    # print(now_value)
    if len(result) > 0:
        index = order[(len(result) - 1) % len(order)]
        now_value[index] += result[-1]
        if now_value[index] > target[index]:
            now_value[index] -= result[-1]
        #     print('-----------')
        #     print(now_value)
        #     print(target)
        #     print('-----------')
            return False
    # print(now_value)
    if now_value == target:
        return result
    for i in range(3, 0, -1):
        tmp = dfs(target, result + [i], order, now_value)
        if tmp != False:
            return tmp
    # tmp = dfs(target, result + [0], order)
    # if tmp != False:
    #     return tmp
    if len(result) > 0:
        now_value[index] -= result[-1]
    return False

# edges = [[2, 4], [1, 2], [6, 8], [1, 3], [5, 7], [2, 5], [3, 6], [6, 10], [6, 9]]
# target = [0, 0, 0, 3, 0, 0, 5, 1, 2, 3]
# print(solution(edges, target))
# edges = [[1, 2], [1, 3]]
# target = [0, 7, 3]
# print(solution(edges, target))