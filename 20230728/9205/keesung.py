import sys
input = sys.stdin.readline
t = int(input())

def visit(x, y, visited):
    global fest
    
    for conv in graph[(x,y)]:
        if conv not in visited:
            if abs(x - conv[0]) + abs(y - conv[1]) <= 1000:
                visited.add(conv)
                # print(conv, fest)
                if conv == fest:
                    # print(555555555)
                    global result
                    result = 1
                    return
                visit(conv[0], conv[1], visited)
                visited.remove(conv)

for _ in range(t):
    n = int(input())
    home = tuple(map(int, input().split()))
    convs = [tuple(map(int, input().split())) for _ in range(n)]
    fest = tuple(map(int, input().split()))
    convs.append(fest)
    convs.append(home)
    graph = {
        x : [conv for conv in convs if 0 < abs(x[0] - conv[0]) + abs(x[1] - conv[1]) <= 1000] for x in convs
    }
    result = 0
    
    visit(home[0], home[1], {home})
    # print("=========")
    # print(result)
    # print("=========")
    if result != 1:
        print("sad")
    else:
        print("happy")