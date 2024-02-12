import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15684 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][] ladder = new int[h+1][n+1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = 1;
            ladder[a][b+1] = 2;
        }

        int ans = 4;
        for(int i = 0; i < 4; i++){
            if(go(ladder, 0, 0, i, n, h)){
                ans = i;
                break;
            }
        }

        if(ans >= 4){
            ans = -1;
        }
        System.out.println(ans);
    }

    public static boolean go(int[][] ladder, int x, int y, int cnt, int n, int h){
        if(cnt == 0){
            for(int i = 1; i <= n; i++){
                int k = i;
                for(int j = 1; j <= h; j++){
                    if(ladder[j][k] == 1){
                        k++;
                    }else if(ladder[j][k] == 2){
                        k--;
                    }
                }
                if(k != i){
                    return false;
                }
            }
            return true;
        }

        for(int i = x; i <= h; i++){
            for(int j = 1; j < n; j++){
                if(ladder[i][j] != 0 || ladder[i][j+1] != 0){
                    continue;
                }
                ladder[i][j] = 1;
                ladder[i][j+1] = 2;
                int nx = i;
                int ny = j+1;
                if(ny >= n){
                    nx += 1;
                    ny = 1;
                }
                if(go(ladder, nx, ny, cnt-1, n, h)){
                    return true;
                }
                ladder[i][j] = 0;
                ladder[i][j+1] = 0;
            }
        }
        return false;
    }
}
