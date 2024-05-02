import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class B14712 {

    static int n,m;
    static boolean[][] visited;
    static int cnt;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        dfs(0,0);
        System.out.println(cnt);
    }

    // 전체 탐색
    static void dfs(int start, int depth){
        if(check(depth)){
            cnt++;
        }
        // 기저조건
        if(depth == n*m){
            return;
        }

        for(int i=start; i<n*m; i++){
            int x = i/m;
            int y = i%m;
//            System.out.println(x + " " + y);
            if(visited[x][y] == true){
                continue;
            }

            visited[x][y] = true;
            dfs(i+1, depth+1);
            visited[x][y] = false;

        }
    }

    static boolean check(int depth) {
        if(depth < 4){
            return true;
        }
        // 4개면 false
        for(int i=0;i<n-1;i++)
            for(int j=0;j<m-1;j++)
                if(visited[i][j] && visited[i][j + 1] && visited[i + 1][j] && visited[i + 1][j + 1]){
                    return false;
                }
        return true;
    }

}
