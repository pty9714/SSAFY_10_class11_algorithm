import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 	11956KB, 92ms
public class B2293 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int values[] = new int[n];
		for (int i = 0; i < n; i++) {
			values[i] = Integer.parseInt(br.readLine());
		}
		
		int dp[] = new int[k + 1];
		dp[0] = 1;
		for (int value : values) {
			for (int i = 1; i <= k; i++) {
				if(value <= i){
					dp[i] += dp[i-value];
				}
			}
		}
			
		bw.write(dp[k] + "");
		bw.flush();
		bw.close();
		br.close();
	}

}

/*
 dp
 -> 각 동전 가치 별로 누적해서 1~k까지 만들 수 있는 경우의 수 dp로 구함
 */
