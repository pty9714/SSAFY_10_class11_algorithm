import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11668KB, 84ms
public class B21317 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] energy = new int[N][2];
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			energy[i][0] = Integer.parseInt(st.nextToken());
			energy[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int K = Integer.parseInt(br.readLine());

		int dp[][] = new int[N+1][2];
		for (int i = 0; i <= N; i++) {
			dp[i][0] = 100000;
			dp[i][1] = 100000;
		}
		dp[1][0] = 0;
		if (N > 1) {
			dp[2][0] = energy[1][0];
			if (N > 2) {
				dp[3][0] = Math.min(energy[2][0] + dp[2][0], energy[1][1]);
			}
		}
		for (int i = 4; i <= N; i++) {
			dp[i][0] = Math.min(energy[i-1][0] + dp[i-1][0], energy[i-2][1] + dp[i-2][0]);
			dp[i][1] = Math.min(Math.min(energy[i-1][0] + dp[i-1][1], energy[i-2][1] + dp[i-2][1]), K + dp[i-3][0]);
		}
		
		bw.write(Math.min(dp[N][0], dp[N][1]) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
/*
 dp
 -> 매우 큰 점프한 경우, 매우 큰 점프 안한 경우로 나눠서 dp
 */