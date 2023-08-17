import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2636 {
	
	public static int R, C, cheese[][];
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		cheese = new int[R][C];
		int hour = 0, cnt = 0; 
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int temp = 0;
		while((temp = bfs()) != 0) {
			cnt = temp;
			hour++;
		}
		bw.write(hour + "\n" + cnt);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int bfs() {
		int airCnt = 0;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});
		boolean visited[][] = new boolean[R][C];
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			for (int i = 0; i < 4; i++) {
				int tempx = p[0] + dx[i];
				int tempy = p[1] + dy[i];
				if(tempx < 0 || tempx >= R || tempy < 0 || tempy >= C || visited[tempx][tempy]) continue;
				visited[tempx][tempy] = true;
				if(cheese[tempx][tempy] == 1) {
					cheese[tempx][tempy] = 0;
					airCnt++;
				}
				else {
					q.offer(new int[] {tempx, tempy});
				}
			}
		}
		return airCnt;
	}
}
