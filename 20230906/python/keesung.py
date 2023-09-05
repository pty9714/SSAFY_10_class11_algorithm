T = int(input())

for test_case in range(1, T+1):
    N = int(input())
    names = list(set([input() for _ in range(N)]))
    names.sort()
    names.sort(key = lambda x: len(x))
    print(f'#{test_case}')
    for name in names:
        print(name)
        
# 142,512kb 2,975ms