import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.util.Arrays.sort;

public class B2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int coins[] = new int[n];
        int dp[] = new int[k+1];
        for(int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= k; i++){
            dp[i] = 100001;
        }

        sort(coins);

        for(int i = 0; i < n; i++){
            for(int j = coins[i]; j <= k; j++){
                dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
            }
        }

        if(dp[k] == 100001) System.out.println(-1);
        else System.out.println(dp[k]);
    }
}
