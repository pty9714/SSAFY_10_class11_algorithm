import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2533 {

    static int[][] dp;
    static boolean[] visited;
    static ArrayList<Integer>[] connected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        dp = new int[n+1][2];
        visited = new boolean[n+1];
        connected = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            connected[i] = new ArrayList<>();
        }

        for(int i = 1; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            connected[a].add(b);
            connected[b].add(a);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }

    static void dfs(int curr){

        visited[curr] = true;
        dp[curr][0] = 0;
        dp[curr][1] = 1;

        for(int next : connected[curr]){
            if(!visited[next]){
                dfs(next);
                dp[curr][0] += dp[next][1];
                dp[curr][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }
}
