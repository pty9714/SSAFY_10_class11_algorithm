import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 47660KB 340ms
public class B2342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> input = new ArrayList<>();
        int temp = -1;
        while((temp = Integer.parseInt(st.nextToken())) != 0) {
            input.add(temp);
        }
        if(input.isEmpty()) {
            System.out.print(0);
            return;
        }
        int[][][] dp = new int[input.size() + 1][5][5];
        for (int i = 0; i <= input.size(); i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        dp[0][0][0] = 0;
        for (int i = 1; i <= input.size(); i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if(dp[i-1][j][k] == Integer.MAX_VALUE) continue;
                    dp[i][j][input.get(i-1)] = Math.min(dp[i][j][input.get(i-1)], dp[i-1][j][k] + score(k, input.get(i-1)));
                    dp[i][input.get(i-1)][k] = Math.min(dp[i][input.get(i-1)][k], dp[i-1][j][k] + score(j, input.get(i-1)));
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                ans = Math.min(ans, dp[input.size()][i][j]);
            }
        }
        System.out.println(ans);
        br.close();
    }
    private static int score(int from, int to) {
        if(from == 0) return 2;
        else if(Math.abs(from - to) == 2) return 4;
        else if(from == to) return 1;
        else return 3;
    }
}
