arr = input()
stack = []  # 올바른 괄호열 체크할 스택
temp = 1
answer = 0

for i in range(len(arr)):
    # 열 때마다 곱해주고, 여는 괄호 넣어주기
    if arr[i] == "(":
        temp *= 2
        stack.append(arr[i])
    elif arr[i] == "[":
        temp *= 3
        stack.append(arr[i])
    elif arr[i] == ")":
        # 여는 괄호 없는 경우: ()), 다른 괄호와 겹칠 경우: [) -> 실패
        if not stack or stack[-1] == "[":
            answer = 0
            break
        # () 인 경우: 지금까지 누적해서 계산한 temp를 answer에 더해준다
        if arr[i - 1] == "(":
            answer += temp
        # 닫을 때마다 나눠주고, 여는 괄호 빼주기
        temp //= 2
        stack.pop()
    else:
        if not stack or stack[-1] == "(":
            answer = 0
            break
        if arr[i - 1] == "[":
            answer += temp
        temp //= 3
        stack.pop()

if stack:  # 닫는 괄호 없는 경우: (() -> 실패
    print(0)
else:
    print(answer)

# 31256kb	44ms
