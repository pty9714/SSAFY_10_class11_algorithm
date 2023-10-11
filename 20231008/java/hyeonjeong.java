class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        
        int[][] map = new int[m+1][n+1];
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                map[i][j] = cityMap[i-1][j-1];
            }
        }
        
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1)
                    continue;
                
                int up = i;
                while (map[--up][j] == 2) {}
                dp[i][j] += dp[up][j] % MOD;
                
                int left = j;
                while (map[i][--left] == 2) {}
                dp[i][j] += dp[i][left] % MOD;
                
            }
        }

        return dp[m][n] % MOD;
    }
}

// 통과 (289.31ms, 97.7MB)
