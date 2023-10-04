from collections import defaultdict

def solution(record):
    answer = []
    users = defaultdict()
    cmds = [] # "Enter", "Leave", "Change"
    
    for item in record:
        info = item.split() # action uid [nickname]
        action, userid = info[0], info[1]
        if action in ("Enter", "Change"):
            nickname = info[2]
            users[userid] = nickname
        cmds.append((action, userid))
        
    for actionInfo in cmds:
        action, userid = actionInfo[0], actionInfo[1]
        if action == 'Enter':
            answer.append(f'{users[userid]}님이 들어왔습니다.')
        elif action == 'Leave':
            answer.append(f'{users[userid]}님이 나갔습니다.')
    
    return answer
