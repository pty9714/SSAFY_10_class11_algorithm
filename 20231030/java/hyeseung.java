import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> hs = new HashSet<>();
        HashMap<String, Integer> hm = new HashMap<>();
        // 보석의 종류 개수 세기
        for(String gem : gems) {
            hs.add(gem);  
        }
        int n = hs.size();
        // 투포인터
        int temp = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < gems.length; i++) { // 오른쪽 이동
            hm.put(gems[i], hm.getOrDefault(gems[i], 0) + 1); // map에 삽입
            while(hm.size() == n) { // 가장 짧은 구간 찾기 위해 n일 때까지 왼쪽 이동
                // 진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간의 경우 update
                if(i - temp < min) { 
                    min = i - temp;
                    answer[0] = temp + 1;
                    answer[1] = i + 1;
                }
                hm.put(gems[temp], hm.get(gems[temp]) - 1);
                if(hm.get(gems[temp]) == 0) { // 0이면 제거
                    hm.remove(gems[temp]);
                }
                temp++;
            }
        }
        return answer;
    }
}
/*
정확성  테스트
테스트 1 〉	통과 (0.11ms, 72.2MB)
테스트 2 〉	통과 (0.20ms, 77.8MB)
테스트 3 〉	통과 (0.42ms, 75.2MB)
테스트 4 〉	통과 (0.48ms, 78.1MB)
테스트 5 〉	통과 (0.93ms, 77.4MB)
테스트 6 〉	통과 (0.06ms, 74.2MB)
테스트 7 〉	통과 (0.12ms, 70.3MB)
테스트 8 〉	통과 (0.59ms, 83.6MB)
테스트 9 〉	통과 (1.04ms, 73MB)
테스트 10 〉	통과 (0.91ms, 75.5MB)
테스트 11 〉	통과 (0.97ms, 76.6MB)
테스트 12 〉	통과 (1.02ms, 82.4MB)
테스트 13 〉	통과 (1.45ms, 82.4MB)
테스트 14 〉	통과 (1.80ms, 74.2MB)
테스트 15 〉	통과 (3.86ms, 80.3MB)
효율성  테스트
테스트 1 〉	통과 (6.18ms, 54.4MB)
테스트 2 〉	통과 (8.30ms, 57.7MB)
테스트 3 〉	통과 (12.01ms, 58.8MB)
테스트 4 〉	통과 (12.48ms, 59.6MB)
테스트 5 〉	통과 (19.97ms, 62.1MB)
테스트 6 〉	통과 (23.34ms, 63.9MB)
테스트 7 〉	통과 (31.90ms, 64.7MB)
테스트 8 〉	통과 (33.29ms, 69.9MB)
테스트 9 〉	통과 (37.81ms, 71.3MB)
테스트 10 〉	통과 (32.90ms, 75.4MB)
테스트 11 〉	통과 (54.01ms, 79.5MB)
테스트 12 〉	통과 (31.81ms, 79.5MB)
테스트 13 〉	통과 (33.25ms, 84.9MB)
테스트 14 〉	통과 (44.10ms, 81.3MB)
테스트 15 〉	통과 (53.74ms, 81.9MB)
채점 결과
정확성: 33.3
효율성: 66.7
합계: 100.0 / 100.0
*/