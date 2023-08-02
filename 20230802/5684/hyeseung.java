import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class S5684 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		int INF = (int) 1e9;
		for(int test_case = 1; test_case <= T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] graph = new int[N + 1][N + 1];
			
			for(int[] g : graph) {
				Arrays.fill(g, INF);
			}
			
			// 모든 길 정보 입력 받기
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int distance = Integer.parseInt(st.nextToken());
				graph[A][B] = distance;
			}
			
			// 플로이드 워셜 알고리즘
			for(int k = 1; k <= N; k++) {
				for(int a = 1; a <= N; a++) {
					for(int b = 1; b <= N; b++) {
						graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
					}
				}
			}
			int ans = INF;
			for(int i = 1; i <= N; i++) {
				ans = Math.min(ans, graph[i][i]);
			}
			
			if(ans == INF) ans = -1;
			bw.write("#" + test_case + " " + ans + "\n");
			
		}
		bw.close();
	}

}
