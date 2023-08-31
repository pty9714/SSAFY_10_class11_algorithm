import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] arr;
	static int current_y;
	static int current_x;
	static int cur_size;
	static int cur_size_eat;
	static int time;
	static int[] dx = { 0, -1, 1, 0 };
	static int[] dy = { -1, 0, 0, 1 };

	static class pv {
		public Point point;
		public int distance;

		public pv(Point p, int distance) {
			this.point = p;
			this.distance = distance;
		}
	}

	static boolean eat(int y, int x) {
		boolean flag = false;
		int[][] visited = new int[N][N];
		PriorityQueue<pv> q = new PriorityQueue<>((el1, el2) -> {
			if (el1.distance != el2.distance) {
				return el1.distance - el2.distance;
			} else {
				if (el1.point.y != el2.point.y) {
					return el1.point.y - el2.point.y;
				} else {
					return el1.point.x - el2.point.x;
				}
			}
		});

		visited[y][x] = 1;
		arr[y][x] = 0;
		q.add(new pv(new Point(x, y), 0));

		label: while (!q.isEmpty()) {
			pv c = q.poll();
			int cx = c.point.x;
			int cy = c.point.y;
			

			if (arr[cy][cx] < cur_size && arr[cy][cx] != 0) { // 먹을 수 있냐
				time += (c.distance);
				cur_size_eat++;
				current_y = cy;
				current_x = cx;
				flag = true;
				break label;
			}

			for (int i = 0; i < 4; i++) {
				if (cx + dx[i] >= 0 && cx + dx[i] < N && cy + dy[i] >= 0 && cy + dy[i] < N
						&& visited[cy + dy[i]][cx + dx[i]] == 0) { //방문하지 않았다면
					visited[cy + dy[i]][cx + dx[i]] = 1;
					if (arr[cy + dy[i]][cx + dx[i]] <= cur_size) { //같거나 작으면
						q.add(new pv(new Point((cx + dx[i]), (cy + dy[i])), c.distance + 1));
					}

				}

			}
			

		}

		if (cur_size_eat == cur_size) {
			cur_size++;
			cur_size_eat = 0;
		}

		return flag;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		time = 0;
		cur_size_eat = 0;
		cur_size = 2;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					current_y = i;
					current_x = j;

				}
			}
		}

		while (true) {
			if (!eat(current_y, current_x)) {
				break;
			}

		}
		System.out.println(time);

	}

}
19068kb	236ms
