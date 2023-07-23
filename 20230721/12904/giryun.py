s = list(input())
t = list(input())
answer = 0
while t:
    if t[-1] == 'A':
        t.pop()
    elif t[-1] == 'B':
        t.pop()
        t = t[::-1]
    if t == s:
        answer = 1
        break
print(answer)