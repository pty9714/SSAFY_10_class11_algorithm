from collections import defaultdict

def solution(record):
    records = list(map(lambda x : x.split(), record))
    print(records)
    
    change_list = []
    for i in records:
        if i[0] == 'Change':
            change_list.append([i[1], i[2]])

    dt = dict()
    for i in records:
        try:
            dt[i[1]]=i[2]
        except:
            pass

    for i in change_list:
        for key,value in dt.items():
            if key == i[0]:
                dt[key] = i[1]
    
    res = []
    for record in records:
        if record[0] == "Enter":
            res.append(f"{dt[record[1]]}님이 들어왔습니다.")
        elif record[0] == "Leave":
            res.append(f"{dt[record[1]]}님이 나갔습니다.")
        else:
            pass

    return res
