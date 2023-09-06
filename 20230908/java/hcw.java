import java.io.*;
import java.util.*;



public class Main {
	
	static int[] dy = {1, 0, 0, -1};
	static int[] dx = {0, 1, -1, 0};

	public static class pair{
		public int crashWallCount;
		public int y;
		public int x;
		
		public pair(int y, int x, int crashWallCount){
			this.y = y;
			this.x = x;
			this.crashWallCount = crashWallCount;
			
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		for(int i =0; i< N; i++) {
			arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		PriorityQueue<pair> q = new PriorityQueue<>((el1, el2) -> {
			return el1.crashWallCount - el2.crashWallCount;
		});
		
		int[][] visited = new int[N][M];
		
		
		int result = 0;
		visited[0][0] = 1;
		q.add(new pair(0, 0, 0));
		
		while(!q.isEmpty()) {
			pair p = q.poll();
			
			if(p.x == M-1 && p.y == N-1) {
				result = p.crashWallCount;
				break;
			}
			
			for(int i = 0; i< 4; i++) {
				if(p.x + dx[i] >= 0 && p.x + dx[i] < M && p.y + dy[i] >= 0 && p.y+dy[i] < N && visited[p.y + dy[i]][p.x + dx[i]] == 0) {
					visited[p.y + dy[i]][p.x + dx[i]] = 1;
					if(arr[p.y + dy[i]][p.x + dx[i]] == 1) {
						q.add(new pair(p.y + dy[i], p.x + dx[i], p.crashWallCount+1));
					}else {
						q.add(new pair(p.y + dy[i], p.x + dx[i], p.crashWallCount));
					}
				}
			}
		}
		
		System.out.println(result);
		
		
		
	}

}

	20232kb	320ms
