
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int time = Integer.parseInt(st.nextToken());
            map[start][end] = time;
        }

        for (int k = 0; k < N; k++) { // 경유지
            for (int i = 0; i < N; i++) { // 출발지
                if (i == k)
                    continue;
                for (int j = 0; j < N; j++) { // 도착지
                    if (i == j || k == j)
                        continue;
                    if (map[i][k] != 0 && map[k][j] != 0) {
                        if (map[i][j] == 0) {
                            map[i][j] = map[i][k] + map[k][j];
                        } else {
                            map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                        }
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (i == X - 1)
                continue;
            if (map[i][X - 1] != 0 && map[X - 1][i] != 0) {
                result = Math.max(result, map[i][X - 1] + map[X - 1][i]);
            }
        }
        System.out.println(result);

    }

}

// 플로이드 와샬 알고리즘
// 1. 출발지에서 도착지까지의 최단거리를 구하는 알고리즘
// 2. 3중 for문을 사용하여 출발지에서 도착지까지의 최단거리를 구한다.
// 3. 출발지에서 도착지까지의 최단거리를 구하는 과정에서 경유지를 거쳐가는 경우를 고려한다.
// 4. 경유지를 거쳐가는 경우와 거쳐가지 않는 경우를 비교하여 최단거리를 구한다.
// 5. 경유지를 거쳐가는 경우와 거쳐가지 않는 경우를 비교할 때, 거쳐가는 경우가 더 최단거리가 짧은 경우에만 최단거리를 갱신한다.
