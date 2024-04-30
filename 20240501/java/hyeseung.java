import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 58376KB, 372ms
public class B2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N + 1][3];
        int[][][] dp = new int[N + 1][2][5];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i][1], Integer.MAX_VALUE);
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < 4; j++) {
                dp[i][0][j] = Math.max(dp[i-1][0][j-1], Math.max(dp[i-1][0][j], dp[i-1][0][j+1])) + graph[i][j-1];
                dp[i][1][j] = Math.min(dp[i-1][1][j-1], Math.min(dp[i-1][1][j], dp[i-1][1][j+1])) + graph[i][j-1];
            }
        }
        int maxAns = 0, minAns = Integer.MAX_VALUE;
        for (int i = 1; i < 4; i++) {
            maxAns = Math.max(maxAns, dp[N][0][i]);
            minAns = Math.min(minAns, dp[N][1][i]);
        }
        bw.write(maxAns + " " + minAns);
        bw.flush();
        bw.close();
        br.close();
    }
}
