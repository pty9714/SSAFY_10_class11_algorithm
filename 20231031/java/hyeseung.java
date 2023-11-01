import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
// 12928KB, 96ms
public class Main {
	
	public static int N;
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		char[][] weak = new char[N][N];
		char[][] noWeak = new char[N][N];
		int weakCnt = 0, noWeakCnt = 0;
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				weak[i][j] = temp.charAt(j) == 'R' ? 'G' : temp.charAt(j);
				noWeak[i][j] = temp.charAt(j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(weak[i][j] != '0') {
					weakCnt++;
					bfs(i, j, weak, weak[i][j]);
				}
				if(noWeak[i][j] != '0') {
					noWeakCnt++;
					bfs(i, j, noWeak, noWeak[i][j]);
				}
			}
		}
		
		bw.write(noWeakCnt + " " + weakCnt);
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void bfs(int x, int y, char[][] paint, char color) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		paint[x][y] = '0';
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int tempx = cur[0] + dx[i];
				int tempy = cur[1] + dy[i];
				if(tempx < 0 || tempx >= N || tempy < 0 || tempy >= N || paint[tempx][tempy] == '0') continue;
				if(paint[tempx][tempy] == color) {
					paint[tempx][tempy] = '0';
					q.offer(new int[] {tempx, tempy});
				}
			}
		}
	}

}