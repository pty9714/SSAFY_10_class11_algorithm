def solution(m, n, puddles):
    NUM = 1000000007
    graph = [[0 for _ in range(m+2)] for _ in range(n+2)] # 패딩
    for px, py in puddles:
        graph[py][px] = -1
    graph[1][1] = 1 # 집
    graph[n][m] = 0 # 학교

    for ridx in range(1, n+1):
        for cidx in range(1, m+1):
            if ridx == 1 and cidx == 1: # 집은 패스
                continue
            if graph[ridx][cidx] != -1: # 웅덩이가 아니면 진행
                if graph[ridx-1][cidx] == -1 and graph[ridx][cidx-1] == -1: # 양쪽 모두 웅덩이인 경우
                    graph[ridx][cidx] = 0
                elif graph[ridx-1][cidx] == -1: # 윗 칸이 웅덩이인 경우
                    graph[ridx][cidx] = graph[ridx][cidx-1] % NUM
                elif graph[ridx][cidx-1] == -1: # 왼쪽 칸이 웅덩이인 경우
                    graph[ridx][cidx] = graph[ridx-1][cidx] % NUM
                else: # 정상적인 경우
                    graph[ridx][cidx] = (graph[ridx-1][cidx] + graph[ridx][cidx-1]) % NUM

    return graph[n][m] % NUM

정확성  테스트
테스트 1 〉	통과 (0.02ms, 10.1MB)
테스트 2 〉	통과 (0.02ms, 10.4MB)
테스트 3 〉	통과 (0.04ms, 10.2MB)
테스트 4 〉	통과 (0.08ms, 10.4MB)
테스트 5 〉	통과 (0.09ms, 10.2MB)
테스트 6 〉	통과 (0.06ms, 10.1MB)
테스트 7 〉	통과 (0.12ms, 10.3MB)
테스트 8 〉	통과 (0.22ms, 10.3MB)
테스트 9 〉	통과 (0.07ms, 10.2MB)
테스트 10 〉	통과 (0.06ms, 10.3MB)
효율성  테스트
테스트 1 〉	통과 (3.81ms, 10.3MB)
테스트 2 〉	통과 (1.61ms, 10.3MB)
테스트 3 〉	통과 (2.10ms, 10.2MB)
테스트 4 〉	통과 (3.13ms, 10.2MB)
테스트 5 〉	통과 (2.23ms, 10.3MB)
테스트 6 〉	통과 (3.93ms, 10.4MB)
테스트 7 〉	통과 (1.71ms, 10.2MB)
테스트 8 〉	통과 (2.85ms, 10.3MB)
테스트 9 〉	통과 (3.04ms, 10.3MB)
테스트 10 〉	통과 (2.64ms, 10.2MB)
