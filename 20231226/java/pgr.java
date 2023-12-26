import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int N;
    static List<Node>[] graph;

    static class Node implements Comparable<Node> {
        int w;
        int v;
        public Node(int w, int v) {
            this.w = w;
            this.v = v;
        }
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.w, other.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(c, b));
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dijkstra(i, X) + dijkstra(X, i));
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> heap = new PriorityQueue<>();
        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF);
        heap.add(new Node(0, start));
        distance[start] = 0;
        while (!heap.isEmpty()) {
            Node p = heap.poll();
            int now = p.v;
            int dist = p.w;
            if (distance[now] < dist) continue;
            for (Node np : graph[now]) {
                int next = np.v;
                int ndist = np.w;
                int cost = dist + ndist;
                if (cost < distance[next]) {
                    distance[next] = cost;
                    heap.add(new Node(cost, next));
                }
            }
        }
        return distance[end];
    }
}
