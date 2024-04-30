import sys
def checkSurprise(T):
    length = len(T)
    if length == 1:
        return True
    else:
        map = dict()
        ## 거리
        for i in range(0, length-2):
            for j in range(0,length-i-1):
                SSANG = T[j] + T[j+i+1]
                if(SSANG in map and map[SSANG] == i):
                    return False
                else:
                    map[SSANG] = i
        return True


            

S = input()

# 파이썬 해시맵 = dict
while(S != "*"):
    if(checkSurprise(S)):
        print(S,"is surprising.")
    else:
        print(S,"is NOT surprising.")
    S = sys.stdin.readline().strip()


