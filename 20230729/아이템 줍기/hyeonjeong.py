def check_border(rectangle, x, y):
    border = True
    for r in rectangle:
        if r[0] < x < r[2] and r[1] < y < r[3]:
            border = False
            break
    return border

def solution(rectangle, characterX, characterY, itemX, itemY):
    
    # 사각형 테두리 저장
    rectangles = set()
    for r in rectangle:
        start_x, start_y, end_x, end_y = r
        for i in range(start_x, end_x+1):
            if check_border(rectangle, i, start_y):
                rectangles.add((i, start_y))
            if check_border(rectangle, i, end_y):
                rectangles.add((i, end_y))
        for j in range(start_y, end_y+1):
            if check_border(rectangle, start_x, j):
                rectangles.add((start_x, j))
            if check_border(rectangle, end_x, j):
                rectangles.add((end_x, j))
    
    # 방향 정하기
    directionX = []
    directionY = []
    if characterX < itemX:
        directionX = [1, 0, -1, 0]
    else:
        directionX = [-1, 0, 1, 0]
    if characterY < itemY:
        directionY = [0, 1, 0, -1]
    else:
        directionY = [0, -1, 0, 1]    
    
    # 움직이기
    result = 0
    while characterX != itemX or characterY != itemY:
        for i in range(4):
            if (directionX[i], directionY[i]) in rectangles:
                characterX += directionX[i]
                characterY += directionY[i]
                result += 1
                break
    
    return result
