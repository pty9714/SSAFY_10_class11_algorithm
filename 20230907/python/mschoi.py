parent = [[(r, c) for c in range(51)] for r in range(51)]
cells = [['EMPTY']*51 for _ in range(51)]
result = []

def find(r, c) :
    if (r, c) == parent[r][c] :
        return parent[r][c]
    pr, pc = parent[r][c]
    parent[r][c] = find(pr, pc)
    return parent[r][c]

def union(r1, c1, r2, c2) :
    parent[r2][c2] = parent[r1][c1]

def UPDATE(r, c, msg) :
    pr, pc = find(r, c) 
    cells[pr][pc] = msg

def UPDATE_VAL(msg1, msg2):
    for r in range(51) :
        for c in range(51) :
            pr, pc = find(r, c)
            if cells[pr][pc] == msg1 :
                cells[pr][pc] = msg2
    
def MERGE(r1, c1, r2, c2) :
    r1, c1 = find(r1, c1)
    r2, c2 = find(r2, c2)
    
    if (r1, c1) == (r2, c2) :
        return
    if cells[r1][c1] != "EMPTY" :
        union(r1, c1, r2, c2)
    else :
        union(r2, c2, r1, c1)

def UNMERGE(r, c):
    pr, pc = find(r, c)
    msg = cells[pr][pc]
      
    merge_list = list()
    for ar in range(51) :
        for ac in range(51) :
            apr, apc = find(ar, ac)
            if (apr, apc) == (pr, pc) :
                merge_list.append((ar, ac))
                
    for ar, ac in merge_list :
        parent[ar][ac] = (ar, ac)
        cells[ar][ac] = "EMPTY" if (ar, ac) != (r, c) else msg
    
def PRINT(r, c) :
    pr, pc = find(r, c)
    result.append(cells[pr][pc])
        
def solution(commands):
    for command in commands :
        cmd, *arg = command.split()
        if cmd == "UPDATE" :
            if len(arg) == 3 :
                r, c, value = arg
                UPDATE(int(r), int(c), value)
            else :
                value1, value2 = arg
                UPDATE_VAL(value1, value2)
        elif cmd == "MERGE" :
            r1, c1, r2, c2 = map(int, arg)
            MERGE(r1, c1, r2, c2)
        elif cmd == "UNMERGE" :
            r, c = map(int, arg)
            UNMERGE(r, c)
        else :
            r, c = map(int, arg)
            PRINT(r, c)
            
    return result

###
테스트 1 〉	통과 (1.38ms, 10.5MB)
테스트 2 〉	통과 (1.38ms, 10.6MB)
테스트 3 〉	통과 (0.04ms, 10.6MB)
테스트 4 〉	통과 (0.05ms, 10.5MB)
테스트 5 〉	통과 (1.45ms, 10.6MB)
테스트 6 〉	통과 (0.10ms, 10.6MB)
테스트 7 〉	통과 (2.06ms, 10.6MB)
테스트 8 〉	통과 (2.00ms, 10.5MB)
테스트 9 〉	통과 (3.98ms, 10.4MB)
테스트 10 〉	통과 (7.32ms, 10.5MB)
테스트 11 〉	통과 (20.03ms, 10.6MB)
테스트 12 〉	통과 (27.83ms, 10.6MB)
테스트 13 〉	통과 (68.04ms, 10.7MB)
테스트 14 〉	통과 (75.06ms, 10.7MB)
테스트 15 〉	통과 (49.51ms, 10.7MB)
테스트 16 〉	통과 (47.45ms, 10.8MB)
테스트 17 〉	통과 (84.79ms, 10.8MB)
테스트 18 〉	통과 (86.11ms, 10.6MB)
테스트 19 〉	통과 (218.40ms, 10.6MB)
테스트 20 〉	통과 (3.75ms, 10.6MB)
테스트 21 〉	통과 (2.05ms, 10.7MB)
테스트 22 〉	통과 (131.69ms, 10.5MB)
