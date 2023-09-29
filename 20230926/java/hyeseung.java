import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1107 {
	
	public static int answer = Integer.MAX_VALUE;
	public static int length;
	public static int N;
	public static boolean broken[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String temp = br.readLine();
		length = temp.length();
		N = Integer.parseInt(temp);
		int M = Integer.parseInt(br.readLine());
		broken = new boolean[10];
		if(M != 0) { // 고장난 버튼이 있을 경우
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) { // 고장난 버튼 true
				broken[Integer.parseInt(st.nextToken())] = true;
			}
			dfs(0, 0); // 재귀 수행
		}
		else answer = length; // 없으면 N의 길이가 정답
		if(Math.abs(N - 100) < answer) { // 시작 100번에서 + 또는 - 버튼 누르는 것이 더 최솟값이라면 그것이 정답
			answer = Math.abs(N - 100);
		}
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int number, int cnt) {
		if(cnt != 0 || !broken[0]) // 처음 number 0이 고장난 경우 제외
			answer = Math.min(answer, Math.abs(number - N) + String.valueOf(number).length()); // 최솟값일 경우 대체
		if(cnt == length + 1) return; // 최대 N의 자릿수 + 1자리까지 가능
		for (int i = 0; i < 10; i++) { // 0~9 번으로 이용한 숫자 버튼 이동
			if(broken[i]) continue; // 고장난 경우 제외
			dfs(number + (int) Math.pow(10, cnt) * i, cnt + 1); // 재귀
		}
	}

}
// 97844KB, 328ms