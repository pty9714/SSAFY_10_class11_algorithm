import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 14168KB, 148ms
public class B2617 {
	
	public static boolean visited[]; // 방문 확인

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int mid = (N+1)/2; // 무게가 전체의 중간인 것의 인덱스
		
		// 무거운 구슬, 가벼운 구슬 그래프
		ArrayList<ArrayList<Integer>> heavy = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> light = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= N; i++) {
			heavy.add(new ArrayList<Integer>());
			light.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			heavy.get(temp1).add(temp2);
			light.get(temp2).add(temp1);
		}
		
		// 무게가 중간이 될 가능성이 전혀 없는 구슬들을 먼저 제외함
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			if(dfs(heavy, i) > mid) { // 자신 포함 자신보다 가벼운 구슬 개수가  mid개보다 크면 가능성 없음
				ans++;
			}
			else {
				visited = new boolean[N+1];
				if(dfs(light, i) > mid) { // 자신 포함 자신보다 무거운 구슬 개수가  mid개보다 크면 가능성 없음
					ans++;
				}
			}
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int dfs(ArrayList<ArrayList<Integer>> graph, int marble) {
		visited[marble] = true;
		int cnt = 1;
		for (int node : graph.get(marble)) {
			if(!visited[node]) cnt += dfs(graph, node); // 방문하지 않은 노드들 중 가볍거나 무거운 노드들의 개수
		}
		return cnt;
	}
}
/*
 dfs로 자신 포함 자신보다 가벼운 구슬 개수, 무거운 구슬 개수 각각 구해서 mid보다 큰지 각각 체크함
 */
