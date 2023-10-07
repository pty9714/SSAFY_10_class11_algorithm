n, m = map(int, input().split())
table = [list(map(int, input())) for _ in range(n)]
k = int(input())

ans = 0
# 모든 행에 대하여
for i in range(n):
    zero = table[i].count(0)
    # 이 행과 똑같은 0의 개수를 가진 행의 개수 세기
    cnt = 0
    # 0의 개수가 k 이하이고, 0의 개수의 짝홀이 k와 같다면 스위치를 모두 킬 수 있다.
    if zero <= k and zero % 2 == k % 2:
        # 다시 한 번 확인해서
        for j in range(n):
            # 같은 경우에만 + 1
            if table[j] == table[i]: cnt += 1
    ans = max(ans, cnt)
print(ans)

# 메모리 31256 KB, 시간 44 ms
