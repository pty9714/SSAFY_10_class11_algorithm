# 시간초과 실패

def solution(gems):
    # 보석의 종류를 담은 딕셔너리 (개수 카운트용)
    gem_dict = {gem: 0 for gem in set(gems)}
    # 종류가 하나면 리턴
    if len(gem_dict) == 1:
        return [1, 1]
    # 인덱스 맞추기 위해 앞에 '' 추가
    gems.insert(0, '')
    
    # 시작, 끝 포인터 선언
    start, end = 1, 0
    # 모든 종류를 선택했을 때, 선택한 보석의 개수
    min_cnt = len(gems)
    # 정답
    answer = []
    
    while True:
        # 범위 안에서 모든 종류의 보석이 포함될 때까지 end+1
        while not all(gem_dict.values()) and end+1 < len(gems):
            end += 1
            gem_dict[gems[end]] += 1
        # 만약 모든 종류의 보석이 포함되지 않았는데 범위를 벗어나면 break
        if not all(gem_dict.values()):
            break

        # 모든 종류의 보석이 포함된 상태에서 start+1
        while all(gem_dict.values()) and start < end:
            # 최소 개수의 보석보다 적으면 answer 업데이트
            if min_cnt > sum(gem_dict.values()):
                # 다 하나씩 있으면 최소 개수이기 때문에 바로 return
                if sum(gem_dict.values()) == len(gem_dict):
                    return [start, end]
                min_cnt = sum(gem_dict.values())
                answer = [start, end]
            gem_dict[gems[start]] -= 1
            start += 1
    
    return answer
