def solution(rows, columns, queries):
    l = [[i+j*columns+1 for i in range(columns)] for j in range(rows)]
    # for i in range(rows):
    #     print(l[i])
    # print()
    answer = []
    for y1,x1,y2,x2 in queries:
        a = []
        check = l[y1-1][x1-1]
        for i in range(y1-1,y2-1):
            l[i][x1-1]=l[i+1][x1-1]
            a.append(l[i][x1-1])
        for i in range(x1-1,x2-1):
            l[y2-1][i] = l[y2-1][i+1]
            a.append(l[y2-1][i])
        for i in range(y2-1,y1-1,-1):
            l[i][x2-1]=l[i-1][x2-1]
            a.append(l[i][x2-1])
        for i in range(x2-1,x1-1,-1):
            l[y1-1][i]=l[y1-1][i-1]
            a.append(l[y1-1][i])
        l[y1-1][x1] = check   
        a.append(check)        

        answer.append(min(a))


    # for i in range(rows):
    #     print(l[i])
    
    
    return answer




r = 6
c = 6
q = [[2,2,5,4],[3,3,6,6],[5,1,6,3]]
print(solution(r,c,q))

# 테스트 1 〉	통과 (0.03ms, 10.3MB)
# 테스트 2 〉	통과 (0.02ms, 10.2MB)
# 테스트 3 〉	통과 (198.37ms, 11.7MB)
# 테스트 4 〉	통과 (111.96ms, 11.2MB)
# 테스트 5 〉	통과 (183.16ms, 11.4MB)
# 테스트 6 〉	통과 (172.59ms, 11.8MB)
# 테스트 7 〉	통과 (231.00ms, 12.2MB)
# 테스트 8 〉	통과 (112.10ms, 11.3MB)
# 테스트 9 〉	통과 (166.82ms, 11.6MB)
# 테스트 10 〉	통과 (125.22ms, 11.4MB)
# 테스트 11 〉	통과 (121.56ms, 11.5MB)