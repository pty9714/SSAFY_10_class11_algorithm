import java.io.*;
import java.util.StringTokenizer;

// 16020KB, 132ms
public class B1976 {
    private static int N;
    private static int[] plans;
    private static int[][] cities;
    private static boolean[] visited;
    private static String ans = "YES";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        cities = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cities[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        plans = new int[M];
        for (int i = 0; i < M; i++) {
            plans[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];
        dfs(plans[0] - 1);
        for (int plan : plans) {
            if(!visited[plan - 1]) {
                ans = "NO";
                break;
            }
        }
        bw.write(ans);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int city) {
        visited[city] = true;
        for (int i = 0; i < N; i++) {
            if(cities[city][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

}
