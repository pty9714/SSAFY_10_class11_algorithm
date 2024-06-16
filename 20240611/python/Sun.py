n = int(input())
l = [0]
for i in range(n):
    t = int(input())
    l.append(t)

answer = set([])

stack = []
for i in range(1,n+1):
    set_list = set([])
    set_result = set([])

    stack.append(i)
    while stack:
        k = stack.pop()
        set_list.add(k)
        set_result.add(l[k])
        if l[k] not in set_list:
            stack.append(l[k])

    if set_list == set_result:
        answer.update(set_list)        

a = list(answer)
a.sort()
print(len(a))
for i in a:
    print(i)