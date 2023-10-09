from collections import deque

def bfs(n, k):
    q = deque()
    q.append((n, 0))
    visited = set()
    visited.add((n, 0))
    answer = 0
    while q:
        x, cnt = q.popleft()
        if cnt == k:
            answer = max(answer, x)
            continue
        x = list(str(x))
        for i in range(m-1):
            for j in range(i+1, m):
                if i == 0 and x[j] == '0': continue
                x[i], x[j] = x[j], x[i]
                nx = int(''.join(x))
                if (nx, cnt+1) in visited: continue
                q.append((nx, cnt+1))
                visited.add((nx, cnt+1))
                x[i], x[j] = x[j], x[i]
    return answer if answer else -1

n, k = map(int, input().split())
m = len(str(n))
print(bfs(n, k))

# 34176KB, 88ms
