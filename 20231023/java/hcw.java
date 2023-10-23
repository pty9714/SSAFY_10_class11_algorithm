import java.io.*;
import java.util.*;

public class Main {

	static int[][] arr;
	static int n;
	static int m;
	static int[] dx = { 1, 0, 0, -1};
	static int[] dy = { 0, -1, 1, 0 };
	static int max;
	static int[][] visited;
	static boolean flag = false;
	private static void dfs(int r, int c, int current) {
		if(flag) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			if(flag) {
				break;
			}
			if (r + (dy[i] * arr[r][c]) >= 0 && r + dy[i] * arr[r][c] < n && c + dx[i] * arr[r][c] < m
					&& c + dx[i] * arr[r][c] >= 0 && arr[r][c] != 0) {
				
				if(visited[r+ dy[i] * arr[r][c]][c + dx[i] * arr[r][c]] == 1) {
					max = -1;
					flag = true;
					break;
				}
				visited[r+ dy[i] * arr[r][c]][c + dx[i] * arr[r][c]] = 1;
				dfs(r + dy[i] * arr[r][c], c + dx[i] * arr[r][c], current + 1);
				visited[r+ dy[i] * arr[r][c]][c + dx[i] * arr[r][c]] = 0;
			} else if(!flag) { //구멍이거나 바깥으로 나간다면
				if(r + (dy[i] * arr[r][c]) < 0 || r + dy[i] * arr[r][c] >= n || c + dx[i] * arr[r][c] >= m
					|| c + dx[i] * arr[r][c] < 0) {
					max= Math.max(max,  current+1);
				}else {
					max = Math.max(max, current);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		max = Integer.MIN_VALUE;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String[] temp = st.nextToken().split("");
			for (int j = 0; j < m; j++) {
				if (!temp[j].equals("H")) {
					arr[i][j] = Integer.parseInt(temp[j]);
				} else {
					arr[i][j] = 0;
				}
			}
		}
		visited[0][0] = 1;
		dfs(0, 0, 0);
		
		System.out.println(max);

	}

}

