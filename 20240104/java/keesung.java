
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K + 1];
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            int num = arr[i];
            for (int j = 1; j <= K; j++) {
                if (j - num >= 0) {
                    dp[j] += dp[j - num];
                }
            }
        }

        System.out.println(dp[K]);

    }

}

// 동전 그냥 하나씩 더하면서 dp