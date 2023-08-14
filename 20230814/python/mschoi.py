parenthesis = input()
allParenthesis = ["(", "[" , ")", "]"]
openParenthesis, closeParenthesis = ["(", "["], [")", "]"]
stack = []

# 올바른 괄호열 여부 체크 + 값 연산
def computeValue():
    global stack

    for item in parenthesis:
        if item in openParenthesis:
            stack.append(item)
        elif item in closeParenthesis:
            # 스택에서 가장 위에 있는 같은 쌍 괄호 찾기
            temp, res = 0, 0
            while True:
                if len(stack) <= 0:
                    return False
                found = stack.pop()
                if found in allParenthesis:
                    idx = openParenthesis.index(found)
                    if openParenthesis.index(found) == closeParenthesis.index(item):
                        if idx == 0:  # ()
                            res = 2
                        else:  # []
                            res = 3
                        break
                    else:
                        return False
                else:
                    temp += found
            if temp == 0:
                stack.append(res)
            else:
                stack.append(temp*res)
    return True

if computeValue():
    isDone = False
    for item in stack:
        if item in allParenthesis:
            print(0)
            isDone = True
            break
    if not isDone:
        print(sum(stack))
else:
    print(0)

# 31256 KB	44 ms
