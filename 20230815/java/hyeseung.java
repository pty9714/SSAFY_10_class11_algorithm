import java.util.*;
class Node implements Comparable<Node> {
    int index;
    int cost;
    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
    
    // 비용 적은 것이 높은 우선 순위
    @Override
    public int compareTo(Node other) {
        return this.cost - other.cost;
    }
}
class Solution {
    public static final int INF = (int) 1e9;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static int[] dist;
    public static boolean[] visited;
    
    public int solution(int n, int[][] costs) {
        int answer = INF;
        dist = new int[n];
        visited = new boolean[n];
        
        // 그래프 초기화
	    for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Node>());
        }
	    
	    // 양방향 인접 그래프
	    for(int [] cost : costs) {
	        graph.get(cost[0]).add(new Node(cost[1], cost[2]));
            graph.get(cost[1]).add(new Node(cost[0], cost[2]));
	    }
               
        // 모든 시작점에 대해 다익스트라 수행하여 비용합 최솟값 구하기
        for(int i = 0; i < n; i++) {
            int temp = 0;
            // 최단 거리 테이블을 모두 무한으로 초기화
            Arrays.fill(dist, INF);
            Arrays.fill(visited, false);
        
            // 다익스트라 수행
            dijkstra(i);

            // 비용 합
            for(int j = 0; j < n; j++) {
                temp += dist[j];
            }
            answer = Math.min(answer, temp);
        }
        return answer;
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작 노드 비용은 0으로 설정하여 큐 삽입
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll(); // 현재 노드
            visited[node.index] = true; // 현재 노드 방문 처리
            for(Node next : graph.get(node.index)) {
                // 방문하지 않고, 현재 노드를 거쳐서 이동하는 거리가 더 짧은 경우
                if(!visited[next.index] && next.cost < dist[next.index]) {
                    dist[next.index] = next.cost;
                    pq.offer(new Node(next.index, next.cost));
                }
            }
        }
    }
}
// 테스트 1 〉	통과 (0.61ms, 70.6MB)
// 테스트 2 〉	통과 (0.57ms, 72.3MB)
// 테스트 3 〉	통과 (1.42ms, 77.7MB)
// 테스트 4 〉	통과 (1.68ms, 75.8MB)
// 테스트 5 〉	통과 (1.38ms, 66.5MB)
// 테스트 6 〉	통과 (2.50ms, 81.2MB)
// 테스트 7 〉	통과 (2.59ms, 65.2MB)
// 테스트 8 〉	통과 (0.99ms, 77.3MB)