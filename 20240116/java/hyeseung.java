import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 12148KB, 112ms
public class B2294 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}		
		int[] dp = new int[k+1];
		Arrays.fill(dp, 10001);
		dp[0] = 0;
		for (int i = 1; i <= k; i++) {
			for (int coin : coins) {
				if(i >= coin)
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}
		bw.write((dp[k] == 10001 ? -1 : dp[k]) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
