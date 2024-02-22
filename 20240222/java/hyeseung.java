import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, cost[][], INF = 1000 * 1000 + 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		int answer = Integer.MAX_VALUE;
		
		// 입력 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {				
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1번 집이 각각 R, G, B일 때 최솟값 구하기
		for(int i = 0; i < 3; i++) {
			answer = Math.min(answer, getMin(i));
		}
		
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int getMin(int index) {
		// index 값
		// 0 : 1번집 빨간 색(R)
		// 1 : 1번집 초록 색(G)
		// 2 : 1번집 파란 색(B)
		int dp[][] = new int[N][3];
		// 1번집이 index에 해당하는 색일 경우 해당 인덱스 제외 무한대로 처리하여 최솟값으로 가질 수 없도록 함.
		for (int i = 0; i < 3; i++) {
			if(i == index) {
				dp[0][i] = cost[0][i];
			}
			else {
				dp[0][i] = INF;
			}
		}
		// dp[i][j] : i-1번째 집에서 j에 해당하는 색 아닐 경우의 최소 비용 + i번째 집에서 j에 해당하는 색 비용
		for (int i = 1; i < N; i++) {
			dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
			dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
			dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
		}
		// 1번집이 index에 해당하는 색일 경우 N번집은 index에 해당하는 색은 될 수 없으므로 무한대
		dp[N-1][index] = INF;
		
		return Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
		
	}

}