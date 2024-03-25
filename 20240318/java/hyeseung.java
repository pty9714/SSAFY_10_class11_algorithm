import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 	33228KB,	180ms
public class Main {
    static int N, M, K;
    static int[][] map;
    static int[][] dice = {{0, 2, 0}, {4, 1, 3}, {0, 5, 0}, {0, 6, 0}};
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 동, 남, 서, 북
    static int d = 0;
    static int ans = 0;
    static int x = 0, y = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(K-- > 0) {
            moveDice();
            bfs();
            changeDir();
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int num = map[x][y];
        int cnt = 1;
        q.add(new Point(x, y));
        visited[x][y] = true;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int tempX = cur.x + dir[i][0];
                int tempY = cur.y + dir[i][1];
                if(tempX < 0 || tempX >= N || tempY < 0 || tempY >= M
                        || visited[tempX][tempY] || map[tempX][tempY] != num) continue;
                visited[tempX][tempY] = true;
                q.add(new Point(tempX, tempY));
                cnt++;
            }
        }
        ans += cnt * num;
    }

    public static void moveDice() {
        int tempX = x + dir[d][0];
        int tempY = y + dir[d][1];
        if(tempX < 0 || tempX >= N || tempY < 0 || tempY >= M) {
            d = (d+2) % 4;
        }
        int temp;
        switch (d) {
            case 0:
                temp = dice[1][2];
                dice[1][2] = dice[1][1];
                dice[1][1] = dice[1][0];
                dice[1][0] = dice[3][1];
                dice[3][1] = temp;
                break;
            case 1:
                temp = dice[3][1];
                dice[3][1] = dice[2][1];
                dice[2][1] = dice[1][1];
                dice[1][1] = dice[0][1];
                dice[0][1] = temp;
                break;
            case 2:
                temp = dice[1][0];
                dice[1][0] = dice[1][1];
                dice[1][1] = dice[1][2];
                dice[1][2] = dice[3][1];
                dice[3][1] = temp;
                break;
            case 3:
                temp = dice[0][1];
                dice[0][1] = dice[1][1];
                dice[1][1] = dice[2][1];
                dice[2][1] = dice[3][1];
                dice[3][1] = temp;
                break;
        }
        x += dir[d][0];
        y += dir[d][1];
    }

    public static void changeDir() {
        int under = dice[3][1];
        int num = map[x][y];
        if(under > num) {
            d = (d + 1) % 4;
        }
        else if(under < num) {
            d--;
            if(d < 0) d = 3;
        }
    }
}
