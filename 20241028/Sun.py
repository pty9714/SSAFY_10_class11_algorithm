import bisect
 
T = int(input()) 
n = int(input())
A = list(map(int,input().split()))
m = int(input()) 
B = list(map(int,input().split()))
 
result = 0
sumA,sumB=A,B 
for i in range(n):
    for j in range(i+1,n):
        sumA.append(sum(A[i:j+1])) 
for i in range(m):
    for j in range(i+1,m):
        sumB.append(sum(B[i:j+1]))
 
sumA.sort()
sumB.sort()

for i in range(len(sumA)):
    l = bisect.bisect_left(sumB, T-sumA[i])
    r = bisect.bisect_right(sumB, T-sumA[i])
    result+=r-l
print(result)