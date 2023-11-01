from heapq import heappush, heappop
def solution(gems):
    gems_dict = {x : [] for x in gems}
    pointers_dict = {x : 1 for x in gems_dict.keys()}
    for num, gem in enumerate(gems):
        gems_dict[gem].append(num)
    pointers = []
    answer = [1, 1]
    for gem in gems_dict.keys():
        answer[1] = max(answer[1], gems_dict[gem][0] + 1)
        heappush(pointers, gems_dict[gem][0])
    
    arr = [x for x in answer]
    while True:
        pointer = heappop(pointers)
        gem = gems[pointer]
        gem_pointer = pointers_dict[gem]
        if len(gems_dict[gem]) <= gem_pointer:
            break
        pointers_dict[gem] += 1
        heappush(pointers, gems_dict[gem][gem_pointer])
        arr[0] = pointers[0] + 1
        arr[1] = max(arr[1], gems_dict[gem][gem_pointer] + 1)
        if arr[1] - arr[0] < answer[1] - answer[0]:
            answer = [x for x in arr]
    return answer

# 정확성  테스트
# 테스트 1 〉	통과 (0.02ms, 10.2MB)
# 테스트 2 〉	통과 (0.10ms, 10.3MB)
# 테스트 3 〉	통과 (0.32ms, 10.1MB)
# 테스트 4 〉	통과 (0.34ms, 10.2MB)
# 테스트 5 〉	통과 (0.46ms, 10.1MB)
# 테스트 6 〉	통과 (0.01ms, 10.1MB)
# 테스트 7 〉	통과 (0.03ms, 10.2MB)
# 테스트 8 〉	통과 (0.42ms, 10.1MB)
# 테스트 9 〉	통과 (0.91ms, 10.2MB)
# 테스트 10 〉	통과 (0.84ms, 10.4MB)
# 테스트 11 〉	통과 (0.61ms, 10.4MB)
# 테스트 12 〉	통과 (1.57ms, 10.2MB)
# 테스트 13 〉	통과 (2.36ms, 10.4MB)
# 테스트 14 〉	통과 (1.04ms, 10.4MB)
# 테스트 15 〉	통과 (4.44ms, 10.6MB)
# 효율성  테스트
# 테스트 1 〉	통과 (5.40ms, 10.6MB)
# 테스트 2 〉	통과 (7.18ms, 11.3MB)
# 테스트 3 〉	통과 (17.33ms, 11.5MB)
# 테스트 4 〉	통과 (8.41ms, 13MB)
# 테스트 5 〉	통과 (28.53ms, 12.9MB)
# 테스트 6 〉	통과 (35.03ms, 13.2MB)
# 테스트 7 〉	통과 (43.10ms, 13.8MB)
# 테스트 8 〉	통과 (45.22ms, 14.3MB)
# 테스트 9 〉	통과 (53.76ms, 14.9MB)
# 테스트 10 〉	통과 (59.96ms, 15.4MB)
# 테스트 11 〉	통과 (69.70ms, 16.7MB)
# 테스트 12 〉	통과 (28.03ms, 19MB)
# 테스트 13 〉	통과 (53.94ms, 20.1MB)
# 테스트 14 〉	통과 (110.29ms, 19.9MB)
# 테스트 15 〉	통과 (112.55ms, 21.8MB)