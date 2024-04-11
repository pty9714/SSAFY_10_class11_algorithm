import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] paper = new int[101][101];

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            for(int j = sx; j <= ex; j++){
                for(int k = sy; k <= ey; k++){
                    paper[j][k]++;
                }
            }
        }

        int cnt = 0;

        for(int i = 1; i <= 100; i++){
            for(int j = 1; j <= 100; j++){
                if(paper[i][j] > m) cnt++;
            }
        }

        System.out.println(cnt);
    }
}
