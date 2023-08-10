from itertools import combinations

numbers = [str(i) for i in range(9, -1, -1)]

comb = []
for i in range(1, 11):
    comb.extend(list(combinations(numbers, i)))

comb = sorted([int(''.join(i)) for i in comb])
N = int(input())

if N > len(comb):
    print(-1)
else:
    print(comb[N-1])