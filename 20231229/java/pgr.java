import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] B;
    static int[][][] dp;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;
        int z;
        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        B = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                B[i][j] = row.charAt(j) - '0';
            }
        }
        dp = new int[N][M][2];

        bw.write(bfs(0, 0) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int i, int j) {
        Deque<Node> q = new ArrayDeque<>();
        q.add(new Node(i, j, 1));
        dp[i][j][1] = 1;
        while (!q.isEmpty()) {
            Node n = q.poll();
            if (n.x == N - 1 && n.y == M - 1) {
                return dp[n.x][n.y][n.z];
            }
            for (int d = 0; d < 4; d++) {
                int nx = n.x + dx[d];
                int ny = n.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (B[nx][ny] == 1 && n.z == 1) {
                    q.addFirst(new Node(nx, ny, 0));
                    dp[nx][ny][0] = dp[n.x][n.y][n.z] + 1;
                }
                if (B[nx][ny] == 0 && dp[nx][ny][n.z] == 0) {
                    q.add(new Node(nx, ny, n.z));
                    dp[nx][ny][n.z] = dp[n.x][n.y][n.z] + 1;
                }
            }
        }
        return -1;
    }

}
