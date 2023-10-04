import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> path;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        path = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            path.add(new ArrayList<Integer>());
        }
        for (int[] road : roads) {
            path.get(road[0]).add(road[1]);
            path.get(road[1]).add(road[0]);
        }
        for (int i = 0; i < sources.length; i++) {
            answer[i] = bfs(n, sources[i], destination);
        }
        return answer;
    }

    public int bfs(int n, int source, int destination) {
        if (source == destination)
            return 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { source, 0 });
        boolean visited[] = new boolean[n + 1];
        visited[source] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int next : path.get(cur[0])) {
                if (next == destination)
                    return cur[1] + 1;
                if (!visited[next]) {
                    visited[cur[0]] = true;
                    q.offer(new int[] { next, cur[1] + 1 });
                }
            }
        }
        return -1;
    }
}
/*
 * 테스트 1 〉 통과 (0.17ms, 69.2MB)
 * 테스트 2 〉 통과 (0.17ms, 70.4MB)
 * 테스트 3 〉 통과 (0.14ms, 75.2MB)
 * 테스트 4 〉 통과 (0.04ms, 72MB)
 * 테스트 5 〉 통과 (0.17ms, 78.6MB)
 * 테스트 6 〉 통과 (141.65ms, 143MB)
 * 테스트 7 〉 통과 (172.34ms, 152MB)
 * 테스트 8 〉 통과 (85.70ms, 136MB)
 * 테스트 9 〉 통과 (23.61ms, 104MB)
 * 테스트 10 〉 통과 (32.57ms, 104MB)
 * 테스트 11 〉 통과 (3933.68ms, 798MB)
 * 테스트 12 〉 통과 (5532.06ms, 955MB)
 * 테스트 13 〉 통과 (7664.71ms, 1.01GB)
 * 테스트 14 〉 통과 (3508.63ms, 607MB)
 * 테스트 15 〉 통과 (2464.22ms, 732MB)
 * 테스트 16 〉 통과 (67.92ms, 103MB)
 */
