import java.io.*;
import java.util.StringTokenizer;

public class giryun {
    static int n, m, answer;
    static boolean isCycle;
    static int[][] board, dp;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == 'H')
                    board[i][j] = 10;
                else
                    board[i][j] = input.charAt(j) - 48;
            }
        }
        dp = new int[n][m];
        visited = new boolean[n][m];
        visited[0][0] = true;
        dfs(0, 0, 1);
        answer = isCycle ? -1 : answer;
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int x, int y, int cnt) {
        if (cnt > answer) answer = cnt;
        dp[x][y] = cnt;
        for (int d = 0; d < 4; d++) {
            int num = board[x][y];
            int nx = x + num * dx[d];
            int ny = y + num * dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (board[nx][ny] == 10) continue;
            if (dp[nx][ny] > cnt) continue;
            if (visited[nx][ny]) {
                isCycle = true;
                return;
            }
            visited[nx][ny] = true;
            dfs(nx, ny, cnt+1);
            visited[nx][ny] = false;
        }
    }
}
//12968	100
