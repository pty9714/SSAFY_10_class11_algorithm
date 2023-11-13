import java.io.*;
import java.util.*;

public class Main {

	static class Next{
		int num;
		int distance;
		public Next(int num, int distance) {
			this.num = num;
			this.distance = distance;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		ArrayList<Next>[] al = new ArrayList[V+1];
		for(int i =0; i < al.length; i++) {
			al[i] = new ArrayList<>();
		}
		
		for(int i =0;i < E; i++) {
			st = new StringTokenizer(br.readLine());
			al[Integer.parseInt(st.nextToken())].add(new Next(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		for(int i =1; i< al.length; i++) {
			al[i].sort((el1, el2) -> el1.distance - el2.distance);
		}
		
		
		
		PriorityQueue<Next> pq = new PriorityQueue<>((el1, el2) -> {
			return el1.distance - el2.distance;
		});
		
		int[] answer = new int[V+1];
		Arrays.fill(answer, Integer.MAX_VALUE);
		
		answer[start] = 0;
		pq.add(new Next(start, 0));
		
		while(!pq.isEmpty()) {
			Next current = pq.poll();
			
			for(int i =0; i < al[current.num].size(); i++) {
				if(answer[al[current.num].get(i).num] > current.distance + al[current.num].get(i).distance) {
					answer[al[current.num].get(i).num] = current.distance + al[current.num].get(i).distance;
					pq.add(new Next(al[current.num].get(i).num, current.distance + al[current.num].get(i).distance));
				}
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i =1;i < answer.length; i++) {
			if(answer[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			}else {
				sb.append(answer[i] +"\n");
			}
		}
		System.out.println(sb);

		
	}

}

1032ms
