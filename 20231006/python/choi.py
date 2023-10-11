from collections import defaultdict

N, M = map(int, input().split())
rows, counts = defaultdict(int), defaultdict(int)

for i in range(N):
    temp = input()
    count = 0
    for item in temp:
        if item == '0':
            count += 1
    rows[int(temp)] += 1
    counts[int(temp)] = count

K = int(input())
answer = 0
for k, v in counts.items():
    # 0 개수 <= K and 홀짝성 같으면 모두 1로 만들기 가능
    if v <= K and v % 2 == K % 2:
        answer = max(answer, rows[k])

print(answer)

# 34036kb	68ms
