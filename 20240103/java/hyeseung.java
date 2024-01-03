class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int length = sequence.length;
        long sum[][] = new long[length][2];
        sum[0][0] = sequence[0]; // [1, -1, 1, -1, ...] 펄스 적용
        sum[0][1] = -sequence[0]; // [-1, 1, -1, 1, ...] 펄스 적용
        answer = Math.max(sum[0][0], sum[0][1]);
        int pulse = -1;
        for (int i = 1; i < length; i++) {
            // 이전 수열 원소의 최댓값에서 더한 것과 최댓값 비교
            sum[i][0] = Math.max(pulse * sequence[i], pulse * sequence[i] + sum[i - 1][0]);
            sum[i][1] = Math.max(-pulse * sequence[i], -pulse * sequence[i] + sum[i - 1][1]);
            answer = Math.max(answer, Math.max(sum[i][0], sum[i][1]));
            pulse = -pulse; // 1, -1 번갈아 나오도록 조절
        }
        return answer;
    }
}
/*
dp 
-> 1 또는 -1로 시작하면서 1과 -1이 번갈아 나오는 수열 2가지로 나누어 dp
테스트 1 〉	통과 (0.12ms, 75.1MB)
테스트 2 〉	통과 (0.10ms, 72.2MB)
테스트 3 〉	통과 (0.12ms, 80.8MB)
테스트 4 〉	통과 (0.12ms, 74.8MB)
테스트 5 〉	통과 (0.10ms, 73.3MB)
테스트 6 〉	통과 (0.12ms, 76.1MB)
테스트 7 〉	통과 (0.13ms, 83.8MB)
테스트 8 〉	통과 (0.27ms, 77.6MB)
테스트 9 〉	통과 (0.40ms, 85.1MB)
테스트 10 〉	통과 (1.20ms, 75.6MB)
테스트 11 〉	통과 (2.15ms, 82.9MB)
테스트 12 〉	통과 (23.07ms, 83.6MB)
테스트 13 〉	통과 (22.56ms, 91.6MB)
테스트 14 〉	통과 (17.25ms, 83.9MB)
테스트 15 〉	통과 (25.61ms, 86.6MB)
테스트 16 〉	통과 (33.31ms, 101MB)
테스트 17 〉	통과 (115.61ms, 126MB)
테스트 18 〉	통과 (61.53ms, 119MB)
테스트 19 〉	통과 (66.91ms, 134MB)
테스트 20 〉	통과 (88.99ms, 120MB)
*/