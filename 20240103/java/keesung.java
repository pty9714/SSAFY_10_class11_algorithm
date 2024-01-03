
public class Solution {

    public long solution(int[] sequence) {
        long answer = 0;

        long[] dp = new long[sequence.length + 1];
        dp[0] = 0;
        dp[1] = sequence[0];
        for (int i = 2; i <= sequence.length; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i - 1] - sequence[i - 1];
            } else {
                dp[i] = dp[i - 1] + sequence[i - 1];
            }
        }

        long max = -1000000;
        long min = 1000000;
        for (int i = 0; i <= sequence.length; i++) {
            max = Math.max(max, dp[i]);
            min = Math.min(min, dp[i]);
        }

        answer = Math.abs(max - min);

        return answer;
    }

}

// 누적합
// 처음에 이중포문으로 돌렸는데, 50만 * 50만이라서 시간초과남
// 이중포문 없이 그냥 max - min 하면 끝나는거라 포문 없애고 O(N)으로 동작하도록 변경