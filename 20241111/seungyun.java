import java.util.*;
import java.io.*;
public class Main {

    static int n,m;
    static char[][] map;
    static int[] dx = {-1,1,0,0}; // 상하좌우
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j);
            }
        }

        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 'L'){
                    int a = bfs(i,j);
                    max = Math.max(max, a);
                }
            }
        }

        System.out.println(max);
    }

    static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] check = new int[n][m];

        visited[x][y] = true;
        q.add(new int[]{x,y});
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++){
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                    continue;
                }

                if(visited[nx][ny]){
                    continue;
                }

                if(map[nx][ny] == 'W'){
                    continue;
                }
                visited[nx][ny] = true;
                check[nx][ny] = check[nowX][nowY] + 1;
                q.add(new int[]{nx,ny});
            }
        }

        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                max = Math.max(max, check[i][j]);
            }
        }
//        System.out.print(max + " ");
        return max;

    }
}
