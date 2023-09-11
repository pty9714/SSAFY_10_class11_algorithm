import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
	static int[] dx = {1, 0, 0, -1};
	static int[] dy = {0, 1, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i = 0; i< N; i++) {
			map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		LinkedList<Integer> li = new LinkedList<>();
		for(int i =0; i< N; i++) {
			for(int j =0; j < N; j++) {
				if(map[i][j] == 1) {
					
					Queue<Point> q = new LinkedList<>();
					int count = 1;
					map[i][j] = 0;
					q.add(new Point(j, i));
					
					while(!q.isEmpty()) {
						Point c = q.poll();
						int cx  =c.x;
						int cy = c.y;
						
						for(int k =0 ; k < 4; k++){
							if(cx +dx[k] >= 0 && cx + dx[k] < N & cy + dy[k] >= 0 && cy +dy[k] < N) {
								if(map[cy + dy[k]][cx+dx[k]] == 1) {
									count++;
									map[cy + dy[k]][cx+dx[k]] = 0;
									q.add(new Point(cx+dx[k], cy + dy[k]));
								}
							}
						}
					}
					
					li.add(count);
				}
			}
		}
		
		Collections.sort(li);
		StringBuilder sb = new StringBuilder();
		sb.append(li.size() + "\n");
		for(int i = 0; i< li.size(); i++) {
			sb.append(li.get(i) + "\n");
		}
		System.out.println(sb);
	}
}

19132kb	248ms
