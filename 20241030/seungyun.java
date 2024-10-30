import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] finished;
    static int[] dx = {-1,1,0,0}; // 상하좌우
    static int[] dy = {0,0,-1,1};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        finished = new boolean[N][M];
        cnt = 0;

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j);
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!finished[i][j]){
                    cnt += dfs(i,j);
                }
            }
        }
        System.out.println(cnt);
    }

    // 루프가 도는지 체크하는 메서드
    // 루프가 돈다면 세이프 존 1개 추가
    static int dfs(int x, int y){
        if(finished[x][y]){
            return 1;
        }
        finished[x][y] = true;

        int result = 0;
        char dir = map[x][y];
        int nx = 0;
        int ny = 0;
//        System.out.println(x + " " + y);
        // 좌표 변경
        if(dir == 'D'){
            nx = x+1;
            ny = y;
        } else if(dir == 'U'){
            nx = x-1;
            ny = y;
        } else if(dir == 'L'){
            nx = x;
            ny = y-1;
        } else if(dir == 'R'){
            nx = x;
            ny = y+1;
        }

        // 다음이 방문했다면 루틴
        if(visited[nx][ny]){
            visited[x][y] = true;
            return 0;
        }

        result += dfs(nx,ny);
        visited[x][y] = true;

        return result;
    }
}
