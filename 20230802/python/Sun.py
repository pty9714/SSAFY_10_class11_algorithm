import heapq
tc = int(input())



for TC in range(1,tc+1):
    n,m = map(int,input().split())

    Map = [[] for _ in range(n)]
    for _ in range(m):
        s,e,c = map(int,input().split())
        Map[s].append((e, c))

    # 아직안품~