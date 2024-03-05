n = int(input())
l = list(map(int,input().split()))
start = 0
end = n-1
temp = l[start]+l[end]
x,y = l[start],l[end]
while True:
    if abs(l[start] + l[end]) < abs(x+y):
        x,y = l[start],l[end]
    temp = l[start] + l[end]    
    if temp > 0:
        end -= 1
    else:
        start +=1
    if start == end or temp == 0 :
        break

print(x,y)
        