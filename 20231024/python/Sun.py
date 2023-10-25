def cal(a):
    if a < 100:
        return a * 2
    if a < 10000:
        return 100 * 2 + (a - 100) * 3
    if a < 1000000:
        return 100 * 2 + 9900 * 3 + (a - 10000) * 5
    return 100 * 2 + 9900 * 3 + 990000 * 5 + (a - 1000000) * 7


while True:
    n, m = map(int, input().split())
    if n == 0 and m == 0:
        break

    if n <= 200:
        sum_elec = n // 2
    elif 200 < n <= 29900:
        sum_elec = 100 + (n - 200) // 3
    elif 29900 < n <= 4979900:
        sum_elec = (n - 29900) // 5 + 10000
    else:
        sum_elec = (n - 4979900) // 7 + 1000000

    start = 1
    end = sum_elec
    while True:
        b = (start + end) // 2
        a = sum_elec - b

        if cal(a) - cal(b) == m:
            print(cal(b))
            break
        elif cal(a) - cal(b) > m:
            start = b + 1
        else:
            end = b - 1
