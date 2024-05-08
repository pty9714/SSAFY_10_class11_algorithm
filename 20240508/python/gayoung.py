n,d,k,c = map(int, input().split())
plate = []
for i in range(n):
    plate.append(int(input()))

answer = 0

for i in range(n):
    tmp = set()
    tmp.add(c)
    if i+k >= n:
        tmp.update(plate[i:] + plate[:i+k-n])
    else :
        tmp.update(plate[i:i+k])
    answer = max(answer, len(tmp))
print(answer)