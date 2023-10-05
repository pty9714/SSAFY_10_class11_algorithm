graph = [[0 for i in range(100)] for j in range(100)]

# 테두리 시계 방향 회전
def rotate(x1, y1, x2, y2):
    global graph
    
    tmp = graph[x1][y1]
    minVal = tmp
    
    for i in range(y1, y2):
        nxt = graph[x1][i+1]
        minVal = min(minVal, nxt)
        graph[x1][i+1] = tmp
        tmp = nxt
    for i in range(x1, x2):
        nxt = graph[i+1][y2]
        minVal = min(minVal, nxt)
        graph[i+1][y2] = tmp
        tmp = nxt
    for i in range(y2, y1, -1):
        nxt = graph[x2][i-1]
        minVal = min(minVal, nxt)
        graph[x2][i-1] = tmp
        tmp = nxt
    for i in range(x2, x1, -1):
        nxt = graph[i-1][y1]
        minVal = min(minVal, nxt)
        graph[i-1][y1] = tmp
        tmp = nxt
        
    return minVal

def solution(rows, columns, queries):
    global graph
    answer = []
    
    # 초기화
    for i in range(rows):
        for j in range(columns):
            graph[i][j] = i*columns + 1 + j
    
    # 회전 쿼리
    for query in queries:
        x1, y1 = query[0]-1, query[1]-1
        x2, y2 = query[2]-1, query[3]-1
        
        answer.append(rotate(x1,y1,x2,y2))
        
    return answer
