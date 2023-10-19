import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;

	static class Road {
		int from;
		int to;
		int time; // 걸린 시간
		int cut; // 남은 뗏목

		public Road(int from, int to, int time, int cut) {
			this.from = from;
			this.to = to;
			this.time = time;
			this.cut = cut;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Road>[] al = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			al[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			al[a].add(new Road(a, b, t, c));
			al[b].add(new Road(b, a, t, c));

		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		PriorityQueue<Road> pq = new PriorityQueue<>((el1, el2) -> {
			if (el1.time == el2.time)
				return el1.cut - el2.cut; // 적게 깎있을경우 앞에 오도록 만듬
			return el1.time - el2.time;// 걸린시간 이 적다면 앞으로 오게 함
		});
		
		boolean flag = false;
		int[] visitedMinTime = new int[N+1];
		int[] visitedMinCut = new int[N+1];
		for(int i = 1;i < N+1; i++) {
			visitedMinTime[i] = Integer.MAX_VALUE;
			visitedMinCut[i] = Integer.MAX_VALUE;
		}
		visitedMinCut[start] = 0;
		visitedMinTime[start] = 0;
		Road r = new Road(start, start, 0, 0);
		
		pq.add(r);
		int min = Integer.MAX_VALUE;
		
		while (!pq.isEmpty()) {

			Road temp = pq.poll();
			
			if (temp.to == end) {
				flag = true;
				min = Math.min(temp.time, min);
			}

			for (int i = 0; i < al[temp.to].size(); i++) { // 현재에서 갈 수 바다 경로가 있다면
				if (temp.time + al[temp.to].get(i).time < min) { // min보다 작을경우만
						if (temp.cut + al[temp.to].get(i).cut < K) { // cut 한것이 K보다 많다면 경로 버림
							if(visitedMinCut[al[temp.to].get(i).to] > temp.cut + al[temp.to].get(i).cut) { //더 많이 남았다면?
								visitedMinCut[al[temp.to].get(i).to] = temp.cut + al[temp.to].get(i).cut;
								visitedMinTime[al[temp.to].get(i).to] = temp.time + al[temp.to].get(i).time;
								r = new Road(temp.to, al[temp.to].get(i).to, temp.time + al[temp.to].get(i).time,
										temp.cut + al[temp.to].get(i).cut);
								pq.add(r);
							}else { //같거나 적게 남았다면
								if(visitedMinTime[al[temp.to].get(i).to] > temp.time + al[temp.to].get(i).time) {
									visitedMinTime[al[temp.to].get(i).to] = temp.time + al[temp.to].get(i).time;
									r = new Road(temp.to, al[temp.to].get(i).to, temp.time + al[temp.to].get(i).time,
											temp.cut + al[temp.to].get(i).cut);
									pq.add(r);
								}
							}
							
						}
				}
			}
		}

		if (flag)
			System.out.println(min);
		else
			System.out.println(-1);

	}

}
23648kb	396ms
