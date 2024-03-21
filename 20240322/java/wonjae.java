import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B18224 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] maze;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        maze = new int[n+2][n+2];
        visited = new boolean[n+2][n+2][m*2];

        for(int i = 0; i <= n+1; i++){
            maze[0][i] = maze[n+1][i] = maze[i][0] = maze[i][n+1] = -1;
        }

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Pos> pq = new PriorityQueue<>((o1, o2)->o1.move-o2.move);
        pq.offer(new Pos(1, 1, 0));
        visited[1][1][0] = true;
        boolean arrived = false;

        Pos curr = null;
        while (!pq.isEmpty()){
            curr = pq.poll();
            if(curr.x == n && curr.y == n){
                arrived = true;
                break;
            }

            for(int i = 0; i < 4; i++){
                if(maze[curr.x+dx[i]][curr.y+dy[i]] == 0 && !visited[curr.x+dx[i]][curr.y+dy[i]][curr.move%(m*2)]){
                    visited[curr.x+dx[i]][curr.y+dy[i]][curr.move%(m*2)] = true;
                    pq.offer(new Pos(curr.x+dx[i], curr.y+dy[i], curr.move+1));
                }
                else if(maze[curr.x+dx[i]][curr.y+dy[i]] == 1 && curr.move%(m*2) >= m){
                    Pos jump = jump(curr.x+dx[i], curr.y+dy[i], i);
                    if(maze[jump.x][jump.y] == 0 && !visited[jump.x][jump.y][curr.move%(m*2)]){
                        visited[jump.x][jump.y][curr.move%(m*2)] = true;
                        pq.offer(new Pos(jump.x, jump.y, curr.move+1));
                    }
                }
            }
        }

        if(arrived) System.out.println(curr.move/(m*2)+1 + " " + (curr.move/m%2==0?"sun":"moon"));
        else System.out.println(-1);
    }

    static Pos jump(int x, int y, int dir){
        int cur_x = x + dx[dir];
        int cur_y = y + dy[dir];

        while(true){
            if(maze[cur_x][cur_y] == 1){
                cur_x += dx[dir];
                cur_y += dy[dir];
                continue;
            }
            return new Pos(cur_x, cur_y, -1);
        }

    }

    static class Pos{
        int x;
        int y;
        int move;

        Pos(int x, int y, int move){
           this.x = x;
           this.y = y;
           this.move = move;
        }
    }
}
