class Solution {
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
        for (int i = 1; i < dp.length; i++) {
            for (int j = i; j < dp.length; j++) {
                long tmp = Math.abs(dp[j] - dp[i - 1]);
                if (tmp > answer) {
                    answer = tmp;
                }

            }
        }
        return answer;
    }
}