import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 353416KB, 1940ms
public class B1647 {
	static class Home implements Comparable<Home> {
		int index;
		int C;
		Home(int index, int C) {
			this.index  = index;
			this.C = C;
		}

		@Override
		public int compareTo(Home o) {
			return this.C - o.C;
		}
	}
	public static int N, ans = 0;
	public static ArrayList<ArrayList<Home>>  map = new ArrayList<ArrayList<Home>>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			map.add(new ArrayList<Home>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			map.get(A).add(new Home(B, C));
			map.get(B).add(new Home(A, C));
		}

		mst();
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void mst() {
		PriorityQueue<Home> pq = new PriorityQueue<>();
		pq.offer(new Home(1, 0));
		int maxC = 0; // 유지비가 가장 큰 값을 저장한다.
		boolean[] visited = new boolean[N+1];
		while(!pq.isEmpty()) {
			Home cur = pq.poll();
			if(visited[cur.index]) continue;
			visited[cur.index] = true;
			ans += cur.C;
			maxC = Math.max(maxC, cur.C);
			for (Home next : map.get(cur.index)) {
				if(visited[next.index]) continue;
				pq.offer(new Home(next.index, next.C));
			}
		}
		ans -= maxC;
	}
}
/*
최소 간선 트리인 MST 2개 구하는 문제였음
간선 트리 중 가장 큰 유지비를 기준으로 분할하면됨
 */
