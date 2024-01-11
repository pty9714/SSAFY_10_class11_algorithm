import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                dp[i][j][0] = Integer.MIN_VALUE;
                dp[i][j][1] = Integer.MIN_VALUE;
                dp[i][j][2] = Integer.MIN_VALUE;
            }
        }

        dp[1][1][0] = board[1][1];
        dp[1][1][1] = board[1][1];
        dp[1][1][2] = board[1][1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (j > 1)
                    dp[i][j][0] = Math.max(dp[i][j - 1][0], dp[i][j - 1][1]) + board[i][j];
                if (i > 1)
                    dp[i][j][1] = Math.max(dp[i - 1][j][0], Math.max(dp[i - 1][j][1], dp[i - 1][j][2])) + board[i][j];
            }
            for (int j = M - 1; j >= 1; j--) {
                dp[i][j][2] = Math.max(dp[i][j + 1][1], dp[i][j + 1][2]) + board[i][j];
            }
        }
        bw.write(Math.max(dp[N][M][0], dp[N][M][1]) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
