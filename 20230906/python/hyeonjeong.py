T = int(input())
for tc in range(1, T+1):
    N = int(input())
    names = []
    for i in range(N):
        names.push(input())
    names.sort(key=lambda x: (len(x), x))
    print("#"+tc)
    for name in set(names):
        print(name)
