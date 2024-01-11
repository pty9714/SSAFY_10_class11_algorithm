import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 108772KB, 592ms
public class B2169 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] region = new int[N][M];
		int[][][] dp = new int[N+2][M+2][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				region[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 초기화 (음수가 있을 수도 있으므로 -최대 int로)
		for (int i = 0; i <= N + 1; i++) {
			for (int j = 0; j <= M + 1; j++) {
				dp[i][j][0] = -Integer.MAX_VALUE;
				dp[i][j][1] = -Integer.MAX_VALUE;
			}
		}
		// 첫째줄은 무조건 오른쪽으로만 이동
		dp[1][1][0] = region[0][0];
		dp[1][1][1] = region[0][0];
		for (int i = 2; i <= M; i++) {
			dp[1][i][0] = dp[1][i-1][0] + region[0][i-1];
			dp[1][i][1] = dp[1][i-1][1] + region[0][i-1];
		}
		// 오른쪽으로 이동한 경우 & 왼쪽으로 이동한 경우 max값 구하기
		for (int i = 2; i <= N; i++) {
			// 오른쪽으로 이동한 경우
			for (int j = 1; j <= M; j++) {
				dp[i][j][0] = Math.max(dp[i][j-1][0], Math.max(dp[i-1][j][0], dp[i-1][j][1])) + region[i-1][j-1];
			}
			// 왼쪽으로 이동한 경우
			for (int j = M; j >= 1; j--) {
				dp[i][j][1] = Math.max(dp[i][j+1][1], Math.max(dp[i-1][j][0], dp[i-1][j][1])) + region[i-1][j-1];
			}
		}
		bw.write(Math.max(dp[N][M][0], dp[N][M][1]) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
/*
dp
-> 방문한 곳은 다시 방문 못하기 때문에 한줄씩 오른쪽으로 이동한 경우, 왼쪽으로 이동한 경우와 각각 아래로 이동한 경우 max값 구함
*/