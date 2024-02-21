n, m = map(int, input().split())
truth = set(list(map(int, input().split()))[1:])
parties = [set(list(map(int, input().split()))[1:]) for _ in range(m)]

while True:
    cnt = len(truth)
    for party in parties:
        if party & truth:
            truth = truth.union(party)
    if len(truth) == cnt:
        break
    
answer = m
for party in parties:
    if party & truth:
        answer -= 1
print(answer)
