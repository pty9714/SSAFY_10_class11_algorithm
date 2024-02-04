import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            nodes.add(new Node(i, n));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes.get(a).addAdjacent(nodes.get(b));
            nodes.get(b).addAdjacent(nodes.get(a));
        }

        for (int i = 1; i <= n; i++) {
            Node node = nodes.get(i);
            Queue<int[]> pq = new LinkedList<>();
            boolean[] visited = new boolean[n + 1];
            visited[i] = true;

            // System.out.println("node.index = " + node.index);
            for (Node adjacent : node.adjacent) {
                int[] add = { adjacent.index, 1 };
                pq.add(add);
                visited[adjacent.index] = true;
            }

            while (!pq.isEmpty()) {
                int[] poll = pq.poll();
                int index = poll[0];
                int distance = poll[1];
                node.distance[index] = distance;

                for (Node adjacent : nodes.get(index).adjacent) {
                    if (!visited[adjacent.index]) {
                        pq.add(new int[] { adjacent.index, distance + 1 });
                        visited[adjacent.index] = true;
                    }
                }
            }
            // System.out.println("거리 = " + Arrays.toString(node.distance));
        }

        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int sum = 0;
                for (int k = 1; k <= n; k++) {
                    sum += Math.min(nodes.get(i).distance[k], nodes.get(j).distance[k]);
                }
                if (sum < min) {
                    min = sum;
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1] + " " + min * 2);

    }

    public static class Node {

        int index;
        ArrayList<Node> adjacent = new ArrayList<>();
        int[] distance;

        public Node(int index, int n) {
            this.index = index;
            distance = new int[n + 1];
        }

        public void addAdjacent(Node node) {
            adjacent.add(node);
        }
    }

}