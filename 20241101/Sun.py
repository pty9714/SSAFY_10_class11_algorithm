def f(bit, length):
    if length == 0:
        return True
    elif length == 1:
        return False
    
    A = [((1 << i) & bit) != 0 for i in range(length)]
    P = [0] * (length + 1)
    P[0] = 1
    
    for i in range(1, length):
        if A[i] == A[i - 1]:
            P[i] = P[i - 1] + 1
        else:
            P[i] = 1
    
    ret = False
    i = length - 1
    
    while i > 0:
        if P[i] > 1:
            s = i - P[i] + 1
            e = i
            i -= P[i]
            tmp = 0
            
            for j in range(s):
                if A[j]:
                    tmp += 1 << j
            
            for j in range(e + 1, length):
                if A[j]:
                    tmp += 1 << (j - e + s - 1)
            
            if f(tmp, length - e + s - 1):
                ret = True
            
            if ret:
                break
        else:
            i -= 1
            
    return ret

def main():
    T = int(input())
    for _ in range(T):
        S = input()
        N = len(S)
        bit = 0
        
        for i in range(N):
            if S[i] == 'b':
                bit += 1 << i
        
        print(int(f(bit, N)))

main()