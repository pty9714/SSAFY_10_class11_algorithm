import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] triangles = new int[122];
        int[] tetra = new int[122];
        int[] dp = new int[n+1];

        for(int i = 1; i < 122; i++){
            triangles[i] = triangles[i-1]+i;
        }

        for(int i = 1; i < 122; i++){
            tetra[i] = tetra[i-1]+triangles[i];
            if(tetra[i] > 300000) {
                break;
            }
        }

        for(int i = 1; i <= n; i++){
            dp[i] = 300001;
        }

        for(int i = 0; i < 122; i++){
            for(int j = tetra[i]; j <= n; j++){
                dp[j] = Math.min(dp[j],dp[j-tetra[i]]+1);
            }
        }

        System.out.println(dp[n]);
    }
}
