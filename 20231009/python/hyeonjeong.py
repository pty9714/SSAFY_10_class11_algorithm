# 실패
N, K = input().split()
N = [int(num) for num in list(N)]
result = -1

# 한 자리 수일 때 -1 출력
if len(N) > 1:
    i = 0
    flag = True

    duplicate = False
    cnt = {}
    for num in N:
        if num in cnt:
            cnt[num] += 1
            duplicate = True
        else:
            cnt[num] = 1

    for turn in range(int(K), 0, -1):

        # 만약 i 자리에 있는 숫자가 가장 크다면 i+1(뒤에서 -1까지) 하고 위 단계 반복
        while i < len(N) - 2 and max(N[i:]) == N[i]:
            i += 1

        # 다 정렬되어 있고 같은 숫자 있으면 pass 하기
        if i == len(N)-2 and N[i] >= N[-1]:
            if duplicate or turn % 2 == 0:
                flag = True
                break

        # 끝부터 i+1까지 중 가장 큰 숫자를 찾아서 i 자리와 바꾸기
        # 같은 숫자가 여러 개 있으면 가장 뒷 순서와 바꾸기
        max_idx = len(N) - 1
        for j in range(len(N) - 2, i, -1):
            if N[j] > N[max_idx]:
                max_idx = j

        # 이 과정에서 맨 앞에 0가 오면 -1 출력
        if i == N[max_idx] == 0:
            flag = False
            break

        temp = N[max_idx]
        N[max_idx] = N[i]
        N[i] = temp

    if flag:
        result = "".join([str(num) for num in N])

print(result)
