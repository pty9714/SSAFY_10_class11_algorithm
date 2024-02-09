import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 117984KB, 764ms
public class B1753 {
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
    public static int V, E;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        distance = new int[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<Node>());
        }
        int start = Integer.parseInt(br.readLine());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        dijkstra(start);
        for (int i = 1; i <= V; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            }
            else {
                bw.write(distance[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(distance[cur.index] < cur.distance) continue;
            for (Node next : graph.get(cur.index)) {
                int cost = distance[cur.index] + next.distance;
                if(cost < distance[next.index]) {
                    distance[next.index] = cost;
                    pq.offer(new Node(next.index, cost));
                }
            }
        }
    }
}
/*
다익스트라
 */
