import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17404 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[][] cost = new int[N][3];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        int min_cost = Integer.MAX_VALUE;

        int[][] dp = new int[N][3];
        
        for (int k = 0; k < 3; k++) {

            dp[0][0] = 1001;
            dp[0][1] = 1001;
            dp[0][2] = 1001;
            dp[0][k] = cost[0][k];

            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
            }

            for (int j = 0; j < 3; j++) {
                if (j != k && min_cost > dp[N-1][j]) {
                    min_cost = dp[N - 1][j];
                }
            }
        }

        System.out.println(min_cost);
    }
}

// 14504 kb	140 ms
