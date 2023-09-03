result = set()

def dfs(arr, combination_list):
    global result
    if len(arr) == len(combination_list):
        if len(arr) == len(set(arr)):
            # 세트를 활용해서 중복 없애기
            result.add(tuple(sorted(arr)))
        return
    index = len(arr)
    # print(arr, index)
    for i in combination_list[index]:
        dfs(arr + [i], combination_list)

def solution(user_id, banned_id):
    combination_list = [[] for _ in range(len(banned_id))]
    
    # banned_id 마다 가능한 변수 combination_list에 다 넣어줌
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

# 테스트 1 〉	통과 (0.01ms, 10.2MB)
# 테스트 2 〉	통과 (0.05ms, 10.1MB)
# 테스트 3 〉	통과 (0.07ms, 10.3MB)
# 테스트 4 〉	통과 (0.04ms, 10.1MB)
# 테스트 5 〉	통과 (8936.21ms, 10.3MB)
# 테스트 6 〉	통과 (2.83ms, 10.2MB)
# 테스트 7 〉	통과 (0.03ms, 10.1MB)
# 테스트 8 〉	통과 (0.05ms, 10.2MB)
# 테스트 9 〉	통과 (0.04ms, 10.2MB)
# 테스트 10 〉	통과 (0.03ms, 10.1MB)
# 테스트 11 〉	통과 (0.07ms, 10.3MB)