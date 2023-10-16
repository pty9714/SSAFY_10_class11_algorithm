import heapq


def solution(n, start, end, roads, traps):
    edge = [[] for _ in range(n + 1)]
    mask_idx = {t : n for n, t in enumerate(traps)}
    traps = tuple(traps)

    for road in roads:
        a, b, d = road
        edge[a].append((b, d))
        edge[b].append((a, -d))

    # bfs
    heap = [(0, start, 0)]
    dist = {}
    while heap:
        d, idx, mask = heapq.heappop(heap)
        if dist.get((idx, mask), None):
            continue

        dist[(idx, mask)] = d
        if idx == end:
            answer = d
            print('break')
            break;

        direction = 1
        if idx in traps and (mask & (1 << mask_idx[idx])):
            direction *= -1

        for near_idx, near_d in edge[idx]:
            if near_idx in traps and (mask & (1 << mask_idx[near_idx])):
                near_d *= -1

            if near_d * direction > 0:
                new_mask = mask
                if near_idx in traps:
                    if mask & (1 << mask_idx[near_idx]):
                        new_mask = mask & ~(1 << mask_idx[near_idx])
                    else:
                        new_mask = mask | (1 << mask_idx[near_idx]) 

                heapq.heappush(heap, (d + near_d * direction, near_idx, new_mask))


    return answer
  
"""
정확성  테스트
테스트 1 〉	통과 (0.02ms, 10.3MB)
테스트 2 〉	통과 (0.02ms, 10.5MB)
테스트 3 〉	통과 (0.03ms, 10.5MB)
테스트 4 〉	통과 (0.04ms, 10.3MB)
테스트 5 〉	통과 (1.94ms, 10.5MB)
테스트 6 〉	통과 (0.18ms, 10.4MB)
테스트 7 〉	통과 (0.12ms, 10.3MB)
테스트 8 〉	통과 (3.69ms, 10.5MB)
테스트 9 〉	통과 (1.08ms, 10.3MB)
테스트 10 〉	통과 (0.67ms, 10.5MB)
테스트 11 〉	통과 (5.35ms, 11.2MB)
테스트 12 〉	통과 (2.63ms, 11.2MB)
테스트 13 〉	통과 (4.75ms, 11.2MB)
테스트 14 〉	통과 (2.32ms, 11.3MB)
테스트 15 〉	통과 (9.76ms, 11.6MB)
테스트 16 〉	통과 (5.36ms, 11.2MB)
테스트 17 〉	통과 (3.29ms, 11.3MB)
테스트 18 〉	통과 (3.81ms, 11.2MB)
테스트 19 〉	통과 (7.89ms, 11.3MB)
테스트 20 〉	통과 (3.00ms, 11.2MB)
테스트 21 〉	통과 (4.98ms, 11.2MB)
테스트 22 〉	통과 (8.81ms, 11.7MB)
테스트 23 〉	통과 (11.28ms, 11.5MB)
테스트 24 〉	통과 (5.66ms, 11.3MB)
테스트 25 〉	통과 (7.79ms, 11.4MB)
테스트 26 〉	통과 (40.93ms, 12.3MB)
테스트 27 〉	통과 (11.35ms, 11.5MB)
"""
