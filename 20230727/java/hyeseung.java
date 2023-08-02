import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
	int x;
	int y;
	int recovery;
	
	public Point(int x, int y, int recovery) {
		this.x = x;
		this.y = y;
		this.recovery = recovery;
	}
    
	// 복구 시간 적은 것이 높은 우선순위 가지도록 설정
	@Override
	public int compareTo(Point other) {
		return this.recovery - other.recovery;
	}
}

class Solution {
	static int N;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map, ans;
	static boolean[][] visited;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			// N, map, ans, visited 초기화
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = new int[N][N];
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				Arrays.fill(ans[i], Integer.MAX_VALUE);
			}
			ans[0][0] = 0;
			
			// map 입력
			for(int i = 0; i < N; i++) {
				String[] s = br.readLine().split("");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			// bfs 실행 결과
			bfs(0, 0);
			
			// 결과 출력
			bw.write("#" + test_case + " " + ans[N-1][N-1] + "\n");
		}
		bw.close();
	}
	
	public static void bfs(int x, int y) {
		PriorityQueue<Point> q = new PriorityQueue<>();
		visited[x][y] = true;
		q.offer(new Point(x, y, 0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			// 우하단 (G)인 경우 결과 리턴
			if(p.x == N - 1 && p.y == N - 1) {
				return;
			}
			
			// 현재 노드에서 네 방향으로의 노드 확인
			for(int i = 0; i < 4; i++) {
				int tmpx = p.x + dx[i];
				int tmpy = p.y + dy[i];
				
				if(tmpx < 0 || tmpx >= N || tmpy < 0 || tmpy >= N) continue;
				// 최소 복구 시간 갱신
				int tmpr = p.recovery + map[tmpx][tmpy];
				if(!visited[tmpx][tmpy] || ans[tmpx][tmpy] > tmpr) {
					visited[tmpx][tmpy] = true;
					ans[tmpx][tmpy] = tmpr;
					q.offer(new Point(tmpx, tmpy, tmpr));
				}
			}
		}
	}
}
// 0.16878s