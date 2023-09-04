
# cube[3][3][3][6] [z][y][x][윗면 아랫면 앞면 뒷면 왼쪽면 오른쪽면]
# U, D은 z 고정 y, x 움직임
# L, R은 x 고정 z, y 움직임
# F, B은 y 고정 z, x 움직임

def rotate_U(direction):
    if direction == '-':
        # 윗면은 그대로, 앞 => 오른 => 뒤 => 왼 => 앞
        tmp = []
        # 앞
        for i in range(-1, 2):
            tmp.append(cube[-1][1][i][2])
        new_tmp = []
        # 오른
        for i in range(-1, 2):
            new_tmp.append(cube[-1][i][1][5])
            cube[-1][i][1][5] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 뒤
        for i in range(-1, 2):
            new_tmp.append(cube[-1][-1][i][3])
            cube[-1][-1][i][3] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 왼
        for i in range(-1, 2):
            new_tmp.append(cube[-1][i][-1][4])
            cube[-1][i][-1][4] = tmp[i+1]
        tmp = new_tmp
        # 앞
        for i in range(-1, 2):
            cube[-1][1][i][2] = tmp[i+1]
    else:
        # 윗면은 그대로, 앞 => 왼 => 뒤 => 오른 => 앞
        tmp = []
        # 앞
        for i in range(-1, 2):
            tmp.append(cube[-1][1][i][2])
        new_tmp = []
        # 왼
        for i in range(-1, 2):
            new_tmp.append(cube[-1][i][-1][4])
            cube[-1][i][-1][4] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 뒤
        for i in range(-1, 2):
            new_tmp.append(cube[-1][-1][i][3])
            cube[-1][-1][i][3] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 오른
        for i in range(-1, 2):
            new_tmp.append(cube[-1][i][1][5])
            cube[-1][i][1][5] = tmp[i+1]
        tmp = new_tmp
        # 앞
        for i in range(-1, 2):
            cube[-1][1][i][2] = tmp[i+1]

def rotate_D(direction):
    if direction == '+':
        # 윗면은 그대로, 앞 => 오른 => 뒤 => 왼 => 앞
        tmp = []
        # 앞
        for i in range(-1, 2):
            tmp.append(cube[1][1][i][2])
        new_tmp = []
        # 오른
        for i in range(-1, 2):
            new_tmp.append(cube[1][i][1][5])
            cube[1][i][1][5] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 뒤
        for i in range(-1, 2):
            new_tmp.append(cube[1][-1][i][3])
            cube[1][-1][i][3] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 왼
        for i in range(-1, 2):
            new_tmp.append(cube[1][i][-1][4])
            cube[1][i][-1][4] = tmp[i+1]
        tmp = new_tmp
        # 앞
        for i in range(-1, 2):
            cube[1][1][i][2] = tmp[i+1]
    else:
        # 윗면은 그대로, 앞 => 왼 => 뒤 => 오른 => 앞
        tmp = []
        # 앞
        for i in range(-1, 2):
            tmp.append(cube[1][1][i][2])
        new_tmp = []
        # 왼
        for i in range(-1, 2):
            new_tmp.append(cube[1][i][-1][4])
            cube[-1][i][-1][4] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 뒤
        for i in range(-1, 2):
            new_tmp.append(cube[1][-1][i][3])
            cube[1][-1][i][3] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 오른
        for i in range(-1, 2):
            new_tmp.append(cube[1][i][1][5])
            cube[1][i][1][5] = tmp[i+1]
        tmp = new_tmp
        # 앞
        for i in range(-1, 2):
            cube[1][1][i][2] = tmp[i+1]
    
def rotate_R(direction):
    if direction == '-':
        # 앞 -> 밑 -> 뒤 -> 위 -> 앞
        tmp = []
        # 앞
        for i in range(-1, 2):
            tmp.append(cube[i][1][1][2])
        new_tmp = []
        # 밑
        for i in range(-1, 2):
            new_tmp.append(cube[1][i][1][1])
            cube[1][i][1][1] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 뒤
        for i in range(-1, 2):
            new_tmp.append(cube[i][-1][1][3])
            cube[i][-1][1][3] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 위
        for i in range(-1, 2):
            new_tmp.append(cube[-1][i][1][0])
            cube[-1][i][1][0] = tmp[i+1]
        tmp = new_tmp
        # 앞
        for i in range(-1, 2):
            cube[i][1][1][2] = tmp[i+1]
    else:
        # 앞 -> 위 -> 뒤 -> 밑 -> 앞
        tmp = []
        # 앞
        for i in range(-1, 2):
            tmp.append(cube[i][1][1][2])
        new_tmp = []
        # 위
        for i in range(-1, 2):
            new_tmp.append(cube[-1][i][1][0])
            cube[-1][i][1][0] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 뒤
        for i in range(-1, 2):
            new_tmp.append(cube[i][-1][1][3])
            cube[i][-1][1][3] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 밑
        for i in range(-1, 2):
            new_tmp.append(cube[1][i][1][1])
            cube[1][i][1][1] = tmp[i+1]
        tmp = new_tmp
        # 앞
        for i in range(-1, 2):
            cube[i][1][1][2] = tmp[i+1]
    
