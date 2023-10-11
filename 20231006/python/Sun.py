n,m = map(int,input().split())
l = []
for i in range(n):
    l.append(list(input()))

k = int(input())
answer = []
for i in l:
    cnt = i.count('0') 
    if cnt <=k and cnt%2==k%2:
        a = 0
        for j in l:
            if i==j:
                a+=1
        
        answer.append(a)

if answer:
    print(max(answer))
else:
    print(0)