N = int(input())
dic = {'U' : 'up', 'D' : 'down', 'F' : 'front', 'B' : 'back', 'L':'left', 'R':'right'}

def rotate(arr):
    ret = [[0] * 3 for _ in range(3)]
    for r in range(3):
        for c in range(3):
            ret[c][2-r] = arr[r][c]
    for r in range(3):
        for c in range(3):
            arr[r][c] = ret[r][c]

def rotate_ccw(arr):
    ret = [[0] * 3 for _ in range(3)]
    for r in range(3):
        for c in range(3):
            ret[2-c][r] = arr[r][c]
    for r in range(3):
        for c in range(3):
            arr[r][c] = ret[r][c]

def rotate_up_ccw():
    temp = front[0]
    front[0] = left[0]
    left[0] = back[0]
    back[0] = right[0]
    right[0] = temp

def rotate_up():
    temp = front[0]
    front[0] = right[0]
    right[0] = back[0]
    back[0] = left[0]
    left[0] = temp

def rotate_down_ccw():
    temp = front[2]
    front[2] = right[2]
    right[2] = back[2]
    back[2] = left[2]
    left[2] = temp    

def rotate_down():
    temp = front[2]
    front[2] = left[2]
    left[2] = back[2]
    back[2] = right[2]
    right[2] = temp

def rotate_left():
    temp = []
    for i in range(3):
        temp.append(back[2-i][2])
    for i in range(3):
        back[i][2] = down[i][2]
    for i in range(3):
        down[2-i][2] = front[i][0]
    for i in range(3):
        front[i][0] = up[i][0]
    for i in range(3):
        up[i][0] = temp[i]

def rotate_left_ccw():
    temp = []
    for i in range(3):
        temp.append(up[2-i][0])
    for i in range(3):
        up[i][0] = front[i][0]
    for i in range(3):
        front[i][0] = down[2-i][2]
    for i in range(3):
        down[i][2] = back[i][2]
    for i in range(3):
        back[i][2] = temp[i]

def rotate_right():
    temp = []
    for i in range(3):
        temp.append(up[2-i][2])
    for i in range(3):
        up[i][2] = front[i][2]
    for i in range(3):
        front[i][2] = down[2-i][0]
    for i in range(3):
        down[i][0] = back[i][0]
    for i in range(3):
        back[i][0] = temp[i]

def rotate_right_ccw():
    temp = []
    for i in range(3):
        temp.append(back[2-i][0])
    for i in range(3):
        back[i][0] = down[i][0]
    for i in range(3):
        down[2-i][0] = front[i][2]
    for i in range(3):
        front[i][2] = up[i][2]
    for i in range(3):
        up[i][2] = temp[i]

def rotate_front():
    temp = []
    for i in range(3):
        temp.append(left[2-i][2])
    for i in range(3):
        left[i][2] = down[2][2-i]
    for i in range(3):
        down[2][i] = right[i][0]
    for i in range(3):
        right[i][0] = up[2][i]

    for i in range(3):
        up[2][i] = temp[i]

def rotate_front_ccw():
    temp = []
    for i in range(3):
        temp.append(up[2][2-i])
    for i in range(3):
        up[2][i] = right[i][0]
    for i in range(3):
        right[i][0] = down[2][i]
    for i in range(3):
        down[2][2-i] = left[i][2]
    for i in range(3):
        left[i][2] = temp[i]

def rotate_back():
    temp = []
    for i in range(3):
        temp.append(up[0][2-i])
    for i in range(3):
        up[0][i] = right[i][2]
    for i in range(3):
        right[i][2] = down[0][i]
    for i in range(3):
        down[0][2-i] = left[i][0]
    for i in range(3):
        left[i][0] = temp[i]

def rotate_back_ccw():
    temp = []
    for i in range(3):
        temp.append(left[2-i][0])
    for i in range(3):
        left[i][0] = down[0][2-i]
    for i in range(3):
        down[0][i] = right[i][2]
    for i in range(3):
        right[i][2] = up[0][i]

    for i in range(3):
        up[0][i] = temp[i]



for i in range(N):
    num = int(input())
    up = [['w' for _ in range(3)] for _ in range(3)]
    down = [['y' for _ in range(3)] for _ in range(3)]
    front = [['r' for _ in range(3)] for _ in range(3)]
    back = [['o' for _ in range(3)] for _ in range(3)]
    left = [['g' for _ in range(3)] for _ in range(3)]
    right = [['b' for _ in range(3)] for _ in range(3)]
    l = list(input().split())
    for j in l:
        if j[0] == 'L':
            if j[1] == '+':
                rotate(left)
                rotate_left()
            else:
                rotate_ccw(left)
                rotate_left_ccw()

        elif j[0] == 'R':
            if j[1] == '+':
                rotate(right)
                rotate_right()
            else:
                rotate_ccw(right)
                rotate_right_ccw()

        elif j[0] == 'U':
            if j[1] == '+':
                rotate(up)
                rotate_up()
            else:
                rotate_ccw(up)
                rotate_up_ccw()

        elif j[0] == 'D':
            if j[1] == '+':
                rotate(down)
                rotate_down()
            else:
                rotate_ccw(down)
                rotate_down_ccw()

        elif j[0] == 'F':
            if j[1] == '+':
                rotate(front)
                rotate_front()
            else:
                rotate_ccw(front)
                rotate_front_ccw()

        elif j[0] == 'B':
            if j[1] == '+':
                rotate(back)
                rotate_back()
            else:
                rotate_ccw(back)
                rotate_back_ccw()        
        
        # print('up')
        # for k in up:
        #     print(k)

        # print('down')
        # for k in down:
        #     print(k)

        # print('right')
        # for k in right:
        #     print(k)
        
        # print('left')
        # for k in left:
        #     print(k)

        # print('front')
        # for k in front:
        #     print(k)
        
        # print('back')
        # for k in back:
        #     print(k)
    for k in range(3):
        for t in range(3):
            print(up[k][t],end='')
        print()
