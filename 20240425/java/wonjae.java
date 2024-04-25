import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B19238 {
    static int n;
    static int m;
    static int fuel;
    static int[][] field;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        field = new int[n+2][n+2];
        for(int i = 0; i <= n+1; i++){
            field[i][0] = field[i][n+1] = field[0][i] = field[n+1][i] = -1;
        }

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1) field[i][j] = -1;
                else field[i][j] = 0;
            }
        }

        st = new StringTokenizer(br.readLine());
        Point taxi = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        Point[] dest = new Point[m+1];
        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            field[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = i;
            dest[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int cnt = m;
        while(cnt > 0 && fuel > 0){
            Node passenger = getPassenger(taxi);
            if(passenger == null || passenger.d > fuel){
                fuel = -1;
                break;
            }

            taxi.x = passenger.x;
            taxi.y = passenger.y;

            fuel -= passenger.d;

            Point destination = dest[field[passenger.x][passenger.y]];

            int distance = getDistance(taxi, destination);
            if(distance < 0 || fuel < distance) {
                fuel = -1;
                break;
            }

            fuel += distance;
            field[passenger.x][passenger.y] = 0;

            taxi.x = destination.x;
            taxi.y = destination.y;

            cnt--;
        }

        System.out.println(fuel);
    }

    static int getDistance(Point taxi, Point destination){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Node> q = new LinkedList<>();

        boolean[][] visited = new boolean[n+2][n+2];

        visited[taxi.x][taxi.y] = true;
        q.offer(new Node(taxi.x, taxi.y, 0));

        Node curr = null;

        while(!q.isEmpty()){
            curr = q.poll();
            if(curr.x == destination.x && curr.y == destination.y){
                return curr.d;
            }

            for(int i = 0; i < 4; i++){
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if(nx > 0 && nx <= n && ny > 0 && ny <= n && !visited[nx][ny] && field[nx][ny]!=-1){
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, curr.d+1));
                }
            }
        }
        return -1;
    }

    static Node getPassenger(Point taxi){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        PriorityQueue<Node> q = new PriorityQueue<>();

        boolean[][] visited = new boolean[n+2][n+2];

        visited[taxi.x][taxi.y] = true;
        q.offer(new Node(taxi.x, taxi.y, 0));

        Node curr = null;

        while(!q.isEmpty()){
            curr = q.poll();
            if(field[curr.x][curr.y] > 0) return curr;

            for(int i = 0; i < 4; i++){
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if(nx > 0 && nx <= n && ny > 0 && ny <= n && !visited[nx][ny] && field[nx][ny]!=-1){
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, curr.d+1));
                }
            }

        }
        return null;
    }

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int d;
        Node(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            if(this.d != o.d) return this.d - o.d;
            if(this.x != o.x) return this.x - o.x;
            return this.y - o.y;
        }
    }
}
