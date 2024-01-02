import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 52852KB, 776ms
public class B13334 {
	
	static class Path implements Comparable<Path> {
		int left;
		int right;
		Path(int left, int right) {
			this.left = left;
			this.right = right;
		}
		// 오른쪽, 왼쪽 장소 기준으로 정렬
		@Override
		public int compareTo(Path o) {
			if(this.right == o.right) {
				return this.left - o.left;
			}
			return this.right - o.right;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		PriorityQueue<Path> pq1 = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int o = Integer.parseInt(st.nextToken());
			pq1.offer(new Path(h < o ? h : o, h < o ? o : h));
		}
		int d = Integer.parseInt(br.readLine());
		
		int ans = 0;
		
		while(!pq1.isEmpty()) {
			Path path = pq1.poll();
			if(path.right - path.left > d) continue;
			pq2.offer(path.left);
			// L(path.right - d ~ path.right) 포함안되는 것 제거
			while(!pq2.isEmpty() && pq2.peek() < path.right - d) {
				pq2.poll();
			}
			ans = Math.max(ans, pq2.size());
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
/*
 우선순위큐
 -> 오른쪽, 왼쪽 순서의 오름차순으로 우선순위를 부여하는 것이 중요함(왼쪽부터 정렬하면 구할 수 없음)
 */
