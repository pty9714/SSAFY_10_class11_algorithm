import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int[][] routes = new int[n+1][n+1];
        for (int[] road : roads) {
            if (routes[road[0]][road[1]] == 0 || routes[road[0]][road[1]] > road[2]) {
                routes[road[0]][road[1]] = road[2];
            }
        }
        int[] flip = new int[n+1];
        for (int trap : traps) {
            flip[trap] = -1;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {start, 0});
        
        int result = 0;
        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            if (cur[0] == end && cur[1] < result) result = cur[1];
            if (flip[cur[0]] != 0) flip[cur[0]] *= -1;
            if (flip[cur[0]] <= 0) {
                for (int i=1; i<=n; i++) {
                    if (routes[cur[0]][i] > 0) {
                        queue.add(new int[] {i, cur[1] + routes[cur[0]][i]});
                    }
                }
            }
            if (flip[cur[0]] > 0) {
                for (int i=1; i<=n; i++) {
                    if (routes[i][cur[0]] > 0) {
                        queue.add(new int[] {i, cur[1] + routes[i][cur[0]]});
                    }
                }
            }
        }
        return result;
    }
}
