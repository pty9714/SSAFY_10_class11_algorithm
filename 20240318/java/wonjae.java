import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B23288 {

    static int[] dx = {0, 1, 0, -1}; // 동, 남, 서, 북
    static int[] dy = {1, 0, -1, 0};
    static int[] dice = {1, 2, 3, 4, 5, 6};
    static int[][] map;
    static Point curr = new Point(1, 1);
    static int[][] score;
    /*
            2
        4   1   3
            5
            6
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());



        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n+2][m+2];
        score = new int[n+2][m+2];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        int dice_dir = 0;

        for(int i = 0; i < k; i++){
            if(map[curr.x+dx[dice_dir]][curr.y+dy[dice_dir]] == 0) dice_dir=(dice_dir+2)%4;

            curr.x+=dx[dice_dir];
            curr.y+=dy[dice_dir];
            roll(dice_dir);

            if(score[curr.x][curr.y] == 0){
                bfs();
            }

            answer += score[curr.x][curr.y];

            if(dice[5] > map[curr.x][curr.y]) dice_dir=(dice_dir+1)%4;
            else if(dice[5] < map[curr.x][curr.y]) dice_dir=(dice_dir+3)%4;
        }

        System.out.println(answer);
    }

    public static void bfs(){
        int x = curr.x;
        int y = curr.y;

        Queue<Point> q = new LinkedList<>();
        ArrayList<Point> al = new ArrayList<>();
        al.add(new Point(x, y));
        q.offer(new Point(x, y));
        int num = map[x][y];
        score[x][y] = -1;
        Point p;
        while (!q.isEmpty()){
            p = q.poll();
            for(int i = 0; i < 4; i++){
                if(map[p.x+dx[i]][p.y+dy[i]] == num && score[p.x+dx[i]][p.y+dy[i]] == 0){
                    score[p.x+dx[i]][p.y+dy[i]] = -1;
                    q.offer(new Point(p.x+dx[i], p.y+dy[i]));
                    al.add(new Point(p.x+dx[i], p.y+dy[i]));
                }
            }
        };

        for(Point pi : al){
            score[pi.x][pi.y] = al.size()*num;
        }

    }

    public static void roll(int dir){
        int temp = 0;
        switch (dir){
            case 0: // 동
                temp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[2];
                dice[2] = temp;
                break;
            case 1: // 남
                temp = dice[0];
                dice[0] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[4];
                dice[4] = temp;
                break;
            case 2: // 서
                temp = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[3];
                dice[3] = temp;
                break;
            case 3: // 북
                temp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp;
                break;
            default:
                break;
        }
    }
}
