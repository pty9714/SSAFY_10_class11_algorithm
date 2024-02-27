import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        boolean[][] cities = new boolean[n][n];

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                cities[i][j] = st.nextToken().equals("1");
            }
            cities[i][i] = true;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    cities[j][k] = cities[j][k]|(cities[j][i]&cities[i][k]);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int curr = Integer.parseInt(st.nextToken()) - 1;

        boolean flag = true;

        for(int i = 1; i < m; i++){
            int next = Integer.parseInt(st.nextToken()) - 1;
            if(!cities[curr][next]){
                flag = false;
                break;
            }
            curr = next;
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
