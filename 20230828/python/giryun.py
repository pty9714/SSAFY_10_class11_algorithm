import sys
input = sys.stdin.readline


for t in range(1, int(input())+1):
    n, v = map(int, input().split())
    if n == 1:
        print(f"#{t} 0")
    elif n == 2:
        print(f"#{t} 1")
    else:
        isBalanced = 0
        a = n
        # 왼쪽이 더 깊은지 판단
        while a > 1:
            if a == 3: isBalanced = 1
            a //= 2
        ans = 0
        startRight = 0
        b = v
        # 시작 정점이 왼쪽에 있는지 오른쪽에 있는지 파악
        while b > 1:
            if b == 3: startRight = 1
            b //= 2
            ans += 1
        # 최대 깊이까지 탐색
        while b < n:
            b *= 2
            if b <= n: ans += 1
        # 만약 왼쪽에서 오른쪽으로 가는데 왼쪽으로 편향된 경우 -1
        if not isBalanced and not startRight and v != 1: ans -= 1
        print(f"#{t} {ans}")
# 시간초과        
"""
# 11 7
         1
    2         3
 4    5     6    7
8 9 10 11 
"""