def rotate_L(direction):
    if direction == '+':
        # 앞 -> 밑 -> 뒤 -> 위 -> 앞
        tmp = []
        # 앞
        for i in range(-1, 2):
            tmp.append(cube[i][1][-1][2])
        new_tmp = []
        # 밑
        for i in range(-1, 2):
            new_tmp.append(cube[1][i][-1][1])
            cube[1][i][-1][1] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 뒤
        for i in range(-1, 2):
            new_tmp.append(cube[i][-1][-1][3])
            cube[i][-1][-1][3] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 위
        for i in range(-1, 2):
            new_tmp.append(cube[-1][i][-1][0])
            cube[-1][i][-1][0] = tmp[i+1]
        tmp = new_tmp
        # 앞
        for i in range(-1, 2):
            cube[i][1][-1][2] = tmp[i+1]
    else:
        # 앞 -> 위 -> 뒤 -> 밑 -> 앞
        tmp = []
        # 앞
        for i in range(-1, 2):
            tmp.append(cube[i][1][-1][2])
        new_tmp = []
        # 위
        for i in range(-1, 2):
            new_tmp.append(cube[-1][i][-1][0])
            cube[-1][i][-1][0] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 뒤
        for i in range(-1, 2):
            new_tmp.append(cube[i][-1][-1][3])
            cube[i][-1][-1][3] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 밑
        for i in range(-1, 2):
            new_tmp.append(cube[1][i][-1][1])
            cube[1][i][-1][1] = tmp[i+1]
        tmp = new_tmp
        # 앞
        for i in range(-1, 2):
            cube[i][1][-1][2] = tmp[i+1]
    
def rotate_B(direction):
    if direction == '+':
        # 위 -> 왼 -> 아래 -> 오 -> 위
        tmp = []
        # 위
        for i in range(-1, 2):
            tmp.append(cube[-1][-1][i][0])
        new_tmp = []
        # 왼
        for i in range(-1, 2):
            new_tmp.append(cube[i][-1][-1][4])
            cube[i][-1][-1][4] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 아래
        for i in range(-1, 2):
            new_tmp.append(cube[1][-1][i][1])
            cube[1][-1][i][1] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 오
        for i in range(-1, 2):
            new_tmp.append(cube[i][-1][1][5])
            cube[i][-1][1][5] = tmp[i+1]
        tmp = new_tmp
        # 위
        for i in range(-1, 2):
            cube[-1][-1][i][0] = tmp[i+1]
    else:
        # 위 -> 오 -> 아래 -> 왼 -> 위
        tmp = []
        # 위
        for i in range(-1, 2):
            tmp.append(cube[-1][-1][i][0])
        new_tmp = []
        # 오
        for i in range(-1, 2):
            new_tmp.append(cube[i][-1][1][5])
            cube[i][-1][1][5] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 아래
        for i in range(-1, 2):
            new_tmp.append(cube[1][-1][i][1])
            cube[1][-1][i][1] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 왼
        for i in range(-1, 2):
            new_tmp.append(cube[i][-1][-1][4])
            cube[i][-1][-1][4] = tmp[i+1]
        tmp = new_tmp
        # 위
        for i in range(-1, 2):
            cube[-1][-1][i][0] = tmp[i+1]
    
def rotate_F(direction):
    if direction == '+':
        # 위 -> 오 -> 아래 -> 왼 -> 위
        tmp = []
        # 위
        for i in range(-1, 2):
            tmp.append(cube[-1][1][i][0])
        new_tmp = []
        # 오
        for i in range(-1, 2):
            new_tmp.append(cube[i][1][1][5])
            cube[i][1][1][5] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 아래
        for i in range(-1, 2):
            new_tmp.append(cube[1][1][i][1])
            cube[1][1][i][1] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 왼
        for i in range(-1, 2):
            new_tmp.append(cube[i][1][-1][4])
            cube[i][1][-1][4] = tmp[i+1]
        tmp = new_tmp
        # 위
        for i in range(-1, 2):
            cube[-1][1][i][0] = tmp[i+1]
    else:
        # 위 -> 왼 -> 아래 -> 오 -> 위
        tmp = []
        # 위
        for i in range(-1, 2):
            tmp.append(cube[-1][1][i][0])
        new_tmp = []
        # 왼
        for i in range(-1, 2):
            new_tmp.append(cube[i][-1][1][4])
            cube[i][-1][1][4] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 아래
        for i in range(-1, 2):
            new_tmp.append(cube[1][1][i][1])
            cube[1][1][i][1] = tmp[i+1]
        tmp = new_tmp
        new_tmp = []
        # 오
        for i in range(-1, 2):
            new_tmp.append(cube[i][1][1][5])
            cube[i][1][1][5] = tmp[i+1]
        tmp = new_tmp
        # 위
        for i in range(-1, 2):
            cube[-1][1][i][0] = tmp[i+1]
    
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


        
    txt = ''
    for i in range(-1, 2):
        for j in range(-1, 2):
            txt += cube[-1][i][j][0]
        txt += '\n'
    # txt = ''
    # for i in range(-1, 2):
    #     for j in range(-1, 2):
    #         txt += cube[i][1][j][2]
    #     txt += '\n'
    print(txt)