def solution(commands):
    table = [[""] * 51 for _ in range(51)]
    merged = [[(r, c) for c in range(51)] for r in range(51)]
    answer = []
    
    def find(r, c):
        if merged[r][c]==(r,c):
            return (r, c)
        mr, mc = merged[r][c]
        merged[r][c] = find(mr, mc)
        return merged[r][c]

    def union(r1, c1, r2, c2):
        mr1, mc1 = find(r1, c1)
        mr2, mc2 = find(r2, c2)
        if (mr1, mc1) == (mr2, mc2):
            return False
        if table[mr1][mc1] != "":
            for i in range(51):
                for j in range(51):
                    if merged[i][j]==(mr2, mc2):
                        table[i][j] = table[mr1][mc1]
            merged[mr2][mc2] = (mr1, mc1)
        else:
            for i in range(51):
                for j in range(51):
                    if merged[i][j]==(mr1, mc1):
                        table[i][j] = table[mr2][mc2]
            merged[mr1][mc1] = (mr2, mc2)
        return True  
    
    for c in commands:
        command = c.split(" ")
        
        if command[0] == "UPDATE":
            if len(command) == 4:
                r, c, value = command[1:]
                for i in range(51):
                    for j in range(51):
                        if merged[i][j]==(int(r),int(c)):
                            table[i][j] = value
            else:
                value1, value2 = command[1:]
                for i in range(51):
                    for j in range(51):
                        if table[i][j] == value1:
                            table[i][j] = value2
        
        elif command[0] == "MERGE":
            r1, c1, r2, c2 = map(int, command[1:])
            union(r1, c1, r2, c2)
                
        elif command[0] == "UNMERGE":
            r, c = map(int, command[1:])
            value = table[r][c]
            for i in range(51):
                for j in range(51):
                    if merged[i][j] == (r, c):
                        merged[i][j] = (i, j)
                        table[i][j] = ""
            table[r][c] = value
                    
        elif command[0] == "PRINT":
            r, c = map(int, command[1:])
            if table[r][c] == "":
                answer.append("EMPTY")
            else:
                answer.append(table[r][c])
    
    return answer
