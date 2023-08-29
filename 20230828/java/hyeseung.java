import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S15231_바이너리트리_신혜승 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			// 노드 v와 루트까지의 간선 개수와 이진 트리의 높이
			ans = (int) (Math.log(V) / Math.log(2)) + (int) (Math.log(N) / Math.log(2));
			// 부모가 2인 서브트리인지 3인 서브트리인지 구함
			while(V > 3) V /= 2;
			while(N > 3) N /= 2;
			if(V == 2) {
				if(N == 2) {
					ans--;
				}
			}
			
			bw.write("#" + test_case + " " + ans + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}

// 68,020 kb, 290 ms