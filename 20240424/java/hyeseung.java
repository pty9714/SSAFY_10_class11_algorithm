import java.io.*;
import java.util.*;

public class B3075 {
    static class Node implements Comparable<Node> {
        int index;
        int distance;
        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
    private static final int INF = Integer.MAX_VALUE;
    private static int n, p, q;
    private static int[] meeting;
    private static int[][] distance;
    private static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());
            meeting = new int[n];
            graph = new ArrayList<ArrayList<Node>>();
            distance = new int[n][p];
            for (int i = 0; i < p; i++) {
                graph.add(new ArrayList<Node>());
            }
            for (int i = 0; i < n; i++) {
                meeting[i] = Integer.parseInt(br.readLine()) - 1;
                Arrays.fill(distance[i], INF);
            }
            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int d = Integer.parseInt(st.nextToken());
                graph.get(a).add(new Node(b, d));
                graph.get(b).add(new Node(a, d));
            }
            for (int i = 0; i < n; i++) {
                dijkstra(i);
            }
            int ansGalaxy = 0;
            long ansPath = (long) INF * INF;
            for (int i = 0; i < p; i++) {
                long tempPath = 0;
                boolean flag = true;
                for (int j = 0; j < n; j++) {
                    if(distance[j][i] == INF) {
                        flag = false;
                        break;
                    }
                    tempPath += (long) distance[j][i] * distance[j][i];
                }
                if(flag && ansPath > tempPath) {
                    ansGalaxy = i + 1;
                    ansPath = tempPath;
                }
            }
            sb.append(ansGalaxy).append(" ").append(ansPath).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(meeting[start], 0));
        distance[start][meeting[start]] = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(distance[start][cur.index] < cur.distance) continue;
            for (Node next : graph.get(cur.index)) {
                int cost = next.distance + distance[start][cur.index];
                if(distance[start][next.index] > cost) {
                    distance[start][next.index] = cost;
                    pq.offer(new Node(next.index, cost));
                }
            }
        }
    }
}
