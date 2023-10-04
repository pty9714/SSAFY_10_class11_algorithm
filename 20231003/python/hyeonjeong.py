def solution(record):
    
    users = {}
    for r in record:
        r = r.split()
        if r[0] in ["Enter", "Change"]:
            users[r[1]] = r[2]
            
    result = []
    for r in record:
        r = r.split()
        if r[0]=="Enter":
            result.append(users[r[1]]+"님이 들어왔습니다.")
        elif r[0]=="Leave":
            result.append(users[r[1]]+"님이 나갔습니다.")
            
    return result

# 테스트 29 〉	통과 (103.20ms, 42.5MB)
