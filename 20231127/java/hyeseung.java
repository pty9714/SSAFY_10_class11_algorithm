import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

// 37856KB, 348ms
public class B2015 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long K = Integer.parseInt(st.nextToken());
		long ans = 0;
		
		long A[] = new long[N + 1];
		// 구간합 저장
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken()) + A[i - 1];
		}
		
		HashMap<Long, Long> hm = new HashMap<>();
		hm.put(0L, 1L);
		// 이전 구간합들 중 A[i] - K인 것 찾기
		for (int i = 1; i <= N; i++) {
			ans += hm.getOrDefault(A[i] - K, 0L);
			hm.put(A[i], hm.getOrDefault(A[i], 0L) + 1);
		}
		
		bw.write(ans + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
/*
 처음에는 0부터 i-1까지 누적합 빼면서 했는데 시간초과
 이후 해시맵 사용해서 이전 구간합들 저장
 */ 
