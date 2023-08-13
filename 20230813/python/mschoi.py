# 사이클 찾기 -> 유니온 파인드
def find(v):
    # 루트 노드가 아니라면 부모 노드에 루트 노드를 바로 저장
    if parent[v] != v: 
        parent[v] = find(parent[v])
    return parent[v]

def union(a, b):
    a = find(a)
    b = find(b)
    # 작은 쪽이 더 넓은 개념
    if a < b: 
        parent[b] = a
    else:
        parent[a] = b

V, E = map(int, input().split())
edges = [list(map(int, input().split())) for _ in range(E)]
parent = list(range(V+1))
# 가중치 오름차순으로 정렬
edges.sort(key=lambda x: x[2])

# 크루스칼 알고리즘
def kruskal():
    cost = cnt = 0
    for a, b, c in edges:
        # 사이클이 없을 때만 추가
        if find(a) != find(b):
            union(a, b)
            cost += c
            cnt += 1
            if cnt == V-1:
                break
    
    return cost

print(kruskal())

---
131168 KB,	432 ms	PyPy3
49356 KB, 4308 ms Python3
