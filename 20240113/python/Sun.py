def solution(friends, gifts):
    f = len(friends)
    answer = [0 for _ in range(f)]
    graph = [[0 for _ in range(f)] for _ in range(f)]
    dic = {}
    for i in friends:
        dic[i] = 0
    for t in gifts:
        a,b = t.split()
        dic[a] +=1
        dic[b] -=1
        graph[friends.index(a)][friends.index(b)] +=1


    for i in range(f):
        for j in range(f):
            if i==j:
                continue
            if graph[i][j] > graph[j][i]:
                answer[i] +=1
            elif graph[i][j] == graph[j][i]:
                if dic[friends[i]] > dic[friends[j]]:
                    answer[i] +=1
    print(dic)
    print(graph)                
    print(answer)
    return max(answer)

F = ["muzi", "ryan", "frodo", "neo"]
G = ["muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"]
print(solution(F,G))

# 테스트 14 〉	통과 (18.33ms, 10.6MB)