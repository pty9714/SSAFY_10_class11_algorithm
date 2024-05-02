import java.io.*;
import java.util.StringTokenizer;

// 293744KB, 552ms
public class B14712 {
    private static int N, M;
    private static boolean[][] matrix;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new boolean[N][M];
        ans = 0;
        dfs(0);
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int cnt) {
        if(cnt == N * M) {
            ans++;
            return;
        }
        int x = cnt / M;
        int y = cnt % M;
        dfs(cnt + 1);
        matrix[x][y] = true;
        if(!stopGame(x, y)) {
            dfs(cnt + 1);
        }
        matrix[x][y] = false;
    }
    private static boolean stopGame(int x, int y) {
        int[] dx = {-1, -1, 0};
        int[] dy = {-1, 0, -1};
        for (int i = 0; i < 3; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];
            if(tempX < 0 || tempY < 0 || !matrix[tempX][tempY]) return false;
        }
        return true;
    }
}
