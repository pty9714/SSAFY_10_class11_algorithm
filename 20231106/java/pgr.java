import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class pgr {
    static int n;
    static List<Point>[] arr;
    static Queue<Point> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while (true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) break;
                int c = Integer.parseInt(st.nextToken());
                arr[s].add(new Point(e, c));
            }
        }
        Point p1 = bfs(1);
        Point p2 = bfs(p1.x);
        bw.write(p2.y + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static Point bfs(int start) {
        int end = 0;
        int cost = 0;
        q = new LinkedList<>();
        q.add(new Point(start, 0));
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (cost < p.y) {
                end = p.x;
                cost = p.y;
            }
            for (Point next : arr[p.x]) {
                if (!visited[next.x]) {
                    visited[next.x] = true;
                    q.add(new Point(next.x, p.y + next.y));
                }
            }
        }
        return new Point(end, cost);
    }
}
// 109268KB	796ms
