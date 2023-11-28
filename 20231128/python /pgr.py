# 실패 - 효율성
from collections import deque
from copy import deepcopy

def solution(land):
    answer = 0
    n, m = len(land), len(land[0])
    dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
    for j in range(m):
        newLand = deepcopy(land)
        visited = [[0] * m for _ in range(n)]
        cnt = 0
        for i in range(n):
            if newLand[i][j] and not visited[i][j]:
                q = deque()
                q.append((i, j))
                newLand[i][j] = 0
                visited[i][j] = 1
                cnt += 1
                while q:
                    x, y = q.popleft()
                    for d in range(4):
                        nx, ny = x + dx[d], y + dy[d]
                        if 0 <= nx < n and 0 <= ny < m:
                            if visited[nx][ny]: continue
                            if newLand[nx][ny]:
                                q.append((nx, ny))
                                newLand[nx][ny] = 0
                                visited[nx][ny] = 1
                                cnt += 1
        answer = max(answer, cnt)
    return answer
# 성공
from collections import deque, defaultdict

def solution(land):
    answer = 0
    n, m = len(land), len(land[0])
    dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
    visited = [[0] * m for _ in range(n)]
    idx, oil = 0, defaultdict(int) # 구역별 번호, 구역별 석유량
    # 석유 구역별 석유량 확인
    for j in range(m):
        for i in range(n):
            if land[i][j] and not visited[i][j]:
                q = deque()
                q.append((i, j))
                idx += 1
                oil[idx] = 0
                land[i][j] = idx
                visited[i][j] = 1
                cnt = 1 # 석유량
                while q:
                    x, y = q.popleft()
                    for d in range(4):
                        nx, ny = x + dx[d], y + dy[d]
                        if 0 <= nx < n and 0 <= ny < m:
                            if visited[nx][ny]: continue
                            if land[nx][ny] == 1:
                                q.append((nx, ny))
                                land[nx][ny] = idx
                                visited[nx][ny] = 1
                                cnt += 1
                oil[idx] = cnt
    # 각 열별 최대 석유량 확인
    for j in range(m):
        res, arr = 0, []
        for i in range(n):
            if land[i][j] and land[i][j] not in arr:
                arr.append(land[i][j])
        for a in arr:
            res += oil[a]
        answer = max(answer, res)
    return answer
"""
정확성  테스트
테스트 1 〉	통과 (0.09ms, 10.2MB)
테스트 2 〉	통과 (0.37ms, 10.4MB)
테스트 3 〉	통과 (0.09ms, 10.4MB)
테스트 4 〉	통과 (0.24ms, 10.2MB)
테스트 5 〉	통과 (0.16ms, 10.3MB)
테스트 6 〉	통과 (1.43ms, 10.3MB)
테스트 7 〉	통과 (1.26ms, 10.3MB)
테스트 8 〉	통과 (0.53ms, 10.3MB)
테스트 9 〉	통과 (3.87ms, 10.5MB)
효율성  테스트
테스트 1 〉	통과 (71.14ms, 13.7MB)
테스트 2 〉	통과 (215.14ms, 16.5MB)
테스트 3 〉	통과 (222.24ms, 16.5MB)
테스트 4 〉	통과 (64.25ms, 13.9MB)
테스트 5 〉	통과 (334.02ms, 14MB)
테스트 6 〉	통과 (70.17ms, 13.7MB)
"""
