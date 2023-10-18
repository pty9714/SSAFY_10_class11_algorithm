import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int[] visited;
	static int[] cycle;
	static int count;

	private static void dfs(int start, int current) {
		if (visited[arr[current]] == 1 && cycle[arr[current]] == 0) { //방문되어있고 다음 번호의 사이클이 0이라면 
			int s = current;
			int c = 0;
			while(cycle[s] == 0) {
				cycle[s] = 1;
				c++;
				s = arr[s];
			}

			count += c;
			return;
		} else {
			if(visited[arr[current]] == 0) { //다음 곳에 방문하지 않았다면 
				visited[arr[current]] = 1;
				dfs(start, arr[current]);
			}
		}

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
				
				if (cycle[i] == 0 && cycle[arr[i]] == 0) { //사이클이 비어있다면
					visited[arr[i]] = 1;
					dfs(i, arr[i]);

				}
			}
			sb.append(num - count + "\n");
		}
		System.out.println(sb);

	}

}

