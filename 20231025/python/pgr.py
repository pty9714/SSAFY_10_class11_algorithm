n = int(input())
arr = list(map(int, input().split()))
if n == 1: print('A')
elif n == 2:
    if arr[0] == arr[1]: print(arr[0])
    else: print('A')
else:
    if arr[0] == arr[1]: a = 0
    else: a = (arr[2] - arr[1]) // (arr[1] - arr[0])
    b = arr[1] - arr[0] * a
    check = True
    for i in range(n-1):
        if arr[i+1] != arr[i] * a + b:
            print('B')
            check = False
            break
    if check: print(int(arr[-1] * a + b))
# arr[1] = arr[0] * a + b
# arr[2] = arr[1] * a + b
# arr[3] = arr[2] * a + b
# 31252	44
