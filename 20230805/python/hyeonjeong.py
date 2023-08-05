n = int(input())
# seats: 자리 배치
seats = [[0 for j in range(n)] for i in range(n)]

dirX = [0, 1, 0, -1]
dirY = [1, 0, -1, 0]

students = []
friends = []

for _ in range(n**2):
    info = list(map(int, input().split()))
    # student: 학생 번호
    student = info[0]
    # friends: 좋아하는 학생 번호
    friends.append(info[1:])
    # likes: 각 자리 계산
    likes = dict()
    for i in range(n):
        for j in range(n):
            # 이미 자리 있으면 패스
            if seats[i][j] != 0:
                continue
            like_cnt = 0
            empty_cnt = 0
            # 상하좌우 돌면서 좋아하는 학생 수랑 비어있는 칸 수 세기
            for k in range(4):
                x = i+dirX[k]
                y = j+dirY[k]
                if x < 0 or x >= n or y < 0 or y >= n:
                    continue
                if seats[x][y] in friends[-1]:
                    like_cnt += 1
                elif seats[x][y] == 0:
                    empty_cnt += 1
            # 비어있는 좌석만 저장
            likes[(i, j)] = [like_cnt, empty_cnt]

    # 좋아하는 학생 수, 그리고 비어있는 칸이 가장 많은 칸 순서대로 정렬 (같을땐 행과 열은 자동으로 작은 순)
    likes = sorted(likes.items(), key=lambda kv: (kv[1][0], kv[1][1]), reverse=True)
    [r, c] = likes[0][0]
    seats[r][c] = student
    # students: 정해진 좌석 저장
    students.append([r, c])

answer = 0
for i in range(n**2):
    satisfy = 0
    [X, Y] = students[i]
    for k in range(4):
        x = X + dirX[k]
        y = Y + dirY[k]
        if x < 0 or x >= n or y < 0 or y >= n:
            continue
        if seats[x][y] in friends[i]:
            satisfy += 1
    answer += 0 if satisfy == 0 else 10**(satisfy-1)

print(answer)

# 31256kb 308ms
