correct = input()


mapping = {
    ')': ['(', 2],
    ']': ['[', 3],
}
stack = []
result = 0
for txt in correct:
    # print(stack)
    number = 0
    if stack == []:
        stack.append(txt)
    else:
        if txt in mapping:
            find_text = mapping[txt][0]

            while len(stack) > 0 and type(stack[-1]) == int:
                stack_text = stack.pop()
                number += stack_text
            if len(stack) == 0:
                result = 0
                break
            if stack[-1] == find_text:
                stack.pop()
                if number == 0:
                    number = mapping[txt][1]
                else:
                    number *= mapping[txt][1]
                stack.append(number)
                    
        else:
            stack.append(txt)

for i in stack:
    if type(i) == int:
        result += i
    else:
        result = 0
        break
print(result)

# 31256KB, 44 ms python3
# 괄호 stack에 넣었다가 빼는 방식으로 풀이
# 가운데에 괄호가 만들어져서 숫자가 되는 경우를 생각하고, 숫자가 되면 스택에 다시 넣어주는 방식으로 풀이
# 숫자가 연속이면 숫자를 더해줌