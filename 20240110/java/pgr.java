import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, cheeseCnt, time;
    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1)
                    cheeseCnt++;
            }
        }

        while(cheeseCnt != 0)
            melt();

        bw.write(time + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void melt(){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        int[][] air = new int[N][M];
        air[0][0] = -1;

        while(!q.isEmpty()){
            Point p = q.poll();
            for (int d = 0; d < 4; d++){
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (board[nx][ny] == 1) {
                    air[nx][ny]++;
                }
                if (board[nx][ny] == 0 && air[nx][ny] == 0){
                    q.offer(new Point(nx, ny));
                    air[nx][ny] = -1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (air[i][j] >= 2) {
                    cheeseCnt--;
                    board[i][j] = 0;
                }
            }
        }
        time++;
    }
}
