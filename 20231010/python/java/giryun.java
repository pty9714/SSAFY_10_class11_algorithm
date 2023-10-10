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
        return dp[n][m];
    }
}
/*
정확성  테스트
테스트 1 〉	통과 (0.03ms, 75.9MB)
테스트 2 〉	통과 (0.02ms, 82.1MB)
테스트 3 〉	통과 (0.04ms, 76.4MB)
테스트 4 〉	통과 (0.04ms, 80.1MB)
테스트 5 〉	통과 (0.05ms, 76.5MB)
테스트 6 〉	통과 (0.03ms, 71.8MB)
테스트 7 〉	통과 (0.03ms, 75.1MB)
테스트 8 〉	통과 (0.04ms, 74.3MB)
테스트 9 〉	통과 (0.03ms, 74.9MB)
테스트 10 〉	통과 (0.03ms, 73.4MB)
효율성  테스트
테스트 1 〉	통과 (0.63ms, 52.2MB)
테스트 2 〉	통과 (0.26ms, 52.4MB)
테스트 3 〉	통과 (0.32ms, 51.9MB)
테스트 4 〉	통과 (0.36ms, 52MB)
테스트 5 〉	통과 (0.40ms, 51.9MB)
테스트 6 〉	통과 (0.63ms, 52.1MB)
테스트 7 〉	통과 (0.30ms, 68.5MB)
테스트 8 〉	통과 (0.46ms, 59.6MB)
테스트 9 〉	통과 (0.52ms, 52.2MB)
테스트 10 〉	통과 (0.54ms, 52.2MB)
*/
