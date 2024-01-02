import java.util.*;
class Solution {
    static class Node implements Comparable<Node> {
        int index; 
        int intensity; // 휴식 없이 이동해야 하는 시간 중 가장 긴 시간 (각 노드에서 쉼)
        Node(int index, int intensity) {
            this.index = index;
            this.intensity = intensity;
        }
        // intensity 최소가 되는 등산코스 여러 개라면 그 중 산봉우리의 번호가 낮은 등산코스 오름차순
        @Override
        public int compareTo(Node o) { 
            if(this.intensity == o.intensity) {
                return this.index - o.index;
            }
            return this.intensity - o.intensity;
        }
    }
    public ArrayList<ArrayList<Node>> route = new ArrayList<ArrayList<Node>>();
    public int[] intensity; // 최단 거리 테이블
    public TreeSet<Integer> summitIndex = new TreeSet<Integer>(); // 산봉우리 인덱스 저장
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        intensity = new int[n+1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        
        // 모든 간선 정보 추가
        for (int i = 0; i <= n; i++) {
            route.add(new ArrayList<Node>());
        }
        for (int[] path : paths) {
            route.get(path[0]).add(new Node(path[1], path[2]));
            route.get(path[1]).add(new Node(path[0], path[2]));
        }
        
        // 산봉우리 인덱스 집합
        for (int summit : summits) {
            summitIndex.add(summit);
        }
        
        // 모든 출입구에 대해 다익스트라 수행
        dijkstra(gates);
        
        // intensity 최소인 등산코스
        answer[1] = Integer.MAX_VALUE;
        for (int summit : summitIndex) {
            if(intensity[summit] < answer[1]) {
                answer[0] = summit;
                answer[1] = intensity[summit];
            }
        }
        
        return answer;
    }
    
    public void dijkstra(int[] gates) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 모든 출입구 추가
        for (int gate : gates) {
            pq.offer(new Node(gate, 0));
            intensity[gate] = 0;            
        }
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            // 이미 방문 노드 또는 산봉우리의 경우 종료
            if(intensity[cur.index] < cur.intensity || summitIndex.contains(cur.index)) continue; 
            for (Node next : route.get(cur.index)) {
                // 최댓값 기준 최솟값으로 업데이트
                int cost = Math.max(cur.intensity, next.intensity);
                if(intensity[next.index] > cost) {
                    intensity[next.index] = cost;
                    pq.offer(new Node(next.index, intensity[next.index]));
                }
            }
        }
    }
}
/*
다익스트라
-> 산봉우리 만나면 멈추도록 함, 왕복 필요 X (모든 출입구에서 intensity 최댓값들 중 최솟값 찾으면 됨)
테스트 1 〉	통과 (0.72ms, 76.5MB)
테스트 2 〉	통과 (0.73ms, 73.6MB)
테스트 3 〉	통과 (0.73ms, 77MB)
테스트 4 〉	통과 (0.74ms, 76.3MB)
테스트 5 〉	통과 (0.75ms, 75.7MB)
테스트 6 〉	통과 (1.05ms, 73.3MB)
테스트 7 〉	통과 (0.99ms, 75MB)
테스트 8 〉	통과 (1.00ms, 75.9MB)
테스트 9 〉	통과 (1.59ms, 79.4MB)
테스트 10 〉	통과 (1.69ms, 80.7MB)
테스트 11 〉	통과 (1.91ms, 73.8MB)
테스트 12 〉	통과 (1.77ms, 80.6MB)
테스트 13 〉	통과 (6.75ms, 88.4MB)
테스트 14 〉	통과 (19.96ms, 107MB)
테스트 15 〉	통과 (70.52ms, 153MB)
테스트 16 〉	통과 (80.97ms, 164MB)
테스트 17 〉	통과 (76.11ms, 161MB)
테스트 18 〉	통과 (11.58ms, 99.4MB)
테스트 19 〉	통과 (35.61ms, 108MB)
테스트 20 〉	통과 (94.21ms, 153MB)
테스트 21 〉	통과 (118.79ms, 137MB)
테스트 22 〉	통과 (16.36ms, 101MB)
테스트 23 〉	통과 (55.38ms, 108MB)
테스트 24 〉	통과 (48.32ms, 110MB)
테스트 25 〉	통과 (158.66ms, 158MB)
*/