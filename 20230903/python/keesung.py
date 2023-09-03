result = set()

def dfs(arr, combination_list):
    global result
    if len(arr) == len(combination_list):
        if len(arr) == len(set(arr)):
            result.add(tuple(sorted(arr)))
        return
    index = len(arr)
    # print(arr, index)
    for i in combination_list[index]:
        dfs(arr + [i], combination_list)

def solution(user_id, banned_id):
    combination_list = [[] for _ in range(len(banned_id))]
    
    for index, ban_id in enumerate(banned_id):
        for user in user_id:
            signal = True
            if len(user) != len(ban_id):
                continue
            for num, txt in enumerate(user):
                if ban_id[num] == '*':
                    continue
                else:
                    if ban_id[num] != txt:
                        signal = False
                        break
            if signal:
                combination_list[index].append(user)
    # print(combination_list)
    dfs([], combination_list)
    
    answer = len(result)
        
    return answer

# print(solution(["frodo", "fradi", "crodo", "abc123", "frodoc"], ["fr*d*", "abc1**"]))
# print(solution(["frodo", "fradi", "crodo", "abc123", "frodoc"], ["*rodo", "*rodo", "******"]))