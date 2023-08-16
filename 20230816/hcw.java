import java.util.*;
import java.awt.Point;
import java.io.*;

class Main {

	static int[] dx = { 1, 1, 1, 0, -1, -1, -1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	static int[][] arr;
	static int n;
	static int[][] visited;
	static int result;

	private static void click(int y, int x) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visited[y][x] = 1;

		while (!q.isEmpty()) {
			int count = 0;
			Point p = q.poll();
			int cx = p.x;
			int cy = p.y;

			boolean flagIsZero = true;

			for (int k = 0; k < 8; k++) {
				if (cx + dx[k] >= 0 && cx + dx[k] < n && cy + dy[k] >= 0 && cy + dy[k] < n) {
					if (arr[cy + dy[k]][cx + dx[k]] == 9) {
						flagIsZero = false;
						count++;
					}
				}
			}
			for (int k = 0; k < 8; k++) {
				if (flagIsZero) {
					if (cx + dx[k] >= 0 && cx + dx[k] < n && cy + dy[k] >= 0 && cy + dy[k] < n) {
						if (arr[cy + dy[k]][cx + dx[k]] == 0 && visited[cy + dy[k]][cx + dx[k]] == 0) {
							visited[cy + dy[k]][cx + dx[k]] = 1;
							q.add(new Point(cx + dx[k], cy + dy[k]));
						}
					}

				}
			}

			if (flagIsZero) {
				arr[cy][cx] = 0;
			} else
				arr[cy][cx] = count;

		}

	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testcase; test++) {
			n = Integer.parseInt(br.readLine());
			result = 0;
			arr = new int[n][n];
			visited = new int[n][n];
			String temp = new String();
			for (int i = 0; i < n; i++) {
				temp = br.readLine();
				for (int j = 0; j < n; j++) {
					if (temp.charAt(j) == '*') {
						arr[i][j] = 9;
						visited[i][j] = 1;
					}
				}
			}

			boolean flagIsZero = true;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < 8; k++) {
						if (j + dx[k] >= 0 && j + dx[k] < n && i + dy[k] >= 0 && i + dy[k] < n) {
							if (arr[i + dy[k]][j + dx[k]] == 9) { // 주변에 벽이 있다면 일단 pass
								flagIsZero = false;
								break;
							}
						}
					}
					if (flagIsZero && visited[i][j] == 0) {// 벽이 없고 방문하지 않았다면
						result++;
						click(i, j);
					}
					flagIsZero = true;
				}
			}
			
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(visited[i][j] == 0) result ++;
				}
			}

			System.out.println("#" + test + " " + result);
			

		}

	}
}
