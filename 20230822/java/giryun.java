import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] B;
    static HashSet<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= tc; t++) {
            B = new int[4][4];
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    B[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            set = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(i, j, String.valueOf(B[i][j]));
                }
            }
            bw.write("#" + t + " " + set.size() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y, String num) {
        if (num.length() == 7) {
            set.add(num);
            return;
        }
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
            dfs(nx, ny, num+B[nx][ny]);
        }
    }
}
// 69,892 kb, 206 ms