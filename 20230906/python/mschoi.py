T = int(input())
for test_case in range(1, T+1):
    N = int(input())
    ans = set()
    for _ in range(N):
        temp = input()
        ans.add(temp)

    ans = sorted(list(ans), key=lambda x: (len(x), x))
    print("#"+ str(test_case))
    for res in ans:
        print(res)

# 183,892 kb  4,008 ms
