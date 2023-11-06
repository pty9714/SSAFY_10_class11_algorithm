equation = list(input())
ops = {'+': 0, '-': 0, '*': 1, '/': 1, '(': 2, ')': 2}

answer = []
stk = []
for e in equation:
    # 문자일 때
    if e not in ops:
        answer.append(e)
    # 괄호의 끝일 때
    elif e == ')':
        while stk[-1] != '(':
            answer.append(stk.pop())
        stk.pop()
    else:
        # 이전 연산자가 우선순위 더 높을 때
        while stk and ops[stk[-1]] >= ops[e] and stk[-1] != '(':
            answer.append(stk.pop())
        stk.append(e)

while stk:
    answer.append(stk.pop())

print(''.join(answer))

# 	31120 KB	40 ms
