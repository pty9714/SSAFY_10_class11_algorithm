import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 13428KB, 120ms
public class B1245 {
    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int N;
    private static int M;
    private static int[][] matrix;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && countPeak(i, j)) {
                    ans++;
                }
            }
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
    private static boolean countPeak(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        boolean isPeak = true;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 8; i++) {
                int tempX = cur.x + dx[i];
                int tempY = cur.y + dy[i];
                if(tempX < 0 || tempX >= N || tempY < 0 || tempY >= M) continue;
                if(matrix[tempX][tempY] > matrix[cur.x][cur.y]) isPeak = false;
                if(matrix[tempX][tempY] != matrix[cur.x][cur.y]) continue;
                if(visited[tempX][tempY]) continue;
                visited[tempX][tempY] = true;
                q.offer(new Point(tempX, tempY));
            }
        }
        return isPeak;
    }
}
