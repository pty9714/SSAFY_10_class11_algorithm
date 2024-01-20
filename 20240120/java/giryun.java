import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] board = new int[2][Math.max(4, n)];
        for (int i = 1; i <= n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            board[0][i] = Integer.parseInt(st.nextToken());
            board[1][i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        long[][] dp = new long[2][Math.max(4, n + 1)];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 0;
        dp[0][2] = board[0][1];
        dp[0][3] = Math.min(dp[0][2] + board[0][2], dp[0][0] + board[1][1]);
        for (int i = 4; i <= n; i++) {
            dp[0][i] = Math.min(dp[0][i - 1] + board[0][i - 1], dp[0][i - 2] + board[1][i - 2]);
            dp[1][i] = Math.min(Math.min(dp[1][i - 1] + board[0][i - 1], dp[1][i - 2] + board[1][i - 2]), dp[0][i - 3] + k);
        }

        bw.write( Math.min(dp[0][n], dp[1][n]) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
