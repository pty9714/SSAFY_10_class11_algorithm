
# cube[3][3][3][6] [z][y][x][윗면 아랫면 앞면 뒷면 왼쪽면 오른쪽면]
# U, D은 z 고정 y, x 움직임
# L, R은 x 고정 z, y 움직임
# F, B은 y 고정 z, x 움직임

def rotate_U(direction):
    
    if direction == '-':
        tmp = []
        for j in range(1, -2, -1):
            for i in range(-1, 2):
                tmp.append(cube[-1][i][j][0])
        for i in range(-1, 2):
            for j in range(-1, 2):
                cube[-1][i][j][0] = tmp.pop(0)
        # 윗면은 그대로, 앞 => 오른 => 뒤 => 왼 => 앞
        tmp = []
        # 앞
        for i in range(-1, 2):
            tmp.append(cube[-1][1][i][2])
        new_tmp = []
        # 오른
        for i in range(1, -2, -1):
            new_tmp.append(cube[-1][i][1][5])
            cube[-1][i][1][5] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 뒤
        for i in range(1, -2, -1):
            new_tmp.append(cube[-1][-1][i][3])
            cube[-1][-1][i][3] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 왼
        for i in range(-1, 2):
            new_tmp.append(cube[-1][i][-1][4])
            cube[-1][i][-1][4] = tmp.pop(0)
        tmp = new_tmp
        # 앞
        for i in range(-1, 2):
            cube[-1][1][i][2] = tmp.pop(0)
    else:
        tmp = []
        for j in range(-1, 2):
            for i in range(1, -2, -1):
                tmp.append(cube[-1][i][j][0])
        for i in range(-1, 2):
            for j in range(-1, 2):
                cube[-1][i][j][0] = tmp.pop(0)
        # 윗면은 그대로, 앞 => 왼 => 뒤 => 오른 => 앞
        tmp = []
        # 앞
        for i in range(-1, 2):
            tmp.append(cube[-1][1][i][2])
        new_tmp = []
        # 왼
        for i in range(-1, 2):
            new_tmp.append(cube[-1][i][-1][4])
            cube[-1][i][-1][4] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 뒤
        for i in range(1, -2, -1):
            new_tmp.append(cube[-1][-1][i][3])
            cube[-1][-1][i][3] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 오른
        for i in range(1, -2, -1):
            new_tmp.append(cube[-1][i][1][5])
            cube[-1][i][1][5] = tmp.pop(0)
        tmp = new_tmp
        # 앞
        for i in range(-1, 2):
            cube[-1][1][i][2] = tmp.pop(0)

def rotate_D(direction):
    if direction == '+':
        tmp = []
        for j in range(1, -2, -1):
            for i in range(-1, 2):
                tmp.append(cube[1][i][j][1])
        for i in range(-1, 2):
            for j in range(-1, 2):
                cube[1][i][j][1] = tmp.pop(0)
        # 윗면은 그대로, 앞 => 오른 => 뒤 => 왼 => 앞
        tmp = []
        # 앞
        for i in range(-1, 2):
            tmp.append(cube[1][1][i][2])
        new_tmp = []
        # 오른
        for i in range(1, -2, -1):
            new_tmp.append(cube[1][i][1][5])
            cube[1][i][1][5] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 뒤
        for i in range(1, -2, -1):
            new_tmp.append(cube[1][-1][i][3])
            cube[1][-1][i][3] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 왼
        for i in range(-1, 2):
            new_tmp.append(cube[1][i][-1][4])
            cube[1][i][-1][4] = tmp.pop(0)
        tmp = new_tmp
        # 앞
        for i in range(-1, 2):
            cube[1][1][i][2] = tmp.pop(0)
    else:
        tmp = []
        for j in range(-1, 2):
            for i in range(1, -2, -1):
                tmp.append(cube[1][i][j][1])
        for i in range(-1, 2):
            for j in range(-1, 2):
                cube[1][i][j][1] = tmp.pop(0)
        # 윗면은 그대로, 앞 => 왼 => 뒤 => 오른 => 앞
        tmp = []
        # 앞
        for i in range(-1, 2):
            tmp.append(cube[1][1][i][2])
        new_tmp = []
        # 왼
        for i in range(-1, 2):
            new_tmp.append(cube[1][i][-1][4])
            cube[1][i][-1][4] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 뒤
        for i in range(1, -2, -1):
            new_tmp.append(cube[1][-1][i][3])
            cube[1][-1][i][3] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 오른
        for i in range(1, -2, -1):
            new_tmp.append(cube[1][i][1][5])
            cube[1][i][1][5] = tmp.pop(0)
        tmp = new_tmp
        # 앞
        for i in range(-1, 2):
            cube[1][1][i][2] = tmp.pop(0)
    
