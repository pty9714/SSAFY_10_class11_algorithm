import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

// 24196KB, 148ms
public class B1039 {
	
	public static int ans, M, K;
	public static ArrayList<HashSet<String>> delete = new ArrayList<HashSet<String>>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = String.valueOf(N).length(); // 자릿수
		K = Integer.parseInt(st.nextToken());
		ans = -1;
		
		// 중복 제거를 위한 HashSet (같은 연산 횟수에서 위치를 바꾼 결과가 같은 것이 있으면 dfs X)
		// 안하면 메모리 초과
		for (int i = 0; i < K; i++) {
			delete.add(new HashSet<String>()); 
		}
		
		dfs(String.valueOf(N), 0);
		bw.write(ans + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(String number, int cnt) {
		if(cnt == K) { // 연산횟수가 K면 최댓값 반환
			ans = Math.max(ans, Integer.parseInt(number));
			return;
		}
		
		for (int digit1 = 0; digit1 < M; digit1++) {
			for (int digit2 = digit1 + 1; digit2 < M; digit2++) {
				char i = number.charAt(digit1); 
				char j = number.charAt(digit2);
				// i번 위치의 숫자와 j번 위치의 숫자 바꾼 결과
				String res = number.substring(0, digit1) + j + number.substring(digit1 + 1, digit2) + i + number.substring(digit2 + 1, M);
				if(res.charAt(0) == '0') continue; // 0으로 시작하면 안됨
				if(delete.get(cnt).contains(res)) continue; // 위치를 바꾼 숫자가 같은 연산횟수에서 있었을 경우 pass
				delete.get(cnt).add(res); // 없으면 추가
				dfs(res, cnt + 1);				
			}
		}
	}
}
