V, parent = 0, []

def find(v):
    global parent
    
    # 루트 노드가 아니라면 부모 노드에 루트 노드를 바로 저장
    if parent[v] != v: 
        parent[v] = find(parent[v])
    return parent[v]

def union(a, b):
    global parent
    
    a = find(a)
    b = find(b)
    # 작은 쪽이 더 넓은 개념
    if a < b: 
        parent[b] = a
    else:
        parent[a] = b

# 크루스칼 알고리즘
def kruskal(costs):
    global V
    cost = cnt = 0
    for a, b, c in costs:
        # 사이클이 없을 때만 추가
        if find(a) != find(b):
            union(a, b)
            cost += c
            cnt += 1
            if cnt == V-1:
                break
    
    return cost

def solution(n, costs):
    global parent, V
    
    V, E = n, len(costs)
    parent = list(range(V+1))
    # 가중치 오름차순으로 정렬
    costs.sort(key=lambda x: x[2])
    
    return kruskal(costs)


# 테스트 6 〉	통과 (0.04ms, 10.4MB)
