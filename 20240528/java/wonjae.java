import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int l;
    static int r;
    static int[][] world;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        world = new int[n+2][n+2];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=n; j++){
                world[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;

        while(true){
            int cnt = 0;
            visited = new boolean[n+2][n+2];
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(!visited[i][j]) {
                        BFS(i, j, world[i][j]);
                        cnt++;
                    }
                }
            }
            if(cnt == n*n) break;
            answer++;
        }
        System.out.println(answer);
    }

    static void BFS(int x, int y, int p){
        Queue<Country> record = new LinkedList<>();
        Queue<Country> queue = new LinkedList<>();

        queue.offer(new Country(x, y, p));
        Country curr;
        int sum = 0;
        int idx = 0;
        int nx, ny;
        visited[x][y] = true;
        while(!queue.isEmpty()){
            curr = queue.poll();
            idx++;
            sum+=curr.p;
            record.offer(curr);
            for(int i = 0; i < 4; i++){
                nx = curr.x + dx[i];
                ny = curr.y + dy[i];
                if(nx < 1 || nx > n || ny < 1 || ny > n || visited[nx][ny] || Math.abs(curr.p - world[nx][ny]) < l || Math.abs(curr.p - world[nx][ny]) > r) continue;
                visited[nx][ny] = true;
                queue.offer(new Country(nx,ny, world[nx][ny]));
            }
        }
        int avg = sum/idx;
        while (!record.isEmpty()){
            curr = record.poll();
            world[curr.x][curr.y] = avg;
        }

    }

    static class Country{
        int x;
        int y;
        int p;
        Country(int x, int y, int p){
            this.x = x;
            this.y = y;
            this.p = p;
        }
    }
}
