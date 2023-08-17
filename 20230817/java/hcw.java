import java.io.*;
import java.awt.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int n;
	static int m;
	static int hour =0;
	
	private static int melt(int x, int y) {
		int count = 0;
		Queue<Point> q = new LinkedList<>();
		
		q.add(new Point(x, y));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int cx = p.x;
			int cy = p.y;
			
			for(int k = 0; k < 4; k++) {
				if(cx + dx[k] >= 0 && cx + dx[k] < m && cy + dy[k] >= 0 && cy + dy[k] < n) {
					if(visited[cy+dy[k]][cx + dx[k]] == 0){
						if(arr[cy+dy[k]][cx + dx[k]] == 0) {
							visited[cy+dy[k]][cx + dx[k]] = 1;
							q.add(new Point(cx + dx[k], cy + dy[k]));
						}else {
							visited[cy+dy[k]][cx + dx[k]] = 1;
							arr[cy+dy[k]][cx + dx[k]] = 0;
							count++;
						}
					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visited = new int[n][m];
		for(int i =0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		int count = 1;
		while(count != 0) {
			visited = new int[n][m];
			result = count;
			hour++;
			count = melt(0, 0);
		}
		System.out.println((hour-1) + "\n" + result);
	}
}

//14200 kb	136 ms
