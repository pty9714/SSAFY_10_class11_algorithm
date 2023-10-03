from bisect import bisect_left, bisect_right
from itertools import product

N = int(input())
M = int(input())
if M == 0:
    buttons = [str(x) for x in range(10)]
else:
    buttons = list(map(int, input().split()))
    buttons = [str(x) for x in range(10) if x not in buttons]

if M == 10:
    print(abs(N - 100))
elif 98 <= N <= 103:
    print(abs(100 - N))
else:
    numbers = list(product(buttons, repeat = len(str(N))))
    if buttons[0] == '0' and len(buttons) > 1:
        numbers += [buttons[1] + '0' * len(str(N))]
    else:
        numbers += [buttons[0] * (len(str(N)) + 1)]
    if len(str(N)) > 1:
        numbers += [buttons[-1] * (len(str(N)) - 1)]
    numbers = [''.join(x) for x in numbers]
    numbers = [abs(N - int(x)) + len(x) for x in numbers]
    print(min(abs(N - 100), min(numbers)))