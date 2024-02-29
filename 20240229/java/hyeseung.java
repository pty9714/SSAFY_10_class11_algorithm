import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;

// 15660KB, 88ms
public class B13460 {
    static int ans = Integer.MAX_VALUE;
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];
        int redX = 0, redY = 0, blueX = 0, blueY = 0;
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
                if(board[i][j] == 'R') {
                    redX = i;
                    redY = j;
                }
                else if(board[i][j] == 'B') {
                    blueX = i;
                    blueY = j;
                }
            }
        }
        dfs(redX, redY, blueX, blueY, 0);
        bw.write((ans == Integer.MAX_VALUE ? -1 : ans) + "");
        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int redX, int redY, int blueX, int blueY, int cnt) {
        if(cnt > 10 || board[blueX][blueY] == 'O') {
            return;
        }
        if(board[redX][redY] == 'O') {
            ans = Math.min(ans, cnt);
            return;
        }
        for (int i = 0; i < 4; i++) {
            Point newRedPoint = move(redX, redY, i);
            Point newBluePoint = move(blueX, blueY, i);
            if(newRedPoint.x == newBluePoint.x && newRedPoint.y == newBluePoint.y && board[newRedPoint.x][newRedPoint.y] != 'O') {
                // 빨간 구슬이 먼저 오는 경우
                if(Math.abs(redX - newRedPoint.x) + Math.abs(redY - newRedPoint.y) < Math.abs(blueX - newBluePoint.x) + Math.abs(blueY - newBluePoint.y)) {
                    newBluePoint.x -= dx[i];
                    newBluePoint.y -= dy[i];
                }
                // 파란 구슬이 먼저 오는 경우
                else {
                    newRedPoint.x -= dx[i];
                    newRedPoint.y -= dy[i];
                }
            }
            if(!visited[newRedPoint.x][newRedPoint.y][newBluePoint.x][newBluePoint.y]) {
                visited[newRedPoint.x][newRedPoint.y][newBluePoint.x][newBluePoint.y] = true;
                dfs(newRedPoint.x, newRedPoint.y, newBluePoint.x, newBluePoint.y, cnt + 1);
                visited[newRedPoint.x][newRedPoint.y][newBluePoint.x][newBluePoint.y] = false;
            }
        }
    }

    private static Point move(int x, int y, int dir) {
        Point newPoint = new Point(x, y);
        while(board[newPoint.x][newPoint.y] != 'O' && board[newPoint.x + dx[dir]][newPoint.y + dy[dir]] != '#') {
            newPoint.x += dx[dir];
            newPoint.y += dy[dir];
        }
        return newPoint;
    }
}
