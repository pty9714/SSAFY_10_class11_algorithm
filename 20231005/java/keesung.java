
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        int[] airClean = new int[2];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    airClean[0] = i;
                    airClean[1] = j;
                }
            }

        }
        for (int i = 0; i < T; i++) {
            map = spread(map, R, C);
            // System.out.println("spread");
            // for (int j = 0; j < R; j++) {
            // for (int k = 0; k < C; k++) {
            // System.out.print(map[j][k] + " ");
            // }
            // System.out.println();
            // }
            // System.out.println("clean");
            clean(map, airClean, R, C);
            // for (int j = 0; j < R; j++) {
            // for (int k = 0; k < C; k++) {
            // System.out.print(map[j][k] + " ");
            // }
            // System.out.println();
            // }
            // System.out.println("==============");
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    continue;
                }
                answer += map[i][j];
            }
        }
        System.out.println(answer);

    }

    private static void clean(int[][] map, int[] airClean, int r, int c) {
        // 위쪽
        int x = airClean[0];
        int y = airClean[1];
        // 위로 이동
        while (x > 1) {
            x -= 1;
            map[x][y] = map[x - 1][y];
        }
        // 오른쪽으로 이동
        x = 0;
        while (y < c - 1) {
            y += 1;
            map[x][y - 1] = map[x][y];
        }
        // 아래로 이동
        y = c - 1;
        x = 0;
        while (x < airClean[0]) {
            map[x][y] = map[x + 1][y];
            x += 1;
        }

        // 왼쪽으로 이동
        x = airClean[0] - 1;
        while (y > 1) {
            y -= 1;
            map[x][y + 1] = map[x][y];
        }
        map[airClean[0] - 1][1] = 0;

        // 아래 순환
        x = airClean[0];
        y = airClean[1];
        // 아래로 이동
        while (x < r - 2) {
            x += 1;
            map[x][y] = map[x + 1][y];
        }
        // 오른쪽으로 이동
        x = r - 1;
        y = 1;
        while (y < c) {
            map[x][y - 1] = map[x][y];
            y += 1;
        }

        x = r - 2;
        y = c - 1;
        while (x >= airClean[0]) {
            map[x + 1][y] = map[x][y];
            x -= 1;
        }

        x = airClean[0];
        y = c - 1;
        while (y > 1) {
            map[x][y] = map[x][y - 1];
            y -= 1;
        }
        map[airClean[0]][1] = 0;

        map[airClean[0] - 1][airClean[1]] = -1;
        map[airClean[0]][airClean[1]] = -1;
    }

    private static int[][] spread(int[][] map, int r, int c) {
        int[][] temp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int munge = map[i][j];
                if (munge == -1) {
                    continue;
                }
                int spread = munge / 5;
                if (spread == 0) {
                    temp[i][j] += munge;
                    continue;
                }
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || nx >= r || ny < 0 || ny >= c || map[nx][ny] == -1) {
                        continue;
                    }
                    temp[nx][ny] += spread;
                    cnt += 1;
                }
                temp[i][j] += munge - (spread * cnt);
            }
        }

        return temp;
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