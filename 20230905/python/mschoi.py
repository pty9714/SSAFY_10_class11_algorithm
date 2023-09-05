saveAll = [[] for _ in range(9)]

def appendList(N, cnt):
    global saveAll
    temp, res = set(), 0
    for idx in range(1, cnt//2+1):
        for item1 in saveAll[idx]:
            for item2 in saveAll[cnt-idx]:
                temp.add(item1+item2)
                temp.add(item1-item2)
                temp.add((-1)*(item1-item2))
                temp.add(item1*item2)
                if item1 != 0 and item2 != 0:
                    temp.add(item1//item2)
                    temp.add(item2//item1)
    
    for i in range(cnt-1, -1, -1):
        res += (10**i)*N
    temp.add(res)
    saveAll[cnt] = temp


def solution(N, number):
    global saveAll
    if number == N:
        return 1
    
    saveAll[1] = [N]
    for k in range(2, 9):
        appendList(N, k)
        if number in saveAll[k]:
            return k
    return -1

# 테스트 5 〉	통과 (15.86ms, 10.8MB)
