import java.io.*;
import java.util.StringTokenizer;

public class B21319 {
    static int[] dp;
    static int[] akbo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        dp = new int[n+2];
        akbo = new int[n+2];
        dp[0] = akbo[0] = 0;
        st = new StringTokenizer(br.readLine());

        int temp;

        for(int i = 1; i <= n; i++){
            temp = Integer.parseInt(st.nextToken());
            akbo[i] = temp;
            dp[i] = temp < akbo[i-1]?dp[i-1]+1:dp[i-1];
        }

        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        int x, y;
        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            sb.append(dp[y]-dp[x]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
