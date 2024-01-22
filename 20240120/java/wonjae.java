import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21317 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][2];
        Point rocks[] = new Point[n+1];

        for(int i = 1; i < n; i++){
            st = new StringTokenizer(br.readLine());
            rocks[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int k = Integer.parseInt(br.readLine());

        for(int i = 0; i < n+1; i++){
            dp[i][0] = dp[i][1] = 100001;
        }

        dp[1][0] = 0;
        if(n == 1){
            System.out.println(dp[1][0]);
            return;
        }
        dp[2][0] = rocks[1].x;
        for(int i = 3; i < n+1; i++){
            dp[i][0] = Math.min(dp[i-1][0] + rocks[i-1].x, dp[i-2][0] + rocks[i-2].y);
            dp[i][1] = Math.min(dp[i-3][0] + k, Math.min(dp[i-1][1] + rocks[i-1].x, dp[i-2][1] + rocks[i-2].y));
        }

        System.out.println(Math.min(dp[n][0], dp[n][1]));
    }
}
