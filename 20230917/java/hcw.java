import java.util.*;
import java.io.*;

public class Main {

	static int min = Integer.MAX_VALUE;
	static int V;
	
	public static class Node{
		int to;
		int distance;
		boolean flag;
		public int[] visited = new int[V+1];
		public Node(int to, int distance, boolean flag) {
			this.to = to;
			this.distance = distance;
			this.flag = flag;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		ArrayList<Node>[] al = new ArrayList[V+1];
		for(int i = 1; i<= V; i++) {
			al[i] = new ArrayList<>();
		}
		
		for(int i =0 ; i< E; i++) {
			int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			al[temp[0]].add(new Node(temp[1], temp[2], false));
			al[temp[1]].add(new Node(temp[0], temp[2], false));
		}
		PriorityQueue<Node> pq = new PriorityQueue<>((el1, el2) -> {
			return el1.distance - el2.distance;
		});
		Node tem;
		if(C == 1) {
			tem = new Node(1, 0, true);
		}else {
			tem = new Node(1, 0, false);
		}
		tem.visited[1] = 1; //본인 방문 처리 
		pq.add(tem);
		
		
		boolean success = false;
		
		while(!pq.isEmpty()) {
			Node t = pq.poll();

			if(t.distance > min) {
				break;
			}

			if(t.to == V && min >= t.distance) { //도착을 하면
				min = t.distance;
				if(success == false) { //success가 false 라
					success = t.flag; // 담아줌
				}
				 //min이 세팅된다.
                if(t.flag == true){ //도착했는데 flag가 true라면 
                    break;
                }
			}

			for(int i =0 ; i< al[t.to].size(); i++) {
				if(t.visited[al[t.to].get(i).to] == 0 && t.distance+al[t.to].get(i).distance <= min) { //방문하지 않은 경로라면
					Node in;
					if(al[t.to].get(i).to == C) { //c라면 바꿔준다.
						in = new Node(al[t.to].get(i).to, t.distance+al[t.to].get(i).distance, true);
					}else { //그전의 flag값 유지 
						in = new Node(al[t.to].get(i).to, t.distance+al[t.to].get(i).distance, t.flag);
					}
                    in.visited = t.visited.clone();
					in.visited[al[t.to].get(i).to] = 1;
					pq.add(in);
				}
			}
		}
		
		if(success) {
			System.out.println("SAVE HIM");
		}else {
			System.out.println("GOOD BYE");
		}
	}
}

