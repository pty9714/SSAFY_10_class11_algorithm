T = int(input())
            
for test_case in range(1, T+1):
    
    N, M = map(int, input().strip().split())
    graph = [[0] * (N+1) for _ in range(N+1)]
    for i in range(M):
        s, e, c = map(int, input().strip().split())
        graph[s][e] = c
    

    for i in range(1, N+1):
        for j in range(1, N+1):
            if graph[i][j] != 0:
                for l in range(1, N+1):
                    if graph[j][l] != 0:
                        if graph[i][l] == 0:
                            graph[i][l] = graph[i][j] + graph[j][l]
                        else:
                            graph[i][l] = min(graph[i][l], graph[i][j] + graph[j][l])
    # print(graph)

    result = 10e9
    for k in range(1, N+1):
        if graph[k][k] != 0:
            result = min(result, graph[k][k])
    if result == 10e9:
        result = -1
        
        
    print('#{} {}'.format(test_case, result))