n,h = map(int,input().split())
l = []
for _ in range(n):
    l.append(int(input()))
g = [[0 for _ in range(n)] for _ in range(h)]

for i in range(n):
    if i%2 == 0:
        for j in range(l[i]):
            g[h-1-j][i] = 1 
    else:
        for j in range(l[i]):
            g[j][i] = 1

answer = []
for i in range(h):
    answer.append(sum(g[i]))
print(min(answer),answer.count(min(answer)))

# 배열을 0 1 로 채우고 가로로 짤르기
# 메모리 초과