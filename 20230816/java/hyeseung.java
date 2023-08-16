import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class S1868 {
	public static int ans, N, map[][];
	public static int dx[] = {-1, -1, -1, 0, 1, 1, 1, 0};
	public static int dy[] = {-1, 0, 1, 1, 1, 0, -1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			ans = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j);
				}
			}			
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] != '*') {
						bfs(i, j);
						flag = true;
						break;
					}
				}
				if(flag) break;
			}
			System.out.println(Arrays.deepToString(map));
			bw.write("#" + test_case + " " + ans + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		boolean visited[][] = new boolean[N][N];
		while(!q.isEmpty()) {
			int[] p = q.poll();
			if(!visited[p[0]][p[1]]) {
				int temp = 0, cnt = 0;
				ans++;
				visited[p[0]][p[1]] = true;
				for (int i = 0; i < 8; i++) {
					int tempx = p[0] + dx[i];
					int tempy = p[1] + dy[i];
					if(tempx < 0 || tempx >= N || tempy < 0 || tempy >= N) continue;
					if(map[tempx][tempy] == '*') {
						temp++;
					}
					else if(!visited[tempx][tempy]) {
						cnt++;
						System.out.println(tempx + " " + tempy);
						q.offer(new int[] {tempx, tempy});
					}
				}	
				map[p[0]][p[1]] = temp;
				System.out.println(p[0] + " " + p[1] + " " + temp + " " + cnt);
				if(temp == 0) ans -= cnt;
				System.out.println(ans);
			}
		}
	}
}
