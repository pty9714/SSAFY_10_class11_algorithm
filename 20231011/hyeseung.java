import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 307788KB, 2304ms
public class B1005 {
	
	public static int N, W;
	public static HashSet<Integer> startIndex = new HashSet<Integer>();
	public static ArrayList<ArrayList<Integer>> buildings = new ArrayList<ArrayList<Integer>>();
	public static ArrayList<ArrayList<Integer>> revBuildings = new ArrayList<ArrayList<Integer>>();
	public static Queue<Integer> q = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 건물의 개수, 건물간의 건설순서 규칙 총 개수
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			// 각 건물당 건설에 걸리는 시간
			int time[] = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			// 건설 순서
			buildings.clear(); revBuildings.clear(); 
			for (int i = 0; i <= N; i++) {
				buildings.add(new ArrayList<>());
				revBuildings.add(new ArrayList<>());
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				buildings.get(X).add(Y);
				revBuildings.get(Y).add(X); // 역순 (시작 빌딩 구하기 위함)
			}
			// 백준이가 승리하기 위해 건설해야 할 건물 번호
			W = Integer.parseInt(br.readLine());
			
			// 결과 출력
			getStartIndex();
			int ans = 0;
			for (int i : startIndex) {
				ans = Math.max(ans, bfs(i, time));
			}

			bw.write(ans + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 시작 인덱스 구하기
	public static void getStartIndex() {
		startIndex.clear(); 
		q.clear();
		q.offer(W);
		boolean visited[] = new boolean[N + 1];
		visited[W] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			int cnt = 0;
			for (int i : revBuildings.get(cur)) {
				if(i == cur) continue;
				cnt++;
				if(!visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
			if(cnt == 0) startIndex.add(cur);
		}
	}
	
	public static int bfs(int start, int[] time) {
		q.clear();
		q.offer(start);
		int total[] = new int[N + 1];
		total[start] = time[start];
		int res = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == W) {
				res = Math.max(res, total[cur]);
				continue;
			}
			for (int next : buildings.get(cur)) {
				if(total[next] < total[cur] + time[next]) {
					total[next] = Math.max(total[next], total[cur] + time[next]);
					q.offer(next);
				}
			}
		}
		return res;
	}

}
