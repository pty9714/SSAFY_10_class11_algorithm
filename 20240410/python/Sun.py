n = int(input())
dic = {}
for i in range(n):
    proposition = input()
    A = proposition[0]
    B = proposition[5]
    d = dic.get(A)
    if d:
        d.append(B)
        dic[A] = d
    else:
        dic[A] = [B] 
print(dic)
