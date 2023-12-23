import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 21100KB, 188ms
public class B1967 {
	
	static class Node {
		int index;
		int weight;
		
		Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}
 	}
	
	public static int ans = 0, max = 0;
	public static ArrayList<ArrayList<Node>> tree = new ArrayList<ArrayList<Node>>();
	public static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= n; i++) {
			tree.add(new ArrayList<Node>());
		}
		
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			tree.get(parent).add(new Node(child, weight));
			tree.get(child).add(new Node(parent, weight));
		}
		
		// 루트 노드에서 길이 가장 긴 곳 찾기
		visited = new boolean[n+1];
		visited[1] = true;
		dfs(1, 0);
		// 가장 긴 곳에서 지름 찾기
		visited = new boolean[n+1];
		visited[max] = true;
		dfs(max, 0);
		
		bw.write(ans + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int index, int length) {
		if(length > ans) {
			ans = length;
			max = index;
		}
		for (Node node : tree.get(index)) {
			if(!visited[node.index]) {
				visited[node.index] = true;
				dfs(node.index, length + node.weight);
			}
		}
	}
}
/*
 dfs 문제
 모든 노드 dfs 했더니 2736ms
 -> 루트 노드에서 한 번 dfs 후에 가장 가중치 값이 큰 노드에서 다시 dfs
 */
