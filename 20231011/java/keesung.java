
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            HashMap<Integer, ArrayList<Integer>> buildingMap = new HashMap<>();

            int[] costs = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                costs[i] = Integer.parseInt(st.nextToken());
                buildingMap.put(i, new ArrayList());
            }
            int startNode = 1;
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    startNode = a;
                }
                int b = Integer.parseInt(st.nextToken());
                buildingMap.get(a).add(b);
            }
            int W = Integer.parseInt(br.readLine());

            boolean[] visited = new boolean[N + 1];

            int result = 0;
            PriorityQueue<Building> pq = new PriorityQueue<>();
            pq.offer(new Building(startNode, costs[startNode]));
            while (!pq.isEmpty()) {
                Building building = pq.poll();
                if (building.position == W) {
                    result = Math.max(result, building.cost);
                }
                if (visited[building.position]) {
                    continue;
                }
                visited[building.position] = true;

                for (Integer i : buildingMap.get(building.position)) {
                    if (!visited[i]) {
                        pq.offer(new Building(i, building.cost + costs[i]));

                    }
                }
            }
            System.out.println(result);
        }
    }

    public static class Building implements Comparable<Building> {
        int position;
        int cost;

        public Building(int position, int cnt) {
            this.position = position;
            this.cost = cnt;
        }

        public int compareTo(Building o) {
            return o.cost - this.cost;
        }

    }

}