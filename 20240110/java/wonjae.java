import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2638 {

    static int n,m;
    static int[][] paper;
    static int[][] visited;
    static Queue<Point> melt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paper = new int[n+2][m+2];

        for(int i = 0; i < n+2; i++){
            paper[i][0] = paper[i][m+1] = -1;
        }
        for(int i = 0; i < m+2; i++){
            paper[0][i] = paper[n+1][i] = -1;
        }
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        while(true){
            visited = new int[n+2][m+2];
            melt = new LinkedList<>();

            for(int i = 1; i < n+1; i++){
                if(visited[i][1] == 0){
                    BFS(i,1);
                }
                if(visited[i][m] == 0){
                    BFS(i, m);
                }
            }
            for(int i = 1; i < m+1; i++){
                if(visited[1][i] == 0){
                    BFS(1, i);
                }
                if(visited[n][i] == 0){
                    BFS(n, i);
                }
            }
            if(melt.isEmpty()) break;
            for(Point p : melt){
                paper[p.x][p.y] = 0;
            }
            cnt++;
        }
        System.out.println(cnt);

    }

    static void BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        Point curr;
        q.offer(new Point(x, y));
        visited[x][y] = 1;
        int nx, ny;
        while (!q.isEmpty()){
            curr = q.poll();
            for(int i = 0 ; i < 4; i++){
                nx = curr.x+dx[i];
                ny = curr.y+dy[i];
                if(paper[nx][ny] == 1){
                    visited[nx][ny]++;
                    if(visited[nx][ny] == 2) melt.offer(new Point(nx,ny));
                }
                if(visited[nx][ny] == 0 && paper[nx][ny] == 0) {
                    visited[nx][ny]++;
                    q.offer(new Point(nx,ny));
                }
            }

        }


    }
}
/*
  43440KB	228ms
*/
