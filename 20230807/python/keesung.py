import sys
sys.setrecursionlimit(5000)

dx = [1, 0, 0, -1]
dy = [0, -1, 1, 0]
letters = ['d', 'l', 'r', 'u']
def solution(n, m, x, y, r, c, k):
    
            
    
    answer = dfs('', n, m, x, y, r, c, k)
    if type(answer) != str:
        answer = "impossible"
    return answer

def dfs(letter, n, m, x, y, r, c, cnt):
    if cnt == 0 and x == r and y == c:
        return letter
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if nx <= 0 or nx > n or ny <= 0 or ny > m:
            continue
        if abs(r - nx) + abs(c - ny) > cnt:
            continue
        return dfs(letter + letters[i], n, m, nx, ny, r, c, cnt - 1)

print(solution(6, 6, 2, 6, 6, 5, 11))
# 아래쪽이 제일 먼저
# 왼쪽
# 오른쪽
# 위쪽 순서로 체크해야함

# 테스트 29 〉	통과 (9.06ms, 15.2MB)
# 테스트 19 〉	통과 (10.02ms, 15.1MB)

# 문제 풀이
# 문자열을 생각했을 때 사전순 나열하려면 아래, 왼쪽, 오른쪽, 위 순서
# 평소 생각하는 아래와 여기서의 아래는 좌표가 다르므로 주의
# 시간초과 날 수 있으므로 건너 뛰는 조건을 생각할 것
# 건너뛰는 조건은 그래프 밖을 벗어날 경우, 남은 이동거리보다 두 지점의 거리가 멀 경우
# 이동거리가 0이 되면서 도착지점에 도착했을 경우 문자열을 반환
    