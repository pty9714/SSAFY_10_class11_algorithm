import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
// 	11696KB, 84ms
public class B14501 {
	
	public static int N, answer, consult[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		consult = new int[N][2];
		answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			consult[i][0] = Integer.parseInt(st.nextToken());
			consult[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		
		bw.write(answer + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int index, int benefit) {
		answer = Math.max(answer, benefit);	
		for (int i = index; i < N; i++) {
			int nextDay = i + consult[i][0];
			if(nextDay <= N) {
				dfs(nextDay, benefit + consult[i][1]);
			}
		}
	}

}
