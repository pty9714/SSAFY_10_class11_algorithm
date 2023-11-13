import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 117988KB, 716ms
public class B1806 {

	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static int weight[];
	
	static class Node implements Comparable<Node> {
		int index;
		int weight;
		public Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		weight = new int[V + 1];
		Arrays.fill(weight, Integer.MAX_VALUE);
		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v, w));
		}
		
		dijkstra(K); // 다익스트라 수행
		
		// 시작점에서 다른 모든 정점으로의 최단 경로 출력
		for (int i = 1; i <= V; i++) {
			if(weight[i] == Integer.MAX_VALUE) bw.write("INF\n");
			else bw.write(weight[i] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		weight[start] = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(weight[cur.index] < cur.weight) continue; // 방문 체크
			for (Node next : graph.get(cur.index)) {
				int nextWeight = weight[cur.index] + next.weight;
				if(nextWeight < weight[next.index]) {
					weight[next.index] = nextWeight;
					pq.offer(new Node(next.index, nextWeight));
				}
			}
		}
	}

}
