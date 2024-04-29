import java.io.*;
import java.util.StringTokenizer;
// 14720KB, 248ms
public class B11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N + 1][2];
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            for (int first = 1; first + i <= N; first++) {
                int last = i + first;
                dp[first][last] = Integer.MAX_VALUE;
                for (int middle = first; middle < last; middle++) {
                    dp[first][last] = Math.min(dp[first][last], dp[first][middle] + dp[middle + 1][last] + matrix[first][0] * matrix[middle][1] * matrix[last][1]);
                }
            }
        }
        bw.write(dp[1][N] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
