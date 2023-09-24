import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[] items = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        if (N == 1) {
            System.out.println(items[0]);
            return;
        }

        Hashtable<Integer, LinkedList<int[]>> map = new Hashtable<>();
        for (int i = 0; i < N; i++) {
            map.put(i, new LinkedList<>());
        }
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            map.get(a).add(new int[] { b, c });
            map.get(b).add(new int[] { a, c });
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            visited = new boolean[N];
            PriorityQueue<Node> q = new PriorityQueue<>();
            q.offer(new Node(i, 0));
            while (!q.isEmpty()) {
                Node node = q.poll();
                // System.out.println(node.idx + " " + node.cnt);
                if (visited[node.idx]) {
                    continue;
                }
                cnt += items[node.idx];
                visited[node.idx] = true;
                LinkedList<int[]> list = map.get(node.idx);
                for (int j = 0; j < list.size(); j++) {
                    int[] next = list.get(j);
                    if (!visited[next[0]] && node.cnt + next[1] <= M) {
                        q.offer(new Node(next[0], node.cnt + next[1]));
                    }
                }
            }
            if (result < cnt) {
                result = cnt;
            }

        }

        System.out.println(result);
    }

    static class Node implements Comparable<Node> {
        int idx;
        int cnt;

        Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt - o.cnt;
        }
    }

}
