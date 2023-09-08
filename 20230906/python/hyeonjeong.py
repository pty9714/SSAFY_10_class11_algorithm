T = int(input())
for tc in range(1, T+1):
    N = int(input())
    names = set()
    for i in range(N):
        names.add(input())
    names = sorted(names, key=lambda x: (len(x), x))
    print("#"+str(tc))
    for name in names:
        print(name)
