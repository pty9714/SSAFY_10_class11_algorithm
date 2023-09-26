import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> organization = new HashMap<Integer, List<Integer>>();
    private int dp[][];

    public int solution(int[] sales, int[][] links) {
        int length = sales.length;
        dp = new int[length][2];
        // 초기화
        for (int i = 0; i < length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int[] link : links) {
            if (!organization.containsKey(link[0] - 1)) {
                organization.put(link[0] - 1, new ArrayList<>());
            }
            organization.get(link[0] - 1).add(link[1] - 1);
        }

        return Math.min(dfs(0, 0, sales), dfs(0, 1, sales));
    }

    public int dfs(int cur, int isContain, int[] sales) {
        // 기저 조건
        if (dp[cur][isContain] != Integer.MAX_VALUE)
            return dp[cur][isContain];
        if (!organization.containsKey(cur))
            return isContain == 0 ? 0 : sales[cur];

        int min = isContain == 0 ? 0 : sales[cur];
        int minDiff = Integer.MAX_VALUE; // 하위 노드의 포함과 비포함 차이 최솟값
        boolean flag = false; // 하위 노드 포함 여부
        for (int member : organization.get(cur)) {
            int notContain = dfs(member, 0, sales);
            int contain = dfs(member, 1, sales);

            minDiff = Math.min(minDiff, contain - notContain);
            if (notContain < contain) {
                min += notContain;
            } else {
                min += contain;
                flag = true;
            }
        }

        // 모든 노드 미포함 시 minDiff 더해줌
        if (!flag && isContain == 0) {
            min += minDiff;
        }

        return dp[cur][isContain] = min;
    }
}