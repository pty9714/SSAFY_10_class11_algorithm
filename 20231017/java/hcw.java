import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Current {
		int count;
		int current;

		public Current(int count, int current) {
			this.count = count;
			this.current = current;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] al = new ArrayList[101];
		int[] visited = new int[101];
		for (int i = 0; i < 101; i++) {
			al[i] = new ArrayList<>();
		}
		for (int i = 0; i < n + m; i++) {
			st = new StringTokenizer(br.readLine());
			al[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		PriorityQueue<Current> pq = new PriorityQueue<>((el1, el2) -> {
			if (el1.count == el2.count) {
				return el2.current - el1.current;
			}
			return el1.count - el2.count;
		});

		for (int i = 2; i <= 7; i++) {
			visited[i] = 1;
			if (al[i].size() != 0) { // 사다리나 뱀 타야함
				visited[al[i].get(0)] = 1;
				pq.add(new Current(1, al[i].get(0)));
			} else {
				pq.add(new Current(1, i));
			}
		}
		int min = Integer.MAX_VALUE;

		while (true) {
			Current c = pq.poll();
			if (c.current == 100) {
				min = c.count;
				break;
			}
			for (int i = 1; i <= 6; i++) {
				if (c.current + i <= 100 && visited[c.current + i] == 0) {
					visited[c.current+i] = 1;
					if (al[c.current + i].size() != 0) { // 사다리나 뱀 타야함
						visited[al[c.current + i].get(0)] = 1;
						pq.add(new Current(c.count + 1, al[c.current + i].get(0)));
					} else {
						pq.add(new Current(c.count + 1, c.current + i));
					}
				}
			}
		}

		bw.write(min+"");
		
		bw.flush();
		br.close();
		bw.close();
	}

}


18464kb	228ms
