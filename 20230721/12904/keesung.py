from collections import deque

S = input()
T = input()

words = [T, T[::-1]]

q = deque()
q.append(S)

result = 0
while q:
    tmp = q.popleft()
    if tmp == T:
        result = 1
        break
    if tmp in words[0]:
        q.append(tmp + 'A')
    if tmp in words[1]:
        q.append(tmp + 'B')
    
print(result)
        
        