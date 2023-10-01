import java.util.*;

class Solution {
    static List<List<Integer>> graph;
    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        int[] result = bfs(destination);
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) answer[i] = result[sources[i]];
        return answer;
    }
    
    private static int[] bfs(int start) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        int[] visisted = new int[graph.size()];
        Arrays.fill(visisted, -1);
        visisted[start] = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int nx : graph.get(x)) {
                if (visisted[nx] == -1) {
                    q.add(nx);
                    visisted[nx] = visisted[x] + 1;
                }
            }
        }
        return visisted;
    }
}

/*
테스트 1 〉	통과 (0.14ms, 85.1MB)
테스트 2 〉	통과 (0.10ms, 74.4MB)
테스트 3 〉	통과 (0.10ms, 76.6MB)
테스트 4 〉	통과 (0.07ms, 71.7MB)
테스트 5 〉	통과 (0.11ms, 72.4MB)
테스트 6 〉	통과 (25.87ms, 90.5MB)
테스트 7 〉	통과 (22.68ms, 92MB)
테스트 8 〉	통과 (28.93ms, 106MB)
테스트 9 〉	통과 (18.39ms, 101MB)
테스트 10 〉	통과 (18.84ms, 85.3MB)
테스트 11 〉	통과 (117.22ms, 188MB)
테스트 12 〉	통과 (110.13ms, 190MB)
테스트 13 〉	통과 (134.74ms, 174MB)
테스트 14 〉	통과 (131.94ms, 196MB)
테스트 15 〉	통과 (103.22ms, 180MB)
테스트 16 〉	통과 (54.76ms, 115MB)
*/
