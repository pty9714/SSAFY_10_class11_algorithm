class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][] dp = new int[m+1][n+1];
        
        // dp 배열 채우기
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if (i == 1 && j == 1){
                    dp[i][j] = 1;
                    continue;
                } 
                if (cityMap[i-1][j-1] == 0) { // 0일때만 진행
                    int cnt = 1;
                    int left = dp[i][j-1];
                    while (true){
                        if (j-cnt == 0) {
                            left = dp[i][0];
                            break;
                        }
                        left = dp[i][j-cnt];
                        if (cityMap[i-1][j-cnt-1] == 2){ // 방향전환X
                            cnt++;
                        } else{
                            break;
                        }
                    }
                    int up = dp[i-1][j];
                    cnt = 1;
                    while (true){
                        if (i-cnt == 0) {
                            up = dp[0][j];
                            break;
                        }
                        up = dp[i-cnt][j];
                        if (cityMap[i-cnt-1][j-1] == 2){ // 방향전환X
                            cnt++;
                        } else{
                            break;
                        }
                    }
                    dp[i][j] = (left + up) % MOD;
                }
            }
        }
        
        return dp[m][n];
    }
}

통과 (61.31ms, 92MB)
