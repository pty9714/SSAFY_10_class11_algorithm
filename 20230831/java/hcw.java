import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] arr;
	static int current_y;
	static int current_x;
	static int cur_size = 2;
	static int cur_size_eat = 0;
	static int time = 0;
	static int[] dx = { 0, -1, 1, 0, 0, -1, 1, -2, 2, -1, 1, 0 };
	static int[] dy = { -1, 0, 0, 1, -2, -1, -1, 0, 0, 1, 1, 2 };
	static int total = 0;

	static class pv {
		public Point point;
		public int distance;

		public pv(Point p, int distance) {
			this.point = p;
			this.distance = distance;
		}
	}

	static boolean eat(int y, int x) {
		Queue<pv> q = new LinkedList<>();
		boolean flag = false;
		int[][] visited = new int[N][N];
		visited[y][x] = 1;
		arr[y][x] = 0;
		q.add(new pv(new Point(x, y), 0));

		label: while (!q.isEmpty()) {
			
			pv c = q.poll();
			int cx = c.point.x;
			int cy = c.point.y;

			
			
			for (int i = 0; i < 12; i++) {
				if (cx + dx[i] >= 0 && cx + dx[i] < N && cy + dy[i] >= 0 && cy + dy[i] < N
						&& visited[cy + dy[i]][cx + dx[i]] == 0) {
					if (arr[cy + dy[i]][cx + dx[i]] == 0) { // 0이라면
						if(i < 4) {
							visited[cy + dy[i]][cx + dx[i]] = 1;
							q.add(new pv(new Point(cx + dx[i], cy + dy[i]), c.distance + 1));
						}else {
							if(i == 4 && arr[cy+dy[0]][cx+dx[0]] <= cur_size) {
								visited[cy + dy[i]][cx + dx[i]] = 1;
								q.add(new pv(new Point(cx + dx[i], cy + dy[i]), c.distance + 2));
								
							}else if(i ==5 && arr[cy+dy[0]][cx+dx[0]] <= cur_size && arr[cy+dy[1]][cx+dx[1]] <= cur_size){
								visited[cy + dy[i]][cx + dx[i]] = 1;
								q.add(new pv(new Point(cx + dx[i], cy + dy[i]), c.distance + 2));
							}else if(i ==6 && arr[cy+dy[0]][cx+dx[0]] <= cur_size && arr[cy+dy[2]][cx+dx[2]] <= cur_size) {
								visited[cy + dy[i]][cx + dx[i]] = 1;
								q.add(new pv(new Point(cx + dx[i], cy + dy[i]), c.distance + 2));
							}else if(i ==7 && arr[cy+dy[1]][cx+dx[1]] <= cur_size) {
								visited[cy + dy[i]][cx + dx[i]] = 1;
								q.add(new pv(new Point(cx + dx[i], cy + dy[i]), c.distance + 2));
							}else if(i ==8 && arr[cy+dy[2]][cx+dx[2]] <= cur_size) {
								visited[cy + dy[i]][cx + dx[i]] = 1;
								q.add(new pv(new Point(cx + dx[i], cy + dy[i]), c.distance + 2));
							}else if(i == 9 && arr[cy+dy[1]][cx+dx[1]] <= cur_size && arr[cy+dy[3]][cx+dx[3]] <= cur_size) {
								visited[cy + dy[i]][cx + dx[i]] = 1;
								q.add(new pv(new Point(cx + dx[i], cy + dy[i]), c.distance + 2));
							}else if(i == 10 && arr[cy+dy[3]][cx+dx[3]] <= cur_size && arr[cy+dy[2]][cx+dx[2]] <= cur_size) {
								visited[cy + dy[i]][cx + dx[i]] = 1;
								q.add(new pv(new Point(cx + dx[i], cy + dy[i]), c.distance + 2));
							}else if(i == 11 && arr[cy+dy[3]][cx+dx[3]] <= cur_size) {
								visited[cy + dy[i]][cx + dx[i]] = 1;
								q.add(new pv(new Point(cx + dx[i], cy + dy[i]), c.distance + 2));
							}
						}		
					} else { // 아니라면.. 물고기 있는겨
						if (arr[cy + dy[i]][cx + dx[i]] <= cur_size) { // 먹을 수 있냐
							if (arr[cy + dy[i]][cx + dx[i]] == cur_size) { // 크기가 같음
								if(i < 4) {
									visited[cy + dy[i]][cx + dx[i]] = 1;
									q.add(new pv(new Point(cx + dx[i], cy + dy[i]), c.distance + 1));
								}else {
									if(i == 4 && arr[cy+dy[0]][cx+dx[0]] <= cur_size) {
										visited[cy + dy[i]][cx + dx[i]] = 1;
										q.add(new pv(new Point(cx + dx[i], cy + dy[i]), c.distance + 2));
									}else if(i ==5 && arr[cy+dy[0]][cx+dx[0]] <= cur_size && arr[cy+dy[1]][cx+dx[1]] <= cur_size){
										visited[cy + dy[i]][cx + dx[i]] = 1;
										q.add(new pv(new Point(cx + dx[i], cy + dy[i]), c.distance + 2));
									}else if(i ==6 && arr[cy+dy[0]][cx+dx[0]] <= cur_size && arr[cy+dy[2]][cx+dx[2]] <= cur_size) {
										visited[cy + dy[i]][cx + dx[i]] = 1;
										q.add(new pv(new Point(cx + dx[i], cy + dy[i]), c.distance + 2));
									}else if(i ==7 && arr[cy+dy[1]][cx+dx[1]] <= cur_size) {
										visited[cy + dy[i]][cx + dx[i]] = 1;
										q.add(new pv(new Point(cx + dx[i], cy + dy[i]), c.distance + 2));
									}else if(i ==8 && arr[cy+dy[2]][cx+dx[2]] <= cur_size) {
										visited[cy + dy[i]][cx + dx[i]] = 1;
										q.add(new pv(new Point(cx + dx[i], cy + dy[i]), c.distance + 2));
									}else if(i == 9 && arr[cy+dy[1]][cx+dx[1]] <= cur_size && arr[cy+dy[3]][cx+dx[3]] <= cur_size) {
										visited[cy + dy[i]][cx + dx[i]] = 1;
										q.add(new pv(new Point(cx + dx[i], cy + dy[i]), c.distance + 2));
									}else if(i == 10 && arr[cy+dy[3]][cx+dx[3]] <= cur_size && arr[cy+dy[2]][cx+dx[2]] <= cur_size) {
										visited[cy + dy[i]][cx + dx[i]] = 1;
										q.add(new pv(new Point(cx + dx[i], cy + dy[i]), c.distance + 2));
									}else if(i == 11 && arr[cy+dy[3]][cx+dx[3]] <= cur_size) {
										visited[cy + dy[i]][cx + dx[i]] = 1;
										q.add(new pv(new Point(cx + dx[i], cy + dy[i]), c.distance + 2));
									}
								}
							} else { // 크기가 작으면
								if(i < 4) {
									time += (c.distance + 1);
									cur_size_eat++;
									current_y = cy + dy[i];
									current_x = cx + dx[i];
									flag = true;
									break label;
								}else {
									if(i == 4 && arr[cy+dy[0]][cx+dx[0]] <= cur_size) {
										time += (c.distance + 2);
										cur_size_eat++;
										current_y = cy + dy[i];
										current_x = cx + dx[i];
										flag = true;
										break label;
									}else if(i ==5 && arr[cy+dy[0]][cx+dx[0]] <= cur_size && arr[cy+dy[1]][cx+dx[1]] <= cur_size){
										time += (c.distance + 2);
										cur_size_eat++;
										current_y = cy + dy[i];
										current_x = cx + dx[i];
										flag = true;
										break label;
									}else if(i ==6 && arr[cy+dy[0]][cx+dx[0]] <= cur_size && arr[cy+dy[2]][cx+dx[2]] <= cur_size) {
										time += (c.distance + 2);
										cur_size_eat++;
										current_y = cy + dy[i];
										current_x = cx + dx[i];
										flag = true;
										break label;
									}else if(i ==7 && arr[cy+dy[1]][cx+dx[1]] <= cur_size) {
										time += (c.distance + 2);
										cur_size_eat++;
										current_y = cy + dy[i];
										current_x = cx + dx[i];
										flag = true;
										break label;
									}else if(i ==8 && arr[cy+dy[2]][cx+dx[2]] <= cur_size) {
										time += (c.distance + 2);
										cur_size_eat++;
										current_y = cy + dy[i];
										current_x = cx + dx[i];
										flag = true;
										break label;
									}else if(i == 9 && arr[cy+dy[1]][cx+dx[1]] <= cur_size && arr[cy+dy[3]][cx+dx[3]] <= cur_size) {
										time += (c.distance + 2);
										cur_size_eat++;
										current_y = cy + dy[i];
										current_x = cx + dx[i];
										flag = true;
										break label;
									}else if(i == 10 && arr[cy+dy[3]][cx+dx[3]] <= cur_size && arr[cy+dy[2]][cx+dx[2]] <= cur_size) {
										time += (c.distance + 2);
										cur_size_eat++;
										current_y = cy + dy[i];
										current_x = cx + dx[i];
										flag = true;
										break label;
									}else if(i == 11 && arr[cy+dy[3]][cx+dx[3]] <= cur_size) {
										time += (c.distance + 2);
										cur_size_eat++;
										current_y = cy + dy[i];
										current_x = cx + dx[i];
										flag = true;
										break label;
									}
									
								}
								
							}
						} else {// 읎냐
							visited[cy + dy[i]][cx + dx[i]] = 1;
						}

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
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					current_y = i;
					current_x = j;

				} else if (arr[i][j] != 0) {
					total++;
				}
			}
		}

		while (true) {

			
			if (!eat(current_y, current_x)) {
				break;
			}
			
			for(int i =0 ; i< arr.length; i++) {
				System.out.println(Arrays.toString(arr[i]));
			}
			
			System.out.println();
		}
		System.out.println(time);

	}

}
