import java.util.*;
import java.awt.Point;

class Solution {
    static final int MAX = Integer.MAX_VALUE;
    static int[] distance;
    static List<Point>[] graph;
    static Set<Integer> summitSet;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        answer[1] = MAX;
        
        distance = new int[n + 1];
        Arrays.fill(distance, MAX);
        
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            graph[path[0]].add(new Point(path[2], path[1]));
            graph[path[1]].add(new Point(path[2], path[0]));
        }
        
        summitSet = new TreeSet<>();
        for (int summit : summits) {
            summitSet.add(summit);
        }
        
        dijkstra(gates);
            
        for (int summit : summitSet) {
            if (distance[summit] < answer[1]) {
                answer[0] = summit;
                answer[1] = distance[summit];
            }
        }
        return answer;
    }
    
    public static void dijkstra(int[] gates) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.x));
        for (int gate : gates) {
            pq.offer(new Point(0, gate));
            distance[gate] = 0;
        }
        
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (summitSet.contains(p.y) || distance[p.y] < p.x) {
                continue;
            }
            for (Point np : graph[p.y]) {
                int cost = Math.max(p.x, np.x);
                if (distance[np.y] > cost) {
                    pq.offer(new Point(cost, np.y));
                    distance[np.y] = cost;
                }
            }
        }
    }
}
//TreeSet은 HashSet과 달리 자동 정렬을 해준다는 특징이 있다.
