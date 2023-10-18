import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 303016KB, 1052ms
public class B9466 {
	
	public static int ans, children[];
	public static boolean visited[], cycle[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			children = new int[n + 1];
			visited = new boolean[n + 1];
			cycle = new boolean[n + 1];
			ans = n;
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				children[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= n; i++) {
				dfs(i);
			}
			bw.write(ans + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int cur) {
		visited[cur] = true;
		int next = children[cur];
		if(!visited[next]) {
			dfs(next);
		}
		else {
			if(!cycle[next]) {
				ans--;
				while(cur != next) {
					next = children[next];
					ans--;
				}
			}
		}
		cycle[cur] = true;
	}

}
