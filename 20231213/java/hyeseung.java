import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B21609 {
	
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	public static int matrix[][];
	public static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][N];
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		while((max = findMaxGroup()) != 0) {
			ans += max * max;
			break;
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 크기가 가장 큰 블록 찾기
	public static int findMaxGroup() {
		int max = 0, x = 0, y = 0;
		boolean visited[][] = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j] && matrix[i][j] > 0) {
					int cnt = findGroup(i, j, visited);
					if(cnt > max) {
						max = cnt;
						x = i; y = j;
					}
					else if(cnt == max) {
						if(x < i || (x == i && y > j)) {
							x = i; y = j;
						}
					}
				}
			}
		}
		return max;
	}
	
	// 블록 그룹 찾기
	public static int findGroup(int x, int y, boolean visited[][]) {
		Queue<int[]> q = new ArrayDeque<>();
		int color = matrix[x][y];
		int cnt = 1;
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int tempx = cur[0] + dx[i];
				int tempy = cur[1] + dy[i];
				if(tempx < 0 || tempx >= N || tempy < 0 || tempy >= N) continue;
				if(matrix[tempx][tempy] == color) {
					cnt++;
					visited[x][y] = true;
					q.offer(new int[] {x, y});
				}
				else if(matrix[tempx][tempy] == 0) {
					cnt++;
					q.offer(new int[] {x, y});
				}
			}
		}
		return cnt;
	}
	
	

}
