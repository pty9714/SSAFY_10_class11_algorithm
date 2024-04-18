import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static boolean[][][] visited;
    static char[][] maze;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new char[n+2][m+2];
        visited = new boolean[n+2][m+2][1<<6];

        Node curr = null;

        for(int i = 1; i <= n; i++){
            String s = br.readLine();
            for(int j = 1; j <= m; j++){
                maze[i][j] = s.charAt(j-1);
                if(maze[i][j] == '0') curr = new Node(i, j, 0, 0);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2)->n1.dist-n2.dist);

        pq.offer(curr);
        if(curr!=null) visited[curr.x][curr.y][curr.key] = true;

        int answer = -1;

        while (!pq.isEmpty()){
            curr = pq.poll();
            if(maze[curr.x][curr.y] == '1') {
                answer = curr.dist;
                break;
            }
            for(int i = 0; i < 4; i++){
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if(nx > 0 && nx <= n && ny > 0 && ny <= m && !visited[nx][ny][curr.key] && maze[nx][ny]!='#'){
                    if(maze[nx][ny] >= 'A' && maze[nx][ny] <= 'F'){
                        if((curr.key & (1<<(maze[nx][ny] - 'A'))) == 0) continue;
                    }
                    if(maze[nx][ny] >= 'a' && maze[nx][ny] <= 'f') {
                        pq.offer(new Node(nx, ny, curr.key | (1<<(maze[nx][ny] - 'a')), curr.dist+1));
                        visited[nx][ny][curr.key | (1<<(maze[nx][ny] - 'a'))] = true;
                    }
                    else pq.offer(new Node(nx, ny, curr.key, curr.dist+1));
                    visited[nx][ny][curr.key] = true;
                }
            }
        }
        System.out.println(answer);
    }

    public static class Node{
        int x;
        int y;
        int key;
        int dist;
        Node(int x, int y, int key, int dist){
            this.x = x;
            this.y = y;
            this.key = key;
            this.dist = dist;
        }
    }
}
