import java.awt.*;
import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int N, L, R;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while (true) {
            int[][] B = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(B[i], -1);
            }
            int idx = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (B[i][j] == -1) {
                        bfs(i, j, idx, B);
                        idx++;
                    }
                }
            }
            if (idx == N * N) {
                break;
            }
            ans++;
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int i, int j, int idx, int[][] B) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(i, j));
        B[i][j] = idx;
        int total = A[i][j];
        int cnt = 1;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N ) {
                    continue;
                }
                if (B[nx][ny] != -1) {
                    continue;
                }
                if (L <= Math.abs(A[nx][ny] - A[p.x][p.y]) && Math.abs(A[nx][ny] - A[p.x][p.y]) <= R) {
                    q.add(new Point(nx, ny));
                    B[nx][ny] = idx;
                    total += A[nx][ny];
                    cnt++;
                }
            }
        }
        if (cnt == 1) {
            return;
        }
        int res = total / cnt;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (B[x][y] == idx) {
                    A[x][y] = res;
                }
            }
        }
    }
}
