import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 22604KB, 224ms	
public class B1806 {

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
			
		// 투포인터
		int end = 0;
		int start = 0;
		int sum = 0; // 부분합
		while(end < N) {
			sum += seq[end];
			// 부분합 S 이상 되는 것 중 가장 짧은 것 찾기 위해 시작 위치 옮김
			if(sum >= S) {
				while(start <= end && sum - seq[start] >= S) {
					sum -= seq[start];
					start++;
				} 
				// 가장 짧은 것으로 update
				ans = Math.min(ans, end - start + 1);	
			}
			end++;
		}
		
		// 값이 없을 경우 0 출력
		if(ans == Integer.MAX_VALUE) ans = 0;
		// 결과 출력
		bw.write(ans + "");
		
		bw.flush();
		bw.close();
		br.close();

	}

}
