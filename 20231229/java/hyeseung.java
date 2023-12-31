import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 113864KB, 592ms
public class B2206 {
	
	public static int[][] map;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int N, M, ans = Integer.MAX_VALUE;
	
	static class Node {
		int x;
		int y;
		int distance;
		boolean flag;
		Node(int x, int y, int distance, boolean flag) {
			this.x = x;
			this.y = y;
			this.distance = distance;
			this.flag = flag;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		bfs();
		
		bw.write((ans == Integer.MAX_VALUE ? -1 : ans) + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(0, 0, 1, false));
		boolean visited[][][] = new boolean[N][M][2];
		visited[0][0][0] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.x == N-1 && cur.y == M-1) {
				ans = Math.min(ans, cur.distance);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int tempx = cur.x + dx[i];
				int tempy = cur.y + dy[i];
				if(tempx < 0 || tempy < 0 || tempx >= N || tempy >= M) continue;
				if(map[tempx][tempy] == 1 && !cur.flag && !visited[tempx][tempy][0]) {
					visited[tempx][tempy][1] = true;
					q.offer(new Node(tempx, tempy, cur.distance + 1, true));
				}
				else if(map[tempx][tempy] == 0) {
					if(cur.flag && !visited[tempx][tempy][1]) {
						visited[tempx][tempy][1] = true;
						q.offer(new Node(tempx, tempy, cur.distance + 1, cur.flag));
					}
					else if(!cur.flag && !visited[tempx][tempy][0]) {
						visited[tempx][tempy][0] = true;
						q.offer(new Node(tempx, tempy, cur.distance + 1, cur.flag));
					}
				}
			}
		}
	}
}
/*
bfs
-> 벽 부순 여부까지 고려하여 방문 여부 체크
*/