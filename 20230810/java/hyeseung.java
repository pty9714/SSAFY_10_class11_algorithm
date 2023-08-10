import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S1491 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			long ans = Long.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			long A = Integer.parseInt(st.nextToken());
			long B = Integer.parseInt(st.nextToken());
			
			for(int R = 1; R <= N; R++) {
				for(int C = N / R; C > 0; C--) {
					long weight = A * Math.abs(R - C) + B * (N - R * C);
					if(weight >= 0)
						ans = Math.min(ans, weight);
				}
			}
			
			bw.write("#" + test_case + " " + ans + "\n");
		}
		
		bw.close();
	}

}
// 실행 시간 : 0.43824s