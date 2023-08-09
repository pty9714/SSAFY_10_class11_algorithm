dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

n = int(input())
arr = [[0]*n for _ in range(n)]
students = [list(map(int, input().split())) for _ in range(n**2)]

# 학생 수 만큼 for문을 돌며 자리에 앉힘
for order in range(n**2):
    student = students[order]
    # 가능한 자리를 모두 담아서 정렬
    tmp = []
    for i in range(n):
        for j in range(n):
            if arr[i][j] == 0:
                like = 0
                blank = 0
                for k in range(4):
                    nr, nc = i + dr[k], j + dc[k]
                    if 0 <= nr < n and 0 <= nc < n:
                        if arr[nr][nc] in student[1:]:
                            like += 1
                        if arr[nr][nc] == 0:
                            blank += 1
                tmp.append([like, blank, i, j])
    tmp.sort(key= lambda x:(-x[0], -x[1], x[2], x[3]))
    # 정렬 후 젤 앞에 있는 리스트의 행과 열의 번호에 학생 앉히기
    arr[tmp[0][2]][tmp[0][3]] = student[0]

result = 0
students.sort()

for i in range(n):
    for j in range(n):
        ans = 0
        for k in range(4):
            nr, nc = i + dr[k], j + dc[k]
            if 0 <= nr < n and 0 <= nc < n:
                if arr[nr][nc] in students[arr[i][j]-1]:
                    ans += 1
        if ans != 0:
            result += 10 ** (ans-1)
print(result)
