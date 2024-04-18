import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int seq[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = Integer.MAX_VALUE;
				
		int end = 0;
		int start = 0;
		int sum = 0;
		while(end < N) {
			sum += seq[end];
			if(sum >= S) {
				while(start <= end && sum - seq[start] >= S) {
					sum -= seq[start];
					start++;
				} 
				ans = Math.min(ans, end - start + 1);	
			}
			end++;
		}
		
		if(ans == Integer.MAX_VALUE) ans = 0;
		bw.write(ans + "");
		
		bw.flush();
		bw.close();
		br.close();

	}

}