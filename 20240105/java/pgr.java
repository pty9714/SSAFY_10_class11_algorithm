import java.io.*;

public class Main {

    static String A, B;
    static int n, m;
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        A = br.readLine();
        B = br.readLine();

        n = A.length();
        m = B.length();

        dp = new int[n+1][m+1];
        getLCSLength();

        bw.write(dp[n][m] + "\n");
        bw.write(getLCS());

        bw.flush();
        bw.close();
        br.close();
    }

    private static void getLCSLength() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }

    private static String getLCS() {
        StringBuilder sb = new StringBuilder();
        while (n > 0 && m > 0) {
            if (A.charAt(n -1) == B.charAt(m -1)) {
                sb.insert(0, A.charAt(n -1));
                n--;
                m--;
            } else if (dp[n -1][m] > dp[n][m -1]) {
                n--;
            } else {
                m--;
            }
        }
        return sb.toString();
    }
}
