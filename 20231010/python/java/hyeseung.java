import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int matrix[][] = new int[n][m];

        // 물에 잠긴 곳
        for (int[] puddle : puddles) {
            matrix[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        // 집 (1, 1)
        matrix[0][0] = 1;

        // 최단 경로
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] != -1) {
                    // 물에 잠긴 곳이 아니면 아래로 이동 가능
                    if (i >= 1 && matrix[i - 1][j] != -1) {
                        matrix[i][j] += matrix[i - 1][j];
                    }

                    // 물에 잠긴 곳이 아니면 오른쪽으로 이동 가능
                    if (j >= 1 && matrix[i][j - 1] != -1) {
                        matrix[i][j] += matrix[i][j - 1];
                    }

                    // 최단경로의 개수 / 1000000007
                    matrix[i][j] %= 1000000007;
                }
            }
        }
        return matrix[n - 1][m - 1];
    }
}
/*
 * 테스트 1 〉 통과 (0.03ms, 78MB)
 * 테스트 2 〉 통과 (0.04ms, 72.8MB)
 * 테스트 3 〉 통과 (0.03ms, 74.4MB)
 * 테스트 4 〉 통과 (0.04ms, 76.3MB)
 * 테스트 5 〉 통과 (0.05ms, 73.3MB)
 * 테스트 6 〉 통과 (0.05ms, 72.5MB)
 * 테스트 7 〉 통과 (0.03ms, 75.4MB)
 * 테스트 8 〉 통과 (0.05ms, 75.1MB)
 * 테스트 9 〉 통과 (0.05ms, 76.7MB)
 * 테스트 10 〉 통과 (0.03ms, 77.3MB)
 * 효율성 테스트
 * 테스트 1 〉 통과 (0.73ms, 52.4MB)
 * 테스트 2 〉 통과 (0.45ms, 52.2MB)
 * 테스트 3 〉 통과 (0.57ms, 51.9MB)
 * 테스트 4 〉 통과 (0.52ms, 53.2MB)
 * 테스트 5 〉 통과 (0.64ms, 51.9MB)
 * 테스트 6 〉 통과 (1.00ms, 51.5MB)
 * 테스트 7 〉 통과 (0.59ms, 51.7MB)
 * 테스트 8 〉 통과 (0.61ms, 51.8MB)
 * 테스트 9 〉 통과 (0.56ms, 52.1MB)
 * 테스트 10 〉 통과 (2.48ms, 52.1MB)
 */