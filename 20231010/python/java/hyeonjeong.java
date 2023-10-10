class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                map[i][j] = 1;
            }
        }
        for (int[] puddle : puddles) {
            map[puddle[1]][puddle[0]] = 0;
        }
        
        if (m==1 || n==1) {
            return 1;
        }
        
        for (int i=2; i<=n; i++) {
            for (int j=2; j<=m; j++) {
                if (map[i][j]==0) continue;
                map[i][j] = map[i][j-1] + map[i-1][j];
            }
        }
        
        return map[n][m] % 1_000_000_007;
    }
}
