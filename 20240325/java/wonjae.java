import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2234 {

    static int[][] castle;
    static int[][] rooms;

    static int biggest = 0;
    static int two_room = 0;

    static int[] dx = {0, -1, 0, 1}; // 서북동남
    static int[] dy = {-1, 0, 1, 0};
    static int[] room_num = new int[2501];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        castle = new int[m+2][n+2];
        rooms = new int[m+2][n+2];


        for(int i = 0; i < m+2; i++){
            castle[i][0] = castle[i][n+1] = -1;
            rooms[i][0] = rooms[i][n+1] = -1;
        }
        for(int i = 0; i < n+2; i++){
            castle[0][i] = castle[m+1][i] = -1;
            rooms[0][i] = rooms[m+1][i] = -1;
        }

        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int room_cnt = 0;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(rooms[i][j] == 0){
                    BFS(new Point(i,j), ++room_cnt);
                }
            }
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 0; k < 4; k++){
                    if(rooms[i+dx[k]][j+dy[k]] != -1 && rooms[i][j] != rooms[i+dx[k]][j+dy[k]]){
                        two_room = Math.max(two_room, room_num[rooms[i][j]] + room_num[rooms[i+dx[k]][j+dy[k]]]);
                    }
                }
            }
        }

        System.out.println(room_cnt);
        System.out.println(biggest);
        System.out.println(two_room);
    }

    static void BFS(Point p, int k){
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        rooms[p.x][p.y] = k;

        int cnt = 0;

        Point curr = null;
        while (!q.isEmpty()){
            curr = q.poll();
            cnt++;
            for(int i = 0; i < 4; i++){
                if((castle[curr.x][curr.y] & (1 << i)) == 0 && rooms[curr.x+dx[i]][curr.y+dy[i]] == 0){
                    q.offer(new Point(curr.x+dx[i], curr.y+dy[i]));
                    rooms[curr.x+dx[i]][curr.y+dy[i]] = k;
                }
            }
        }
        biggest = Math.max(biggest, cnt);
        room_num[k] = cnt;
    }

}
