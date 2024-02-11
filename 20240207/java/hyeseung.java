import java.io.*;
import java.util.StringTokenizer;

// 14380KB, 1272ms
public class B15684 {
    public static int N, H, ans = 4;
    public static boolean[][] sadari;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        sadari = new boolean[H+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sadari[a][b] = true;
        }
        dfs(1, 1, 0);
        if(ans == 4) ans = -1;
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dfs(int a, int b, int cnt) {
        if(cnt > 3) {
            return;
        }
        if(equal()) {
            ans = Math.min(ans, cnt);
            return;
        }
        for (int i = a; i <= H; i++) {
            if(i != a) b = 1;
            for (int j = b; j < N; j++) {
                if(sadari[i][j] || sadari[i][j+1] || sadari[i][j-1]) continue;
                sadari[i][j] = true;
                dfs(i, j, cnt+1);
                sadari[i][j] = false;
            }
        }
    }

    public static boolean equal() {
        for (int i = 1; i <= N; i++) {
            int end = i;
            for (int j = 1; j <= H; j++) {
                if(sadari[j][end]) end++;
                else if(sadari[j][end-1]) end--;
            }
            if(i != end) return false;
        }
        return true;
    }
}
/*
백트래킹 + dfs
-> dfs를 N*H하니 시간초과 나서 a, b로 바꿈
 */
