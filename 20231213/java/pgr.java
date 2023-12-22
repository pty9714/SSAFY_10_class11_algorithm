import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static int[][] board;
    static class BlockGroup {
        int x, y, color, cnt, rainbowCnt;

        public BlockGroup(int x, int y, int color, int cnt, int rainbowCnt) {
            this.x = x;
            this.y = y;
            this.color = color;
            this.cnt = cnt;
            this.rainbowCnt = rainbowCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        if (N == 1) {
            System.out.println(0);
            System.exit(0);
        }
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while (true) {
            BlockGroup maxGroup = findMaxGroup();
            if (maxGroup.cnt < 2) break;
            removeGroup(maxGroup);
            ans += maxGroup.cnt * maxGroup.cnt;
            gravity();
            rotate();
            gravity();
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static BlockGroup findMaxGroup() {
        BlockGroup maxGroup = new BlockGroup(0, 0, 0, 0, 0);
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && board[i][j] > 0) {
                    BlockGroup group = findGroup(i, j, board[i][j], visited);
                    if (maxGroup.cnt < group.cnt) {
                        maxGroup = group;
                    }
                    else if (maxGroup.cnt == group.cnt) {
                        if (maxGroup.rainbowCnt < group.rainbowCnt) {
                            maxGroup = group;
                        } else if (maxGroup.rainbowCnt == group.rainbowCnt) {
                            if (maxGroup.x < group.x) {
                                maxGroup = group;
                            } else if (maxGroup.x == group.x && maxGroup.y < group.y) {
                                maxGroup = group;
                            }
                        }
                    }
                    initRainbow(visited);
                }
            }
        }
        return maxGroup;
    }

    private static BlockGroup findGroup(int x, int y, int color, boolean[][] visited) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        int cnt = 1;
        int rainbowCnt = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] == color || board[nx][ny] == 0) {
                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    cnt++;
                    if (board[nx][ny] == 0) rainbowCnt++;
                }
            }
        }
        return new BlockGroup(x, y, color, cnt, rainbowCnt);
    }

    private static void initRainbow(boolean[][] visited) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) visited[i][j] = false;
            }
        }
    }

    private static void removeGroup(BlockGroup maxGroup) {
        int x = maxGroup.x;
        int y = maxGroup.y;
        int color = maxGroup.color;
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(x, y));
        boolean[][] visited = new boolean[N][N];
        board[x][y] = -2;
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] == color || board[nx][ny] == 0) {
                    q.offer(new Point(nx, ny));
                    board[nx][ny] = -2;
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void gravity() {
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] < 0) continue;
                int idx = i + 1;
                while(idx < N && board[idx][j] == -2) {
                    idx++;
                }
                if(idx - 1 != i) {
                    board[idx - 1][j] = board[i][j];
                    board[i][j] = -2;
                }
            }
        }
    }

    public static void rotate() {
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = temp[j][N - 1 - i];
            }
        }
    }
}
