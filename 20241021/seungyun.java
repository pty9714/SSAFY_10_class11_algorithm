import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++) {
                map[i][j]=str.charAt(j)-'0';
            }
        }

        dfs(0,0);
        System.out.println(max);

    }

    static void dfs(int x, int y){
        if(x >= N){
            sum();
            return;
        }
        if(y >= M){
            dfs(x+1, 0);
            return;
        }

        visited[x][y] = true; // 가로
        dfs(x, y+1);
        visited[x][y] = false; // 세로
        dfs(x, y+1);
    }

    static void sum(){
        int result = 0;
        int tmp = 0;
        // 가로
        for(int i=0; i<N; i++){
            tmp = 0;
            for(int j=0; j<M; j++){
                if(visited[i][j] == true) {
                    tmp = tmp * 10;
                    tmp += map[i][j];
                } else{
                    result += tmp;
                    tmp = 0;
                }
            }
            result += tmp;
        }
        // 세로
        for(int i=0; i<M; i++){
            tmp = 0;
            for(int j=0; j<N; j++){
                if(visited[j][i] == false) {
                    tmp = tmp * 10;
                    tmp += map[j][i];
                } else{
                    result += tmp;
                    tmp = 0;
                }
            }
            result += tmp;
        }
        max = Math.max(max, result);
    }
}
