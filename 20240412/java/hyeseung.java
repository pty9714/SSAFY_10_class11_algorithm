import java.io.*;
import java.util.StringTokenizer;

// 11996KB, 92ms
public class B1531 {
    private static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        matrix = new int[100][100];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            blind(x1, y1, x2, y2);
        }

        int ans = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(matrix[i][j] > M) ans++;
            }
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
    private static void blind(int x1, int y1, int x2, int y2) {
        for (int i = x1-1; i < x2; i++) {
            for (int j = y1-1; j < y2; j++) {
                matrix[i][j]++;
            }
        }
    }
}
