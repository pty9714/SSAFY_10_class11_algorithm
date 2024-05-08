import sys;

input = sys.stdin.readline

N,L = map(int,input().split())

arr = []

min_start = 1000000000
max_end = 0
for _ in range(N):
    a,b = map(int,input().split())
    arr.append([a,b])
    if a < min_start:
        min_start = a
    if b > max_end:
        max_end = b 

brook = [0] * (max_end - min_start + 1)

for i in range(N):
    for i in range(arr[i][0],arr[i][1]+1):
        brook[i-min_start] = 1

count = 0 
answer = 0 
for i in range(len(brook)):
    if brook[i] == 1:
        count = count + 1
    if count > 0 and brook[i] == 0 :
        count = count + 1
    if count == (L+1):
        count = 0
        answer = answer + 1
    if i==len(brook)-1 and count > 0 and count != (L+1):
        answer = answer + 1

print(answer)
