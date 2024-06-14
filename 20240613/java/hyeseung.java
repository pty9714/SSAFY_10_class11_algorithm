import java.io.*;
import java.util.StringTokenizer;
// 17084KB, 136ms
public class B17136 {
    private static int[][] paper;
    private static int[] piece = {0, 5, 5, 5, 5, 5};
    private static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        paper = new int[10][10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        bw.write((ans == Integer.MAX_VALUE ? -1 : ans) + "");
        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int index, int cnt) {
        if(index == 100) {
            ans = Math.min(ans, cnt);
            return;
        }
        if(ans <= cnt) return;
        int x = index / 10;
        int y = index % 10;
        if(paper[x][y] == 1) {
            for (int i = 5; i > 0; i--) {
                if(piece[i] > 0 && check(x, y, i)) {
                    piece[i]--;
                    fill(x, y, i, 0);
                    dfs(index + 1, cnt + 1);
                    fill(x, y, i, 1);
                    piece[i]++;
                }
            }
        }
        else {
            dfs(index + 1, cnt);
        }
    }
    private static void fill(int x, int y, int size, int num) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                paper[i][j] = num;
            }
        }
    }
    private static boolean check(int x, int y, int size) {
        if(x + size > 10 || y + size > 10) return false;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if(paper[i][j] != 1) return false;
            }
        }
        return true;
    }
}
