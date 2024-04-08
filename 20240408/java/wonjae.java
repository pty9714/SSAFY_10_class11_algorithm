import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1245 {
    static int n, m;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1}; //상하좌우
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] mountain;
    static boolean[][] visited;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        mountain = new int[n+2][m+2];
        visited = new boolean[n+2][m+2];

        for(int i = 0; i < n+2; i++){
            mountain[i][0] = mountain[i][m+1] = -1;
        }
        for (int i = 0; i < m+2; i++){
            mountain[0][i] = mountain[n+1][i] = -1;
        }

        for(int i = 1; i < n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < m+1; j++){
                mountain[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(!visited[i][j]) bfs(i,j);
            }
        }
        System.out.println(cnt);

    }

    static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();

        boolean flag = false;
        q.offer(new Point(x, y));
        visited[x][y] = true;
        Point curr;
        int curr_height = mountain[x][y];

        while (!q.isEmpty()){
            curr = q.poll();
            for(int i = 0; i < 8; i++){
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if(nx > 0 && nx < n+2 && ny > 0 && ny < m+2){
                    if(curr_height < mountain[nx][ny]){
                        flag = true;
                    }
                    else if(curr_height == mountain[nx][ny]){
                        if(!visited[nx][ny]){
                            visited[nx][ny] = true;
                            q.offer(new Point(nx, ny));
                        }
                    }

                }
            }
        }

        if(!flag) cnt++;
    }
}
