import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int N;
    static List<Node>[] from_village, to_village;

    static class Node {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        from_village = new ArrayList[N + 1];
        to_village = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            from_village[i] = new ArrayList<>();
            to_village[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            from_village[s].add(new Node(t, e));
            to_village[e].add(new Node(t, s));
        }

        int[] from_x = dijkstra(X, from_village);
        int[] to_x = dijkstra(X, to_village);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (from_x[i] + to_x[i] > ans) {
                ans = from_x[i] + to_x[i];
            }
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[] dijkstra(int x, List<Node>[] list) {
        int[] distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        q.add(new Node(0, x));
        int cnt = 0;
        while (cnt < N) {
            Node now = q.poll();
            if (visited[now.index]) {
                continue;
            }
            distance[now.index] = now.value;
            visited[now.index] = true;
            cnt++;

            for (Node node : list[now.index]) {
                if (!visited[node.index]) {
                    q.add(new Node(node.value + now.value, node.index));
                }
            }
        }
        return distance;
    }
    
}
//원재덕에 속도 향상!
