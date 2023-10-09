N, K = input().split()
N = list(N)

for i in range(int(K)):
    max_num = max(N[i:])
    max_idx = N.index(max_num)

    if max_idx == i:
        pass
    else:
        temp = N[max_idx]
        N[max_idx] = N[i]
        N[i] = temp

print(''.join(N))
