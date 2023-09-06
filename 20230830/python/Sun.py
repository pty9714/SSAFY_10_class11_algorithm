def solution(sticker):
    if len(sticker) == 1:
        return sticker[0]
    table1 = [0 for _ in range(len(sticker))]
    table1[0] = sticker[0]
    table1[1] = table1[0]
    for i in range(2, len(sticker)-1):
        table1[i] = max(table1[i-1], table1[i-2] + sticker[i])
    value = max(table1)
    
    table1 = [0 for _ in range(len(sticker))]
    table1[0] = 0
    table1[1] = sticker[1]
    for i in range(2, len(sticker)):
        table1[i] = max(table1[i-1], table1[i-2] + sticker[i])
    return max(value, max(table1))

s = [14, 6, 5, 11, 3, 9, 2, 10]