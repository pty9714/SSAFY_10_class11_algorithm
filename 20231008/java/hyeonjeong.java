class Solution {
    int MOD = 20170805;
    int[][] directions = {{0, 1}, {1, 0}};
    int m, n, answer;
    int[][] cityMap;
    
    public int solution(int m, int n, int[][] cityMap) {
        
        dfs(0, 0, 0);
        dfs(0, 0, 1);
        
        return answer % MOD;
        
    }
    public void dfs(int i, int j, int dir) {
        if (i==m-1 && j==n-1) {
            answer++;
            return;
        }

        int ni = i + directions[dir][0];
        int nj = j + directions[dir][1];
        if (ni < 0 || ni >= m || nj < 0 || nj >= n) return;
        if (cityMap[ni][nj] != 2) dfs(ni, nj, dir);
        else if (cityMap[ni][nj] == 0) {
            dfs(ni, nj, 0);
            dfs(ni, nj, 1);
        }
    
    }
}
