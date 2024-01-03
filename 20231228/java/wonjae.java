import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1520 {
    static int[][] field;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        field = new int[m+2][n+2];
        dp = new int[m+2][n+2];

        for(int i = 1; i < m+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n+1; j++){
                field[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        dp[1][1] = DFS(1, 1, field[1][1]);

        System.out.println(dp[1][1]);
    }

    static int DFS(int x, int y, int h){
        if(x == m && y == n) {
            return 1;
        }
        int answer = 0;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx > m || ny < 0 || ny > n || h <= field[nx][ny] || dp[nx][ny] == 0) continue;
            if(dp[nx][ny] != -1) answer+=dp[nx][ny];
            else answer += DFS(nx, ny, field[nx][ny]);
        }
        dp[x][y] = answer;
        return answer;
    }
}
/*
    36792KB	308ms
 */
