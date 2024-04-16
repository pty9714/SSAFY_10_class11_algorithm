import java.util.*;
class Solution {
    class Tangerine implements Comparable<Tangerine> {
        int size;
        int cnt;
        Tangerine(int size, int cnt) {
            this.size = size;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Tangerine tangerine) {
            return tangerine.cnt - this.cnt;
        }
    }
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        PriorityQueue<Tangerine> sort = new PriorityQueue<Tangerine>();
        HashMap<Integer, Integer> tangerines = new HashMap<Integer, Integer>();
        for (int tan : tangerine) {
            tangerines.put(tan, tangerines.getOrDefault(tan, 0) + 1);
        }
        for (int key : tangerines.keySet()) {
            sort.offer(new Tangerine(key, tangerines.get(key)));
        }
        int cnt = 0;
        while(cnt < k) {
            answer++;
            cnt += sort.poll().cnt;
        }
        return answer;
    }
}
/*
테스트 1 〉	통과 (25.69ms, 89.7MB)
테스트 2 〉	통과 (23.62ms, 92MB)
테스트 3 〉	통과 (30.85ms, 96.2MB)
테스트 4 〉	통과 (27.45ms, 97.2MB)
테스트 5 〉	통과 (19.45ms, 90.9MB)
테스트 6 〉	통과 (25.01ms, 89.2MB)
테스트 7 〉	통과 (31.67ms, 84.5MB)
테스트 8 〉	통과 (19.01ms, 85.7MB)
테스트 9 〉	통과 (20.19ms, 87.9MB)
테스트 10 〉	통과 (27.06ms, 86.4MB)
테스트 11 〉	통과 (0.88ms, 77MB)
테스트 12 〉	통과 (0.52ms, 72.2MB)
테스트 13 〉	통과 (0.50ms, 77.8MB)
테스트 14 〉	통과 (0.60ms, 78.5MB)
테스트 15 〉	통과 (0.50ms, 77.8MB)
테스트 16 〉	통과 (1.14ms, 79.1MB)
테스트 17 〉	통과 (0.55ms, 77.2MB)
테스트 18 〉	통과 (0.55ms, 72.1MB)
테스트 19 〉	통과 (0.52ms, 72.5MB)
테스트 20 〉	통과 (0.72ms, 73.9MB)
테스트 21 〉	통과 (1.11ms, 73.8MB)
테스트 22 〉	통과 (2.29ms, 78.3MB)
테스트 23 〉	통과 (1.83ms, 65.6MB)
테스트 24 〉	통과 (2.52ms, 76.2MB)
테스트 25 〉	통과 (14.52ms, 78.4MB)
테스트 26 〉	통과 (15.75ms, 87.4MB)
테스트 27 〉	통과 (75.94ms, 105MB)
테스트 28 〉	통과 (59.81ms, 106MB)
테스트 29 〉	통과 (110.63ms, 96.6MB)
테스트 30 〉	통과 (98.80ms, 105MB)
테스트 31 〉	통과 (28.97ms, 94.3MB)
테스트 32 〉	통과 (27.21ms, 90.1MB)
테스트 33 〉	통과 (67.91ms, 109MB)
테스트 34 〉	통과 (79.57ms, 88.6MB)
 */