def rotate_R(direction):
    if direction == '-':
        tmp = []
        for j in range(-1, 2):
            for i in range(-1, 2):
                tmp.append(cube[j][i][1][5])
        for i in range(1, -2, -1):
            for j in range(-1, 2):
                cube[j][i][1][5] = tmp.pop(0)
        # 앞 -> 밑 -> 뒤 -> 위 -> 앞
        tmp = []
        # 앞
        for i in range(-1, 2):
            tmp.append(cube[i][1][1][2])
        new_tmp = []
        # 밑
        for i in range(1, -2, -1):
            new_tmp.append(cube[1][i][1][1])
            cube[1][i][1][1] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 뒤
        for i in range(1, -2, -1):
            new_tmp.append(cube[i][-1][1][3])
            cube[i][-1][1][3] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 위
        for i in range(-1, 2):
            new_tmp.append(cube[-1][i][1][0])
            cube[-1][i][1][0] = tmp.pop(0)
        tmp = new_tmp
        # 앞
        for i in range(-1, 2):
            cube[i][1][1][2] = tmp.pop(0)
    else:
        tmp = []
        for i in range(1, -2, -1):
            for j in range(-1, 2):
                tmp.append(cube[j][i][1][5])
        for j in range(-1, 2):
            for i in range(-1, 2):
                cube[j][i][1][5] = tmp.pop(0)
        # 앞 -> 위 -> 뒤 -> 밑 -> 앞
        tmp = []
        # 앞
        for i in range(-1, 2):
            tmp.append(cube[i][1][1][2])
        new_tmp = []
        # 위
        for i in range(-1, 2):
            new_tmp.append(cube[-1][i][1][0])
            cube[-1][i][1][0] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 뒤
        for i in range(1, -2, -1):
            new_tmp.append(cube[i][-1][1][3])
            cube[i][-1][1][3] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 밑
        for i in range(1, -2, -1):
            new_tmp.append(cube[1][i][1][1])
            cube[1][i][1][1] = tmp.pop(0)
        tmp = new_tmp
        # 앞
        for i in range(-1, 2):
            cube[i][1][1][2] = tmp.pop(0)
    
