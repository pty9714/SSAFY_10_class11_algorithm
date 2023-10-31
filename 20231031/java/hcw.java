import java.awt.Point;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		char[][] map = new char[n][n];
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = temp.charAt(j);
			}
		}


		Queue<Point> q = new LinkedList<>();
		int[][] visited = new int[n][n];
		Queue<Point> q1 = new LinkedList<>();
		int[][] visited1 = new int[n][n];
		int count = 0;
		int count1 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == 0) {
					count++;
					q.add(new Point(j, i));
					visited[i][j] = 1;
					while (!q.isEmpty()) {
						Point p = q.poll();
						char current = map[p.y][p.x];
						for (int k = 0; k < 4; k++) {
							if (p.y + dy[k] >= 0 && p.y + dy[k] < n && p.x + dx[k] >= 0 && p.x + dx[k] < n) {
								if (visited[p.y + dy[k]][p.x + dx[k]] == 0
										&& map[p.y + dy[k]][p.x + dx[k]] == current) {
									visited[p.y + dy[k]][p.x + dx[k]] = 1;
									q.add(new Point(p.x + dx[k], p.y + dy[k]));
								}
							}
						}
					}
				}
				
				if (visited1[i][j] == 0) {
					count1++;
					q1.add(new Point(j, i));
					visited1[i][j] = 1;
					while (!q1.isEmpty()) {
						Point p = q1.poll();
						char current = map[p.y][p.x];
						for (int k = 0; k < 4; k++) {
							if (p.y + dy[k] >= 0 && p.y + dy[k] < n && p.x + dx[k] >= 0 && p.x + dx[k] < n && visited1[p.y + dy[k]][p.x + dx[k]] == 0) {
								if(current == 'G' || current == 'R') {
									if (map[p.y + dy[k]][p.x + dx[k]] == 'G' || map[p.y + dy[k]][p.x + dx[k]] == 'R') {
										visited1[p.y + dy[k]][p.x + dx[k]] = 1;
										q1.add(new Point(p.x + dx[k], p.y + dy[k]));
									}
								}else {
									if (map[p.y + dy[k]][p.x + dx[k]] == current) {
										visited1[p.y + dy[k]][p.x + dx[k]] = 1;
										q1.add(new Point(p.x + dx[k], p.y + dy[k]));
									}
								}
								
							}
						}
					}
				}
				
			}
		}
		bw.write(count + " " + count1);
		bw.flush();

	}

}

13944kb	104ms
