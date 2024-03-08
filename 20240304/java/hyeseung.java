import java.io.*;

// 	12888kb, 108ms
public class B2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] wine = new int[N];
        for (int i = 0; i < N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        int[]dp = new int[N];
        dp[0] = wine[0];
        for (int i = 1; i < N; i++) {
            if(i == 1) dp[1] = wine[0] + wine[1];
            else if(i == 2) dp[2] = Math.max(dp[1], Math.max(wine[0] + wine[2], wine[1] + wine[2]));
            else {
                dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]));
            }
        }
        bw.write(dp[N-1] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