def rotate_L(direction):
    if direction == '+':
        tmp = []
        for j in range(-1, 2):
            for i in range(-1, 2):
                tmp.append(cube[j][i][-1][4])
        for i in range(1, -2, -1):
            for j in range(-1, 2):
                cube[j][i][-1][4] = tmp.pop(0)
        # 앞 -> 밑 -> 뒤 -> 위 -> 앞
        tmp = []
        # 앞
        for i in range(-1, 2):
            tmp.append(cube[i][1][-1][2])
        new_tmp = []
        # 밑
        for i in range(1, -2, -1):
            new_tmp.append(cube[1][i][-1][1])
            cube[1][i][-1][1] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 뒤
        for i in range(1, -2, -1):
            new_tmp.append(cube[i][-1][-1][3])
            cube[i][-1][-1][3] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 위
        for i in range(-1, 2):
            new_tmp.append(cube[-1][i][-1][0])
            cube[-1][i][-1][0] = tmp.pop(0)
        tmp = new_tmp
        # 앞
        for i in range(-1, 2):
            cube[i][1][-1][2] = tmp.pop(0)
    else:
        tmp = []
        for i in range(1, -2, -1):
            for j in range(-1, 2):
                tmp.append(cube[j][i][-1][4])
        for j in range(-1, 2):
            for i in range(-1, 2):
                cube[j][i][-1][4] = tmp.pop(0)
        # 앞 -> 위 -> 뒤 -> 밑 -> 앞
        tmp = []
        # 앞
        for i in range(-1, 2):
            tmp.append(cube[i][1][-1][2])
        new_tmp = []
        # 위
        for i in range(-1, 2):
            new_tmp.append(cube[-1][i][-1][0])
            cube[-1][i][-1][0] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 뒤
        for i in range(1, -2, -1):
            new_tmp.append(cube[i][-1][-1][3])
            cube[i][-1][-1][3] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 밑
        for i in range(1, -2, -1):
            new_tmp.append(cube[1][i][-1][1])
            cube[1][i][-1][1] = tmp.pop(0)
        tmp = new_tmp
        # 앞
        for i in range(-1, 2):
            cube[i][1][-1][2] = tmp.pop(0)
    
def rotate_B(direction):
    if direction == '+':
        tmp = []
        for j in range(-1, 2):
            for i in range(-1, 2):
                tmp.append(cube[j][-1][i][3])
        for i in range(-1, 2):
            for j in range(1, -2, -1):
                cube[j][-1][i][3] = tmp.pop(0)
        # 위 -> 왼 -> 아래 -> 오 -> 위
        tmp = []
        # 위
        for i in range(-1, 2):
            tmp.append(cube[-1][-1][i][0])
        new_tmp = []
        # 왼
        for i in range(1, -2, -1):
            new_tmp.append(cube[i][-1][-1][4])
            cube[i][-1][-1][4] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 아래
        for i in range(1, -2, -1):
            new_tmp.append(cube[1][-1][i][1])
            cube[1][-1][i][1] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 오
        for i in range(-1, 2):
            new_tmp.append(cube[i][-1][1][5])
            cube[i][-1][1][5] = tmp.pop(0)
        tmp = new_tmp
        # 위
        for i in range(-1, 2):
            cube[-1][-1][i][0] = tmp.pop(0)
    else:
        tmp = []
        for i in range(-1, 2):
            for j in range(1, -2, -1):
                tmp.append(cube[j][-1][i][3])
        for j in range(-1, 2):
            for i in range(-1, 2):
                cube[j][-1][i][3] = tmp.pop(0)
        # 위 -> 오 -> 아래 -> 왼 -> 위
        tmp = []
        # 위
        for i in range(-1, 2):
            tmp.append(cube[-1][-1][i][0])
        new_tmp = []
        # 오
        for i in range(-1, 2):
            new_tmp.append(cube[i][-1][1][5])
            cube[i][-1][1][5] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 아래
        for i in range(1, -2, -1):
            new_tmp.append(cube[1][-1][i][1])
            cube[1][-1][i][1] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 왼
        for i in range(1, -2, -1):
            new_tmp.append(cube[i][-1][-1][4])
            cube[i][-1][-1][4] = tmp.pop(0)
        tmp = new_tmp
        # 위
        for i in range(-1, 2):
            cube[-1][-1][i][0] = tmp.pop(0)
    
