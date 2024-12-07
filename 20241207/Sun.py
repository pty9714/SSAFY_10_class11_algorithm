n = int(input())
l = []

def bt(k):
    for i in range(1,(k//2)+1):
        if l[-i:] == l[-(2*i):-i]:
            return False
    if k == n:
        for i in l:
            print(i, end='')
        print()
        return True
    
    for i in range(1,4):
        l.append(i)
        if bt(k+1):
            return True
        l.pop()

bt(0)