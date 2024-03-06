import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2098 {

    static int[][] dp;
    static int n;
    static int[][] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        table = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                table[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][1 << n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 1 << n; j++){
                dp[i][j] = -1;
            }
        }


        System.out.println(dfs(0, 1));
    }

    static int dfs(int curr, int visited){
        if(visited == (1 << n) - 1) {
            dp[curr][visited] = table[curr][0];
            return table[curr][0];
        }
        if(dp[curr][visited] > 0) return dp[curr][visited];
        if(dp[curr][visited] == 0 ) return 0;

        for(int i = 1; i < n; i++){
            if((visited & (1 << i)) != 0 || table[curr][i] == 0) continue;
            int a = dfs(i, visited | (1<<i));
            if(a <= 0) continue;
            if(dp[curr][visited] <= 0) dp[curr][visited] = a + table[curr][i];
            else dp[curr][visited] = Math.min(dp[curr][visited], a + table[curr][i]);
        }
        if(dp[curr][visited] == -1) dp[curr][visited] = 0;
        return dp[curr][visited];
    }
}
