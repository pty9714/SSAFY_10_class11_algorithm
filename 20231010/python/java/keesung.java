class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        map[0][0] = 1;
        int[] dx = { -1, 0 };
        int[] dy = { 0, -1 };
        for (int[] tmp : puddles) {
            int y = tmp[0];
            int x = tmp[1];
            map[x - 1][y - 1] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1) {
                    continue;
                }
                for (int k = 0; k < 2; k++) {
                    int nx = dx[k] + i;
                    int ny = dy[k] + j;
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (map[nx][ny] == -1) {
                            continue;
                        }
                        map[i][j] += map[nx][ny];
                    }
                }
                map[i][j] %= 1000000007;
                // System.out.println("==========");
            }
        }

        // for (int[] arr : map) {
        // for (int num : arr) {
        // System.out.print(num + " ");
        // }
        // System.out.println();
        // }
        int answer = map[n - 1][m - 1];
        return answer;
    }
}

// DP 기본
// 정확성 테스트
// 테스트 1 〉 통과 (0.02ms, 73.2MB)
// 테스트 2 〉 통과 (0.04ms, 78.1MB)
// 테스트 3 〉 통과 (0.03ms, 73.7MB)
// 테스트 4 〉 통과 (0.04ms, 71.7MB)
// 테스트 5 〉 통과 (0.04ms, 72.4MB)
// 테스트 6 〉 통과 (0.06ms, 74.3MB)
// 테스트 7 〉 통과 (0.07ms, 75.3MB)
// 테스트 8 〉 통과 (0.10ms, 76.3MB)
// 테스트 9 〉 통과 (0.05ms, 73MB)
// 테스트 10 〉 통과 (0.03ms, 78.3MB)
// 효율성 테스트
// 테스트 1 〉 통과 (1.09ms, 52.5MB)
// 테스트 2 〉 통과 (0.85ms, 60.1MB)
// 테스트 3 〉 통과 (0.94ms, 52.8MB)
// 테스트 4 〉 통과 (0.81ms, 52.4MB)
// 테스트 5 〉 통과 (1.11ms, 53.2MB)
// 테스트 6 〉 통과 (1.78ms, 69.1MB)
// 테스트 7 〉 통과 (0.96ms, 51.4MB)
// 테스트 8 〉 통과 (1.11ms, 52MB)
// 테스트 9 〉 통과 (1.41ms, 52.1MB)
// 테스트 10 〉 통과 (1.53ms, 52MB)