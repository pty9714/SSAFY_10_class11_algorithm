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
	public static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			ans = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j);
				}
			}		
			
			// 주변의 지뢰 개수 세기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] != '*') {
						countMine(i, j);
					}
				}
			}
			
			// 주변 지뢰 없는 곳부터 클릭
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j] == 0) {
						ans++;
						bfs(i, j);
					}
				}
			}
			
			// 주변 지뢰 없는 곳부터 클릭
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j] != '*' && map[i][j] != 0) {
						ans++;
					}
				}
			}
			
			bw.write("#" + test_case + " " + ans + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		while(!q.isEmpty()) {
			int[] p = q.poll();
			visited[p[0]][p[1]] = true;
			for (int i = 0; i < 8; i++) {
				int tempx = p[0] + dx[i];
				int tempy = p[1] + dy[i];
				if(tempx < 0 || tempx >= N || tempy < 0 || tempy >= N || visited[tempx][tempy]) continue;
				visited[tempx][tempy] = true;
				// 주변 칸도 0이면 큐에 넣기
				if(map[tempx][tempy] == 0) { 
					q.offer(new int[] {tempx, tempy});
				}
			}
		}
	}
	
	public static void countMine(int x, int y) {
		int temp = 0;
		for (int i = 0; i < 8; i++) {
			int tempx = x + dx[i];
			int tempy = y + dy[i];
			if(tempx < 0 || tempx >= N || tempy < 0 || tempy >= N) continue;
			if(map[tempx][tempy] == '*') temp++;
		}
		map[x][y] = temp;
	}
}