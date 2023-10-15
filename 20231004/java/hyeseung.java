import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S4112 {

	public static int ans, floor[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		// 층수 저장
		floor = new int[10001];
		int base = 1, d = 1;
		for (int i = 1; i <= 10000; i++) {
			if (i == base + d) {
				d++;
				base = i;
			}
			floor[i] = d;
		}

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;

			if (a > b) {
				int temp = a;
				a = b;
				b = temp;
			}

			// 탐색 수행
			bfs(a, b);

			bw.write("#" + test_case + " " + ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static void bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { a, 0 });
		boolean visited[] = new boolean[10001];
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == b) {
				ans = Math.min(ans, cur[1]);
				continue;
			}
			if (floor[cur[0]] < floor[b]) {
				int left = cur[0] + floor[cur[0]];
				int right = cur[0] + floor[cur[0]] + 1;
				if (left <= 10000 && !visited[left]) {
					q.offer(new int[] { left, cur[1] + 1 });
					if (left != b && floor[left] != floor[b])
						visited[left] = true;
				}
				if (right <= 10000 && !visited[right]) {
					q.offer(new int[] { right, cur[1] + 1 });
					if (right != b && floor[right] != floor[b])
						visited[right] = true;
				}
			}
			if (floor[cur[0]] == floor[b]) {
				int left = cur[0] - 1;
				int right = cur[0] + 1;
				if (cur[0] > b && left <= 10000 && floor[left] == floor[b]) {
					q.offer(new int[] { left, cur[1] + 1 });
				} else if (cur[0] < b && right <= 10000 && floor[right] == floor[b]) {
					q.offer(new int[] { right, cur[1] + 1 });
				}
			}
		}
	}
}