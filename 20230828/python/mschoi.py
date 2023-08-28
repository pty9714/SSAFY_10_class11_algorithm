import math

T = int(input())
for test_case in range(1, T + 1):
    N, V = map(int, input().split())

    # 루트 노드라면 가장 최대 깊이 반환
    if V == 1:
        answer = int(math.log2(N))
        if N == 1:
            answer = 0
    else: # 루트 노드가 아니라면
        # 루트 노드까지 올라가서 최대한 깊이 내려가기
        answer = math.floor(math.log2(V))
        if V % 2 == 0: # 짝수라면 왼쪽에서 올라왔다
            if N >= 3:
                answer += 1
                answer += math.floor(math.log2(N/3))
        else: # 홀수라면 오른쪽에서 올라왔다
            answer += math.floor(math.log2(N))
    print("#" + str(test_case) + " " + str(answer))

# 시간초과
처음 테케 : 실행 시간 0.14292s
