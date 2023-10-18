def solution(info, query):
    
    primary_key = {}
    lans = {
        'cpp' : set(),
        'java' : set(),
        'python' : set()
    }
    poses = {
        'backend' : set(),
        'frontend' : set(),
    }
    levels = {
        'junior' : set(),
        'senior' : set()
    }
    foods = {
        'chicken' : set(),
        'pizza' : set()
    }
    scores = []
    indexes = [lans, poses, levels, foods, scores]
    for i in range(len(info)):
        lan, pos, level, food, score = info[i].split()
        score = int(score)
        lans[lan].add(i)
        poses[pos].add(i)
        levels[level].add(i)
        foods[food].add(i)
        scores.append(score)
    
    answer = []
    for text in query:
        tmp_answer = 0
        lan, pos, level, food = text.split(" and ")
        food, score = food.split()
        score = int(score)
        result = set()
        signal = False
        for num, check in enumerate([lan, pos, level, food]):
            if check == '-':
                continue
            if signal:
                check_set = indexes[num][check]
                result = result.intersection(check_set)
            else:
                signal = True
                result = indexes[num][check]
        if signal:
            for num in result:
                if scores[num] >= score:
                    tmp_answer += 1
        else:
            count = [x for x in scores if x >= score]
            tmp_answer = len(count)
        answer.append(tmp_answer)
            
            
        
    
    return answer


# 정확성  테스트
# 테스트 1 〉	통과 (0.08ms, 10.4MB)
# 테스트 2 〉	통과 (0.08ms, 10.4MB)
# 테스트 3 〉	통과 (0.36ms, 10.4MB)
# 테스트 4 〉	통과 (2.37ms, 10.4MB)
# 테스트 5 〉	통과 (3.85ms, 10.4MB)
# 테스트 6 〉	통과 (8.05ms, 10.5MB)
# 테스트 7 〉	통과 (6.59ms, 10.6MB)
# 테스트 8 〉	통과 (19.24ms, 12.1MB)
# 테스트 9 〉	통과 (19.80ms, 12.3MB)
# 테스트 10 〉	통과 (30.59ms, 12.3MB)
# 테스트 11 〉	통과 (6.82ms, 10.5MB)
# 테스트 12 〉	통과 (8.17ms, 10.5MB)
# 테스트 13 〉	통과 (8.39ms, 10.5MB)
# 테스트 14 〉	통과 (17.96ms, 11.2MB)
# 테스트 15 〉	통과 (17.19ms, 11.4MB)
# 테스트 16 〉	통과 (6.20ms, 10.3MB)
# 테스트 17 〉	통과 (10.43ms, 10.4MB)
# 테스트 18 〉	통과 (16.14ms, 11.2MB)
# 효율성  테스트
# 테스트 1 〉	실패 (시간 초과)
# 테스트 2 〉	실패 (시간 초과)
# 테스트 3 〉	실패 (시간 초과)
# 테스트 4 〉	실패 (시간 초과)