import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class keesung {

    static int V;
    static boolean[] visited;
    static class Node {
        int id;
        ArrayList<int[]> al = new ArrayList<>();

        public Node(int id) {
            this.id = id;
        }

    }

    static class Way implements Comparable {
        int cost;
        Node node;
        boolean friend = false;

        public Way(int cost, Node node) {
            this.cost = cost;
            this.node = node;

        }

        @Override
        public int compareTo(Object o) {
            Way w = (Way) o;
            if (this.cost == w.cost) {
                if (this.friend) {
                    return -1;
                } else if (w.friend) {
                    return 1;
                }
            }
            return this.cost - w.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        visited = new boolean[V+1];
        ArrayList<Node> nodes = new ArrayList<>(V+1);
        for (int i = 0; i <= V; i++) {
            nodes.add(new Node(i));
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 0-based
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes.get(a).al.add(new int[]{b, c});
            nodes.get(b).al.add(new int[]{a, c});
        }

        PriorityQueue<Way> pq = new PriorityQueue<>();
        Way way = new Way(0, nodes.get(1));
        if (P == 1) {
            way.friend = true;
        }
        pq.add(way);
        while (!pq.isEmpty()) {
            Way w = pq.poll();
            if (visited[w.node.id]) {
                continue;
            }
            visited[w.node.id] = true;
//            System.out.println(w.cost + " " + w.node.id + " " + w.friend);
            if (w.node == nodes.get(V)) {
                if (w.friend) {
                    System.out.println("SAVE HIM");
                    return;
                } else {
                    while (!pq.isEmpty()) {
                        Way w2 = pq.poll();
                        if (w2.cost != w.cost) {
                            break;
                        }
                        if (w2.node.id == V &&  w2.friend) {
                            System.out.println("SAVE HIM");
                            return;
                        }
                    }
                }
                System.out.println("GOOD BYE");
                return;
            }

            for (int[] arr : w.node.al) {
                Node n = nodes.get(arr[0]);
                if (visited[n.id]) {
                    continue;
                }
                Way newWay = new Way(w.cost + arr[1], n);
                if (w.friend || n.id == P) {
                    newWay.friend = true;
                }
                pq.add(newWay);
            }
        }

    }

}


// 메모리 19328 시간 212
// visited 처리 하는 방식을, 넣을 때 처리하는 것이 아니라 뺄 때 해야함
// 이유는 priority queue를 쓸 때, 친구를 방문한 애를 먼저 사용하도록 하는데
// 다음 노드를 방문 처리하고 넣게 되면, 친구를 방문한 애에서 갔을 때 업데이트를 못해주기 때문이다.