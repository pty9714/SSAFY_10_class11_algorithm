import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2098 {
    static int N;
    static int[][] W;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        dp = new int[N][(1 << N) - 1]; // 1 << 5 = 10000(2) = 32 최댓값은 11111(2)이므로 1 뺌
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = dfs(0, 1);
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
    // 어느 도시에서 시작하든지 최소비용은 같으므로 0번 도시부터 시작
    private static int dfs(int index, int visitBit) {
        if (visitBit == (1 << N) - 1) {
            if(W[index][0] == 0)
                return 100000000;
            return W[index][0]; // 현재 도시 -> 0번째(시작) 도시 이동 거리
        }
        if (dp[index][visitBit] != -1) {
            return dp[index][visitBit];
        }
        dp[index][visitBit] = 100000000;
        for (int i = 0; i < N; i++) {
            if ((visitBit & (1 << i)) == 0 && W[index][i] != 0) {
                dp[index][visitBit] = Math.min(dp[index][visitBit], dfs(i, visitBit | (1 << i)) + W[index][i]);
            }
        }
        return dp[index][visitBit];
    }
}
