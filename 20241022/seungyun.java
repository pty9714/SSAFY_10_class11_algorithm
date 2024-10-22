import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int M,N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0}; // 상하좌우
    static int[] dy = {0,0,-1,1};
    static int count = 0;
    static int[][] dp;

    static ArrayList<Node>[] list;
    static class Node{
        int x,y,data;

        public Node(int x, int y, int data){
            this.x = x;
            this.y = y;
            this.data = data;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];
        // x,y 에서 도착점으로 가는 경로의 개수
        dp = new int[M][N];
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                dp[i][j] = -1;
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0,0));
    }

    static int dfs(int x, int y){
        // 기저조건
        if(x == M-1 && y == N-1){
            return 1;
        }

        if(dp[x][y] > -1){
            return dp[x][y];
        } else{
            dp[x][y] = 0;
            for(int i = 0; i < 4; i++){
                int nextX = dx[i] + x;
                int nextY = dy[i] + y;

                if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N){
                    continue;
                }

                if(visited[nextX][nextY]){
                    continue;
                }

                if(map[x][y] > map[nextX][nextY]){
                    dp[x][y] += dfs(nextX, nextY);
                }
            }
        }
        return dp[x][y];
    }
}
