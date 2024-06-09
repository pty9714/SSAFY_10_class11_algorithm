n = int(input())
l = [0]*26
for i in range(n):
    k = input()
    t = len(k)
    for j in range(t):
        l[ord(k[j])-ord('A')] += 10**(t-1-j)

l.sort(reverse=True)
q = 9
answer = 0
for i in range(9):
    answer += l[i]*(q-i)

print(answer)