import sys
N = int(input())
input = sys.stdin.readline
arr = []
dict_A ={}
for i in range(N):
    w = input().strip()
    arr.append(w)
    for j in range(len(w)):
        if w[j] in dict_A:
            dict_A[w[j]] += 10**(len(w)-j-1)
        else:
            dict_A[w[j]] = 10**(len(w)-j-1)

#item기준 내림차순 정렬
sort_A = sorted(dict_A.items(), key = lambda x: x[1], reverse = True)
max_num = 9
print(sort_A)
for w in sort_A:
   dict_A[w[0]] = max_num
   max_num -= 1


#arr -> 숫자 변환
answer = 0
print(dict_A)
for i in arr:
    for j in range(len(i)):
        answer += (10**(len(i)-j-1))*dict_A[i[j]]
        
print(answer) 

