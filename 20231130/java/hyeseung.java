import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 31684KB, 304ms
public class B2470 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long sum = Long.MAX_VALUE;
		long[] ans = new long[2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long[] solution = new long[N];
		
		for (int i = 0; i < N; i++) {
			solution[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(solution);
		
		int alkali = 0;
		int acid = N - 1;
		
		while(alkali < N && acid >= 0 && alkali != acid) {
			if(Math.abs(solution[acid] + solution[alkali]) < Math.abs(sum)) {
				sum = solution[acid] + solution[alkali];
				ans[0] = solution[alkali];
				ans[1] = solution[acid];
			}
			if(solution[acid] + solution[alkali] < 0) alkali++;
			else acid--;
		}
		
		Arrays.sort(ans);
		bw.write(ans[0] + " " + ans[1]);
		
		bw.flush();
		bw.close();
		br.close();
	}

}
/*
처음에 용액이 모두 알칼리일 경우, 산성일 경우 안따짐
 */
