import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 11756KB, 80ms
public class B16928 {
	
	static class Game implements Comparable<Game> {
		int number;
		int cnt;
		public Game(int number, int cnt) {
			this.number = number;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Game o) {
			if(this.cnt == o.cnt)
				return o.number - this.number;
			return this.cnt - o.cnt;
		}
	}
	
	public static int board[] = new int[100];
	public static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ans = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x-1] = y-1;
		}
		
		bfs();
		
		bw.write(ans + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void bfs() {
		PriorityQueue<Game> q = new PriorityQueue<>();
		q.offer(new Game(0, 0));
		boolean visited[] = new boolean[100];
		visited[0] = true;
		while(!q.isEmpty()) {
			Game cur = q.poll();
			if(cur.number >= 99) {
				ans = Math.min(ans, cur.cnt);
				continue;
			}
			for (int i = 6; i > 0; i--) {
				if((cur.number + i) < 99 && board[cur.number + i] > 0 && !visited[board[cur.number + i]]) {
					q.offer(new Game(board[cur.number + i], cur.cnt + 1));
					visited[board[cur.number + i]] = true;
				}
				else if(cur.number + i >= 99 || (!visited[cur.number + i] && board[cur.number + i] <= 0)){
					q.offer(new Game(cur.number + i, cur.cnt + 1));
					if(cur.number + i < 99) visited[cur.number + i] = true;
				}
			}
		}
	}

}
