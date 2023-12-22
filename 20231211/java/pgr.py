import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] list;
    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
        }

        visited = new boolean[N + 1];
        dp = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            visited[i] = true;
            dfs(i, i);
        }

        int ans = 0;
        int half = (N + 1) / 2;
        for (int i = 1; i <= N; i++) {
            if (dp[i][0] >= half || dp[i][1] >= half) {
                ans++;
            }
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int now, int start) {
        for (int next : list[now]) {
            if (!visited[next]) {
                visited[next] = true;
                dp[start][0]++; //나보다 가벼운 거
                dp[next][1]++; //나보다 무거운 거
                dfs(next, start);
            }
        }
    }
}
