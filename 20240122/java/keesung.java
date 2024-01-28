import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[][][] dp = new int[N + 1][M + 1][3]; // 0 : 정글, 1 : 바다, 2 : 얼음
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                char text = map[i - 1][j - 1];
                if (text == 'J') {
                    dp[i][j][0] = dp[i - 1][j][0] + dp[i][j - 1][0] - dp[i - 1][j - 1][0] + 1;
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i][j - 1][1] - dp[i - 1][j - 1][1];
                    dp[i][j][2] = dp[i - 1][j][2] + dp[i][j - 1][2] - dp[i - 1][j - 1][2];
                } else if (text == 'O') {
                    dp[i][j][0] = dp[i - 1][j][0] + dp[i][j - 1][0] - dp[i - 1][j - 1][0];
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i][j - 1][1] - dp[i - 1][j - 1][1] + 1;
                    dp[i][j][2] = dp[i - 1][j][2] + dp[i][j - 1][2] - dp[i - 1][j - 1][2];
                } else if (text == 'I') {
                    dp[i][j][0] = dp[i - 1][j][0] + dp[i][j - 1][0] - dp[i - 1][j - 1][0];
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i][j - 1][1] - dp[i - 1][j - 1][1];
                    dp[i][j][2] = dp[i - 1][j][2] + dp[i][j - 1][2] - dp[i - 1][j - 1][2] + 1;
                }
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int a = dp[x2][y2][0] - dp[x1 - 1][y2][0] - dp[x2][y1 - 1][0] + dp[x1 - 1][y1 - 1][0];
            int b = dp[x2][y2][1] - dp[x1 - 1][y2][1] - dp[x2][y1 - 1][1] + dp[x1 - 1][y1 - 1][1];
            int c = dp[x2][y2][2] - dp[x1 - 1][y2][2] - dp[x2][y1 - 1][2] + dp[x1 - 1][y1 - 1][2];

            System.out.println(a + " " + b + " " + c);
        }

    }

}

// dp + 누적합, 사각형의 합 구할 때 전체에서 빼는 방식 활용