import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] board, dp;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            Arrays.fill(dp[i], -1);
        }

        bw.write(dfs(1, 1) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dfs(int x, int y) {
        if (x == M && y == N) return 1;
        if (dp[x][y] != -1) return dp[x][y];
        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 1 || ny < 1 || nx > M || ny > N) continue;
            if (board[x][y] > board[nx][ny]) dp[x][y] += dfs(nx, ny);
        }
        return dp[x][y];
    }

}
