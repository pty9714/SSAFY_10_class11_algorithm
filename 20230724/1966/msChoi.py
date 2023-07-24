from collections import deque

T = int(input())
for test_case in range(1, T + 1):
    # 입력
    num, targetIdx = map(int, input().split())
    priority = deque()

    temp = map(int, input().split())
    for idx, item in enumerate(temp):
        if targetIdx == idx:
            priority.append([item, True])
        else:
            priority.append([item, False])

    # 조건에 맞는 로직 작성
    answer = 1
    while priority:
        val, target = priority.popleft()
        isMax = True
        for el in priority:
            if val < el[0]:
                isMax = False
                break
        if isMax:
            if target:
                print(answer)
                break
            else:
                answer += 1
        else:
            priority.append([val, target])
