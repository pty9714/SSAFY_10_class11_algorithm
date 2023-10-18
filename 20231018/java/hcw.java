import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int[] visited;
	static int[] cycle;
	static int count;

	private static void dfs(int current) {
		visited[current] = 1;
		int next = arr[current];
		if(visited[next] == 0) {
			dfs(next);
		}else {
			if(cycle[next] == 0) {
				count++;
				while(next != current) {
					count++;
					next = arr[next];
				}
			}
		}
		cycle[current] = 1;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int num = Integer.parseInt(br.readLine());
			arr = new int[num + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i < num + 1; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			cycle = new int[num + 1];
			visited = new int[num + 1];
			count = 0;
			for (int i = 1; i < num + 1; i++) {
				dfs(i);
			}

			sb.append((num - count) + "\n");
		}
		System.out.println(sb);

	}

}
