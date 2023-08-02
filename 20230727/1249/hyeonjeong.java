import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class S1249 {
    
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int min;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{

            min = Integer.MAX_VALUE;

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
                String[] s = br.readLine().split("");
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(s[j]);
                }
            }

            bfs(0, 0);
            System.out.printf("#%d %d%n", test_case, min);
		}
    }

    public static void bfs(int x, int y) {
        PriorityQueue<Pos> priorityQueue = new PriorityQueue<>(); 
        
        priorityQueue.add(new Pos(x, y, 0));
        visited[x][y] = true;

        while(!priorityQueue.isEmpty()) {
            Pos p = priorityQueue.poll();

            if(p.x == N-1 && p.x == N-1) {
                min = min > p.time ? p.time : min;
            }

            for(int k=0; k<4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if(nx<0 || nx>=N || ny<0 || ny>=N) continue;

                if(!visited[nx][ny]) {
                    int ntime = p.time + map[nx][ny];
                    priorityQueue.add(new Pos(nx, ny, ntime));
                    visited[nx][ny] = true;
                }
            }
            
        }

    }  

    public static class Pos implements Comparable<Pos> {
        int x, y;
        int time;

        Pos(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Pos o) {
            if(this.time < o.time) {
                return -1;
            } else if(this.time > o.time) {
                return 1;
            }
            return 0;
        }
    }
}
