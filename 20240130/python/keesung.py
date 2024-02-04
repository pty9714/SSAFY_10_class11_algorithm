from itertools import combinations

N, M = map(int, input().split())
words = [set(map(str,input())) for _ in range(N)]
need = set(['a', 'c', 'i', 't', 'n'])
words = [x.difference(need) for x in words]
alpha = words[0]
for word in words[1:]:
    alpha = alpha.union(word)

result = 0

if M >= 5:
    alpha = set(combinations(alpha, M - 5))
    if len(alpha) == 0:
        result = N
    else:
        for comb in alpha:
            tmp = 0
            for word in words:
                isContain = True
                for w in word:
                    if w not in comb:
                        isContain = False
                        break
                if isContain == True:
                    tmp += 1
            result = max(result, tmp)
print(result)