from itertools import combinations


B = sorted([int("".join(cb)) for i in range(1, 11) for cb in combinations([str(i) for i in range(9, -1, -1)], i)])
n = int(input())
print(-1 if n > len(B) else B[n-1])
# 메모리 >> 31256 KB, 시간 >> 44 ms