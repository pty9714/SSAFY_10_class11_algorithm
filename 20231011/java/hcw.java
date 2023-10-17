import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] arr = new int[n + 1];
			int[] dp = new int[n+1];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i < n + 1; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				dp[i] = arr[i];
			}
			int[][] fromto = new int[k][2];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				fromto[i][0] = from;
				fromto[i][1] = to;
			}
			Arrays.sort(fromto, (el1, el2) -> {
				if(el1[0] == el2[0]) return el1[1] - el2[1];
				return el1[0] - el2[0];
			});
			
			for (int i = 0; i < k; i++) {
				dp[fromto[i][1]] = Math.max(dp[fromto[i][1]], arr[fromto[i][1]] + dp[fromto[i][0]]);
			}
			
			
			int result = Integer.parseInt(br.readLine());
			System.out.println(dp[result]);
			

		}

	}

}
