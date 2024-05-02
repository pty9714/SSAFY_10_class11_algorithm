import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14712 {

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boolean[][] nemo = new boolean[n][m];

        System.out.println((1 << (n*m)) - dfs(nemo, 0));
    }

    static int dfs(boolean[][] nemo, int count){
        if(count == n*m) return 0;

        int nx = count/m;
        int ny = count%m;
        int answer = 0;

        nemo[nx][ny] = true;
        if(ny!=0 && count > m && nemo[nx-1][ny-1] && nemo[nx-1][ny] && nemo[nx][ny-1]){
            answer += 1 << ((n*m-1)-count);
        }
        else answer += dfs(nemo, count+1);

        nemo[nx][ny] = false;
        answer += dfs(nemo, count+1);

        return answer;
    }
}
