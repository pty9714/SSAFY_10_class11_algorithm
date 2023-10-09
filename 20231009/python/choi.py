N, K = input().split()
N, K = list(N), int(K)
cnt = 0

for idx in range(len(N)):
    if cnt >= K:
        break
    # 가장 큰 숫자 역순 탐색
    maxNum = max(N[idx:])
    if maxNum == '0':
        N = [-1]
        break
    maxIdx = len(N) - 1 - N[::-1].index(maxNum)

    if idx == len(N)-1: # 끝 도달
        while cnt < K:
            temp = N[len(N)-1]
            N[len(N)-1] = N[len(N)-2]
            N[len(N)-2] = temp
            cnt += 1

    if maxIdx == idx: # 이미 가장 큰 수
        continue
    else:
        temp = N[maxIdx]
        N[maxIdx] = N[idx]
        N[idx] = temp
        cnt += 1

if cnt < K or len(N) == 1:
    print(-1)
else:
    print(''.join(N))

# 미완성
