import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

// 90644KB, 664ms
public class B1208 {
	
	public static int N, S, seq[];
	public static HashMap<Integer, Integer> subSeqSum = new HashMap<Integer, Integer>();
	public static long ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		seq = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		leftSum(0, 0);
		rightSum(N/2, 0);
		
		if(S == 0) ans--; // 0일 경우 아무것도 포함 안된 것이 있기 때문에 0 빼주기
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void leftSum(int index, int sum) {
		if(index == N/2) {
			subSeqSum.put(sum, subSeqSum.getOrDefault(sum, 0) + 1);
			return;
		}
		// 포함 X
		leftSum(index + 1, sum);
		// 포함 O
		leftSum(index + 1, sum + seq[index]);
	}
	public static void rightSum(int index, int sum) {
		if(index == N) {
			ans += subSeqSum.getOrDefault(S - sum, 0);
			return;
		}
		// 포함 X
		rightSum(index + 1, sum);
		// 포함 O
		rightSum(index + 1, sum + seq[index]);
	}

}
/*
 배열을 반으로 나누어 dfs로 왼쪽 부분 배열 합을 모두 구해 해시맵에 넣은 후 
 오른쪽 부분 배열 합을 구해 S에서 뺀 것 중 해시맵에 있는 것 만큼 개수로 더한다.
 */
