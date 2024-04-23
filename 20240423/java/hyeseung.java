import java.util.Arrays;
class Solution {
    public int[] solution(String s) {
        int n = s.length();
        int[] loc = new int[26];
        int[] answer = new int[n];
        Arrays.fill(loc, -1);
        for (int i = 0; i < n; i++) {
            if(loc[(int) (s.charAt(i) - 'a')] == -1) {
                answer[i] = -1;
            }
            else {
                answer[i] = i - loc[(int) (s.charAt(i) - 'a')];
            }
            loc[(int) (s.charAt(i) - 'a')] = i;
        }
        return answer;
    }
}
/*
테스트 1 〉	통과 (0.02ms, 75.9MB)
테스트 2 〉	통과 (0.03ms, 77.1MB)
테스트 3 〉	통과 (0.03ms, 73.8MB)
테스트 4 〉	통과 (0.18ms, 94MB)
테스트 5 〉	통과 (1.40ms, 77.7MB)
테스트 6 〉	통과 (0.56ms, 78.7MB)
테스트 7 〉	통과 (0.92ms, 90.1MB)
테스트 8 〉	통과 (0.45ms, 79.8MB)
테스트 9 〉	통과 (1.11ms, 83.1MB)
테스트 10 〉	통과 (0.26ms, 76.7MB)
테스트 11 〉	통과 (0.82ms, 77.3MB)
테스트 12 〉	통과 (0.03ms, 75.4MB)
테스트 13 〉	통과 (0.03ms, 79.1MB)
테스트 14 〉	통과 (0.08ms, 73.6MB)
테스트 15 〉	통과 (0.02ms, 73.7MB)
테스트 16 〉	통과 (0.03ms, 75.4MB)
테스트 17 〉	통과 (0.02ms, 78.7MB)
테스트 18 〉	통과 (0.21ms, 75.8MB)
테스트 19 〉	통과 (0.23ms, 79.5MB)
테스트 20 〉	통과 (0.06ms, 73.7MB)
테스트 21 〉	통과 (0.03ms, 76.8MB)
테스트 22 〉	통과 (0.61ms, 78.3MB)
테스트 23 〉	통과 (0.06ms, 74.8MB)
테스트 24 〉	통과 (0.06ms, 76.1MB)
테스트 25 〉	통과 (0.08ms, 73.3MB)
테스트 26 〉	통과 (0.04ms, 77.5MB)
테스트 27 〉	통과 (0.11ms, 72.2MB)
테스트 28 〉	통과 (0.08ms, 77.8MB)
테스트 29 〉	통과 (0.03ms, 77.2MB)
테스트 30 〉	통과 (0.86ms, 79.2MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
 */