def rotate_F(direction):
    if direction == '+':
        tmp = []
        for i in range(-1, 2):
            for j in range(1, -2, -1):
                tmp.append(cube[j][1][i][2])
        for j in range(-1, 2):
            for i in range(-1, 2):
                cube[j][1][i][2] = tmp.pop(0)
        # 위 -> 오 -> 아래 -> 왼 -> 위
        tmp = []
        # 위
        for i in range(-1, 2):
            tmp.append(cube[-1][1][i][0])
        new_tmp = []
        # 오
        for i in range(-1, 2):
            new_tmp.append(cube[i][1][1][5])
            cube[i][1][1][5] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 아래
        for i in range(1, -2, -1):
            new_tmp.append(cube[1][1][i][1])
            cube[1][1][i][1] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 왼
        for i in range(1, -2, -1):
            new_tmp.append(cube[i][1][-1][4])
            cube[i][1][-1][4] = tmp.pop(0)
            # print(cube[i][1][-1])
        tmp = new_tmp
        # 위
        for i in range(-1, 2):
            cube[-1][1][i][0] = tmp.pop(0)
    else:
        tmp = []
        for j in range(-1, 2):
            for i in range(-1, 2):
                tmp.append(cube[j][1][i][2])
        for i in range(-1, 2):
            for j in range(1, -2, -1):
                cube[j][1][i][2] = tmp.pop(0)
        # 위 -> 왼 -> 아래 -> 오 -> 위
        tmp = []
        # 위
        for i in range(-1, 2):
            tmp.append(cube[-1][1][i][0])
        new_tmp = []
        # 왼
        for i in range(1, -2, -1):
            new_tmp.append(cube[i][1][-1][4])
            cube[i][1][-1][4] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 아래
        for i in range(1, -2, -1):
            new_tmp.append(cube[1][1][i][1])
            cube[1][1][i][1] = tmp.pop(0)
        tmp = new_tmp
        new_tmp = []
        # 오
        for i in range(-1, 2):
            new_tmp.append(cube[i][1][1][5])
            cube[i][1][1][5] = tmp.pop(0)
        tmp = new_tmp
        # 위
        for i in range(-1, 2):
            cube[-1][1][i][0] = tmp.pop(0)
    
def rotate(text, direction):
    if text == 'U':
        rotate_U(direction)
    elif text == 'D':
        rotate_D(direction)
    elif text == 'R':
        rotate_R(direction)
    elif text == 'L':
        rotate_L(direction)
    elif text == 'F':
        rotate_F(direction)
    elif text == 'B':
        rotate_B(direction)

T = int(input())
full_txt = []
for test_case in range(T):
    N = int(input())
    cube = [[[[None] * 6 for _ in range(3)] for _ in range(3)] for _ in range(3)]
    for i in range(3):
        for j in range(3):
            cube[-1][i][j][0] = 'w'
            cube[1][i][j][1] = 'y'
            cube[i][1][j][2] = 'r'
            cube[i][-1][j][3] = 'o'
            cube[i][j][-1][4] = 'g'
            cube[i][j][1][5] = 'b'
    rotations = input().split()
    for rotation in rotations:
        rotate(rotation[0], rotation[1])


    # 윗면
    # print('------위------')
    txt = ''
    for i in range(-1, 2):
        for j in range(-1, 2):
            # print(cube[-1][i][j])
            txt += cube[-1][i][j][0]
        txt += '\n'
    full_txt.append(txt.strip())
    # # 아래
    # print('------밑------')
    # txt = ''
    # for i in range(-1, 2):
    #     for j in range(-1, 2):
    #         txt += cube[1][i][j][1]
    #     txt += '\n'
    # print(txt)
    # # 앞면
    # print('------앞------')
    # txt = ''
    # for i in range(-1, 2):
    #     for j in range(-1, 2):
    #         txt += cube[i][1][j][2]
    #     txt += '\n'
    # print(txt)
    # # 뒤
    # print('------뒤------')
    # txt = ''
    # for i in range(-1, 2):
    #     for j in range(-1, 2):
    #         txt += cube[i][-1][j][3]
    #     txt += '\n'
    # print(txt)
    # #왼쪽
    # print('------왼------')
    # txt = ''
    # for i in range(-1, 2):
    #     for j in range(-1, 2):
    #         txt += cube[i][j][-1][4]
    #     txt += '\n'
    # #오
    # print(txt)
    # print('------오------')
    # txt = ''
    # for i in range(-1, 2):
    #     for j in range(1, -2, -1):
    #         txt += cube[i][j][1][5]
    #     txt += '\n'
    # print(txt)
print('\n'.join(full_txt))