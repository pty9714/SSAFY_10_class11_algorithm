import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 44168KB, 780ms
public class B10776 {
	
	static class Info implements Comparable<Info> {
		int index;
		int t;
		int h;
		public Info(int index, int t, int h) {
			this.index = index;
			this.t = t;
			this.h = h;
		}
		
		@Override
		public int compareTo(Info o) {
			if(this.t == o.t) {
				return this.h - o.h; 
			}
			return this.t - o.t;
		}
	}
	
	public static int K, cost[][];
	public static ArrayList<ArrayList<Info>> oceanRoad;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		oceanRoad = new ArrayList<ArrayList<Info>>();
		cost = new int[N+1][K+1];
		for(int i = 0; i <= N; i++)
			Arrays.fill(cost[i], Integer.MAX_VALUE);

		for (int i = 0; i <= N; i++) {
			oceanRoad.add(new ArrayList<Info>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			oceanRoad.get(a).add(new Info(b, t, h));
			oceanRoad.get(b).add(new Info(a, t, h));
		}
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		dijkstra(A);
		int ans = Integer.MAX_VALUE;
		for (int temp : cost[B]) {
			ans = Math.min(ans, temp);
		}
		bw.write((ans == Integer.MAX_VALUE ? -1 : ans) + "");
		
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dijkstra(int start) {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.offer(new Info(start, 0, 0));
		cost[start][0] = 0;
		while(!pq.isEmpty()) {
			Info cur = pq.poll();
			if(cost[cur.index][cur.h] < cur.t) continue;
			for (Info info : oceanRoad.get(cur.index)) {
				int time = cur.t + info.t;
				int height = cur.h + info.h;
				if(height < K && time < cost[info.index][height]) {
					cost[info.index][height] = time;
					pq.offer(new Info(info.index, time, height));
				}
			}
		}
	}
}
