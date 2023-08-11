from collections import deque
from heapq import heappush, heappop
# 노드 별로 아래를 다 더한 배열 만들기
def solution(info, edges):
    info = [-1 if x == 1 else 1 for x in info]
    info_sum = [x for x in info]
    tree = {i : [] for i in range(len(info))}
    find_sheep = [10000] * len(info)
    for edge in edges:
        tree[edge[0]].append(edge[1])
    
    for i in range(len(info)):
        q = deque()
        cnt = 0
        q.append((i, cnt))
        while q:
            node, cnt = q.popleft()
            if info[node] == 1:
                find_sheep[i]= cnt
                break
            for child in tree[node]:
                q.append((child, cnt+1))
    
    answer = 0
    state = 0
    childs = []
    heappush(childs, (0, 0))
    while childs:
        cnt, node = heappop(childs)
        # print(node)
        if info[node] == 1:
            answer += 1
        state += info[node]
        for child in tree[node]:
            heappush(childs, (find_sheep[child], child))
        if state == 0:
            break
    return answer


# info = [0,0,1,1,1,0,1,0,1,0,1,1]
# edges = [[0,1],[1,2],[1,4],[0,8],[8,7],[9,10],[9,11],[4,3],[6,5],[4,6],[8,9]]

# print(solution(info, edges))

# 실패한 코드
# 우선순위 큐에 담아서 풀었음
# 양까지 도달하는 위치를 생각해서, 양까지 도달하는 거리가 가장 적은 쪽부터 옮겨가는 방식
# 테케 4개 틀리게 나옴