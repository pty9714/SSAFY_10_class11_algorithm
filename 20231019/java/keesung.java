
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {

    public static int result = Integer.MAX_VALUE;
    public static int end;
    public static ArrayList<ArrayList<int[]>> neighbors;
    public static int K;
    public static ArrayList<ArrayList<int[]>> memorize;


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken()); // 두께
        int N = Integer.parseInt(st.nextToken()); // 섬 갯수
        int M = Integer.parseInt(st.nextToken()); // 길 갯수

//        memorize = new int[N+1][2]; // 0은 length, 1은 cost
        memorize = new ArrayList<>(N+1);
        neighbors = new ArrayList<>(N+1);
        for (int i = 0; i <= N; i++) {
            memorize.add(new ArrayList<>());
            neighbors.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int roadA = Integer.parseInt(st.nextToken());
            int roadB = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            neighbors.get(roadA).add(new int[] {roadB, length, cost});
            neighbors.get(roadB).add(new int[] {roadA, length, cost});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> queue = new PriorityQueue<>();
        memorize.get(start).add(new int[] {0, 0});
        queue.offer(new Node(start, 0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.length >= result) {
                continue;
            }
            if (node.position == end) {
//                System.out.println("성공 : " + node.length);
                result = node.length;
                break;
            }
            for (int[] neighbor : neighbors.get(node.position)) {
                int newPosition = neighbor[0];
                int newLength = neighbor[1] + node.length;
                int newCost = neighbor[2] + node.cost;
                if (newCost >= K) {
                    continue;
                }

                boolean signal = true;
                for (int[] tmp : memorize.get(newPosition)) {
                    int prevLength = tmp[0];
                    int prevCost = tmp[1];
                    if (newLength >= prevLength && newCost >= prevCost) {
                        signal = false;
                        break;
                    }
                }
                if (!signal) {
                    continue;
                }
                memorize.get(newPosition).add(new int[]{newLength, newCost});

                queue.offer(new Node(newPosition, newCost, newLength));
            }
        }
        if (result == Integer.MAX_VALUE) {
            result = -1;
        }
        System.out.println(result);
    }
    public static class Node implements Comparable<Node>{
        int position;
        int cost;
        int length;

        Node(int position, int cost, int length) {
            this.position = position;
            this.cost = cost;
            this.length = length;

        }

        public int compareTo(Node o) {
            return this.length - o.length;
        }


    }


}
// 메모리 21392kb 240ms;
// 다익스트라