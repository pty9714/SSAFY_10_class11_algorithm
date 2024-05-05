import sys;


str = ""
dict = dict()
for _ in range(3):
    str += "".join(list(input().split()))
    
dx = [ 1,0,-1,0]
dy = [ 0,1,0,-1]
depth = 0
dict[str] = 0

def bfs(str,depth):
    print("문자",str,"깊이",depth)
    
    if dict.get("123456780", 0) != 0:
        return
    
    temp = str.index('0')
    x = int(temp/3)
    y = temp%3
    for i in range(4):
        mx = x + dx[i]
        my = y + dy[i]
        if(mx >= 0 and mx < 3 and my >= 0 and my < 3):
            change = mx*3 + my
            puzzle_list = list(str) 
            puzzle_list[temp], puzzle_list[change] = puzzle_list[change ], puzzle_list[temp]
            new_puzzle = "".join(puzzle_list) 
            if dict.get(new_puzzle, 0) == 0:
                dict[new_puzzle] = depth + 1 
                bfs(new_puzzle, depth + 1)
bfs(str,depth)



