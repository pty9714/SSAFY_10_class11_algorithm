from collections import deque
from heapq import heappush, heappop
# 노드 별로 아래를 다 더한 배열 만들기
def solution(info, edges):
    info = [-1 if x == 1 else 1 for x in info]
    # info_sum = [x for x in info]
    tree = {i : {'parent' : 0, 'childs' : []} for i in range(len(info))}
    
    distances = [10000] * len(info)
    distances[0] = 1
    
    for edge in edges:
        tree[edge[0]]['childs'].append(edge[1])
        tree[edge[1]]['parent'] = edge[0]
    
    # 자식에 있는 늑대 없애기
    signal = True
    while signal:
        signal = False
        for key in tree.keys():
            if tree[key]['childs'] == [] and info[key] == -1:
                parent = tree[key]['parent']
                info[key] = 0
                tree[parent]['childs'].remove(key)
                signal = True
    
    # 양끼리 붙거나, 늑대끼리 붙으면 더해줌
    while True:
        signal = False
        for key in tree.keys():
            if tree[key]['childs'] == []:
                continue
            if info[key] != 0:
                parent = tree[key]['parent']
                while tree[parent]['childs'] == []:
                    parent = tree[parent]['parent']
                if info[key] * info[parent] > 0 and key != parent:
                    if info[key] < 0 and info[parent] < 0:
                        if len(tree[parent]['childs']) > 1:
                            continue
                    # print(tree)
                    # print(key, parent)
                    # print(tree[parent]['childs'])
                    tree[parent]['childs'].remove(key)
                    tree[parent]['childs'] += tree[key]['childs']
                    tree[key]['childs'] = []
                    info[parent] += info[key]
                    signal = True
        if not signal:
            break
    # print(info)
    
    answer = 0
    queue = deque()
    queue.append([[0], info[0], 0]) # 들어간 애들, 양, 늑대
    while queue:
        # print(queue)
        path, sheep, wolf = queue.popleft()
        if sheep <= -1 * wolf:
            continue
        answer = max(answer, sheep)
        # print(path, sheep, wolf)
        childs = []
        for key in path:
            for child in tree[key]['childs']:
                if child not in path:
                    childs.append(child)
        # print(childs)
        for child in childs:
            if info[child] > 0:
                queue.append([path + [child], sheep + info[child], wolf])
            elif info[child] < 0:
                queue.append([path + [child], sheep, wolf + info[child]])
    
    # print(info)
    # print(tree)
    
    return answer


# info = [0,0,1,1,1,0,1,0,1,0,1,1]
# edges = [[0,1],[1,2],[1,4],[0,8],[8,7],[9,10],[9,11],[4,3],[6,5],[4,6],[8,9]]

info = [0,1,0,1,1,0,1,0,0,1,0]	
edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6],[3,7],[4,8],[6,9],[9,10]]

print(solution(info, edges))

# 실패한 코드
# 우선순위 큐에 담아서 풀었음
# 양까지 도달하는 위치를 생각해서, 양까지 도달하는 거리가 가장 적은 쪽부터 옮겨가는 방식
# 테케 4개 틀리게 나옴


# 테스트 1 〉	통과 (0.01ms, 10.3MB)
# 테스트 2 〉	통과 (0.12ms, 10.4MB)
# 테스트 3 〉	통과 (0.03ms, 10.3MB)
# 테스트 4 〉	통과 (0.02ms, 10.4MB)
# 테스트 5 〉	통과 (0.19ms, 10.2MB)
# 테스트 6 〉	통과 (0.06ms, 10.4MB)
# 테스트 7 〉	통과 (0.06ms, 10.3MB)
# 테스트 8 〉	통과 (0.10ms, 10.4MB)
# 테스트 9 〉	통과 (0.12ms, 10.3MB)
# 테스트 10 〉	통과 (0.13ms, 10.4MB)
# 테스트 11 〉	통과 (0.11ms, 10.4MB)
# 테스트 12 〉	통과 (0.16ms, 10.3MB)
# 테스트 13 〉	통과 (0.04ms, 10.2MB)
# 테스트 14 〉	통과 (0.05ms, 10.4MB)
# 테스트 15 〉	통과 (0.26ms, 10.2MB)
# 테스트 16 〉	통과 (0.32ms, 10.3MB)
# 테스트 17 〉	통과 (0.60ms, 10.3MB)
# 테스트 18 〉	통과 (0.03ms, 10.3MB)


# 리프노드에 있는 늑대는 볼 필요 없으므로 없애기
# 양끼리 붙어있으면 양끼리 다 더함
# 늑대끼리 붙어있으면, 자식이 1개 일때만 더함
# 모든 경로 q에 추가해서 탐색