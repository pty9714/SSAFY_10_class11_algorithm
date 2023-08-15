import java.util.*;

public class Solution {
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[2], b[2]);
            }
        });
        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int costValue = cost[2];
            if (find(parent, a) != find(parent, b)) {
                union(parent, a, b);
                answer += costValue;
            }
        }
        return answer;
    }
    
    private static int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}

// 테스트 1 〉	통과 (0.31ms, 75.5MB)
// 테스트 2 〉	통과 (0.49ms, 70.6MB)
// 테스트 3 〉	통과 (0.57ms, 78.9MB)
// 테스트 4 〉	통과 (0.52ms, 73MB)
// 테스트 5 〉	통과 (1.02ms, 75.9MB)
// 테스트 6 〉	통과 (0.48ms, 67.4MB)
// 테스트 7 〉	통과 (0.63ms, 73.3MB)
// 테스트 8 〉	통과 (0.47ms, 76.8MB)