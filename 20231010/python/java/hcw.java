class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n+1][m+1];
        for (int[] puddle : puddles) {
            map[puddle[1]][puddle[0]] = 1;
        }
        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 0) {
                    dp[i][j] += (dp[i-1][j] + dp[i][j-1]) % 1000000007;
                }
                else continue;
            }
        }
        return dp[n][m] % 1000000007;
    }
}
