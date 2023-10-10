import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        int cnt = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cnt += 1;
                map[i][j] = cnt;
            }
        }
        Queue<Integer> q = new LinkedList();
        int[] answer = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            int[] query = queries[k];
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;
            int result = Integer.MAX_VALUE;
            for (int j = y1; j < y2; j++) {
                q.add(map[x1][j]);
                result = Math.min(result, map[x1][j]);
                // System.out.print(map[x1][j] + " ");
            }
            for (int i = x1; i < x2; i++) {
                q.add(map[i][y2]);
                result = Math.min(result, map[i][y2]);
                // System.out.print(map[i][y2] + " ");
            }
            for (int j = y2; j > y1; j--) {
                q.add(map[x2][j]);
                result = Math.min(result, map[x2][j]);
                // System.out.print(map[x2][j] + " ");
            }
            for (int i = x2; i > x1; i--) {
                q.add(map[i][y1]);
                result = Math.min(result, map[i][y1]);
                // System.out.print(map[i][y1] + " ");
            }
            // System.out.println();

            // q.add(q.poll());
            for (int j = y1 + 1; j <= y2; j++) {
                map[x1][j] = q.poll();
                // System.out.print(map[x1][j] + " ");
            }
            for (int i = x1 + 1; i <= x2; i++) {
                map[i][y2] = q.poll();
                // System.out.print(map[i][y2] + " ");
            }
            for (int j = y2 - 1; j >= y1; j--) {
                map[x2][j] = q.poll();
                // System.out.print(map[x2][j] + " ");
            }
            for (int i = x2 - 1; i >= x1; i--) {
                map[i][y1] = q.poll();
                // System.out.print(map[i][y1] + " ");
            }
            // System.out.println();
            answer[k] = result;
        }
        return answer;
    }
}

// q에 넣고 빼는 작업으로 헷갈리는걸 최소화
// 테스트 1 〉 통과 (0.21ms, 74.3MB)
// 테스트 2 〉 통과 (0.21ms, 75.9MB)
// 테스트 3 〉 통과 (69.23ms, 109MB)
// 테스트 4 〉 통과 (63.35ms, 105MB)
// 테스트 5 〉 통과 (57.05ms, 110MB)
// 테스트 6 〉 통과 (54.38ms, 116MB)
// 테스트 7 〉 통과 (60.95ms, 106MB)
// 테스트 8 〉 통과 (48.96ms, 100MB)
// 테스트 9 〉 통과 (69.07ms, 112MB)
// 테스트 10 〉 통과 (43.71ms, 111MB)
// 테스트 11 〉 통과 (43.80ms, 112MB)