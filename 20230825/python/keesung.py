text = input()
bomb = input()

stack = []
for i in text:
    stack.append(i)
    if len(stack) >= len(bomb):
        if ''.join(stack[-len(bomb):]) == bomb:
            for _ in range(len(bomb)):
                stack.pop()
new_text = ''.join(stack)
if new_text == '':
    print("FRULA")
else:
    print(new_text)
    
# 42436kb, 900ms