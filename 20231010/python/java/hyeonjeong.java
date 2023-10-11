class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        if (m==1 || n==1) {
            return 1;
        }
        
        // -1로 초기화 (0과 구분하기 위해)
        int[][] map = new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                map[i][j] = -1;
            }
        }
        // 물 0로 표시
        for (int[] puddle : puddles) {
            map[puddle[1]][puddle[0]] = 0;
        }
        
        // 맨 위, 맨 왼쪽 줄 1로 초기화 (물 만나면 그 뒤로부턴 0으로)
        map[1][1] = 1;
        for (int i=2; i<=n; i++) {
            if (map[i][1] == 0) continue;
            map[i][1] = map[i-1][1];
        }
        for (int j=2; j<=m; j++) {
            if (map[1][j] == 0) continue;
            map[1][j] = map[1][j-1];
        }
        
        // 계산
        for (int i=2; i<=n; i++) {
            for (int j=2; j<=m; j++) {
                if (map[i][j]==0) continue;
                map[i][j] = (map[i][j-1] + map[i-1][j]) % 1_000_000_007;
            }
        }
        
        return map[n][m] % 1_000_000_007;
    }
}
// 테스트 6 〉	통과 (0.77ms, 52.5MB)
