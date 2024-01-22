import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
            return;
        }
        int[][] dp = new int[N + 3][2];
        for (int i = 0; i < N + 3; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
        }
        int[][] stones = new int[N - 1][2];
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                stones[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int K = Integer.parseInt(br.readLine());
        dp[1][0] = stones[0][0];
        dp[2][0] = stones[0][1];
        dp[3][1] = K;
        for (int i = 1; i < N - 1; i++) {
            int smallJump = stones[i][0];
            int bigJump = stones[i][1];
            // 매우큰 점프 안했을 때
            if (dp[i][0] != Integer.MAX_VALUE) {
                dp[i + 1][0] = Math.min(dp[i + 1][0], dp[i][0] + smallJump);
                dp[i + 2][0] = Math.min(dp[i + 2][0], dp[i][0] + bigJump);
                dp[i + 3][1] = Math.min(dp[i + 3][1], dp[i][0] + K);
            }
            if (dp[i][1] != Integer.MAX_VALUE) {
                dp[i + 1][1] = Math.min(dp[i + 1][1], dp[i][1] + smallJump);
                dp[i + 2][1] = Math.min(dp[i + 2][1], dp[i][1] + bigJump);
            }

        }
        System.out.println(Math.min(dp[N - 1][0], dp[N - 1][1]));

    }

}

// dp로 풀었음