import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int f, t, v;
    static int ans = 0, max = 0;
    static List<Point>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(0);
            System.exit(0);
        }

        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            f = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            list[f].add(new Point(t, v));
            list[t].add(new Point(f, v));
        }

        visited = new boolean[n+1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[n+1];
        visited[max] = true;
        dfs(max, 0);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int now, int res) {
        if (ans < res) {
            ans = res;
            max = now;
        }
        for (Point p : list[now]) {
            if (!visited[p.x]) {
                visited[p.x] = true;
                dfs(p.x, res+p.y);
            }
        }
    }
}
//20492	184
