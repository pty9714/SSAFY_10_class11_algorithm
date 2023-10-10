class Solution {
    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[2][m][n]; // 0은 왼쪽에서 온것, 1은 위에서 온 것
        int[] dx = { 0, 1 };
        int[] dy = { 1, 0 };
        dp[0][0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cityMap[i][j] == 1) {
                    continue;
                }
                for (int k = 0; k < 2; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < m && ny < n) {
                        dp[k][nx][ny] += dp[k][i][j];
                        if (cityMap[i][j] == 2) {
                            dp[k][nx][ny] %= 20170805;
                            continue;
                        }
                        dp[k][nx][ny] += dp[(k + 1) % 2][i][j];
                        dp[k][nx][ny] %= 20170805;
                    }
                }
            }
        }
        int answer = dp[0][m - 1][n - 1] + dp[1][m - 1][n - 1];
        answer %= 20170805;
        return answer;
    }
}

// dp 나머지 계산 주의
// 통과 (76.24ms, 106MB)