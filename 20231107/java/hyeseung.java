import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 11848KB, 84ms
public class B1043 {

	public static boolean visited[];
	public static HashSet<Integer> ans = new HashSet<Integer>(); // 지민이가 진실을 말해야하는 파티 Set
	public static HashSet<Integer>[] partyMember; // 각 사람 번호 별로 같은 파티를 가는 사람 번호들 넣기
	public static HashSet<Integer>[] party; // 각 사람 번호 별로 가는 파티 번호 넣기
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N, M, 진실을 아는 사람 입력 받기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int truthCnt = Integer.parseInt(st.nextToken());
		Queue<Integer> truth = new LinkedList<>(); 
		for (int i = 0; i < truthCnt; i++) {
			truth.offer(Integer.parseInt(st.nextToken()));
		}
		
		// 파티마다 오는 사람 번호 입력 받기
		partyMember = new HashSet[N + 1];
		party = new HashSet[N + 1];
		for (int i = 0; i <= N; i++) {
			partyMember[i] = new HashSet<Integer>();
			party[i] = new HashSet<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int temp[] = new int[cnt];
			for (int j = 0; j < cnt; j++) {
				int num = Integer.parseInt(st.nextToken());
				temp[j] = num;
				party[num].add(i); // 각 사람 번호 별로 가는 파티 번호 넣기
			}

			// 각 사람 번호 별로 같은 파티를 가는 사람 번호들 넣기
			for (int j = 0; j < cnt; j++) {
				for (int k = j + 1; k < cnt; k++) {
					partyMember[temp[j]].add(temp[k]);
					partyMember[temp[k]].add(temp[j]);
				}
			}
		}

		// dfs 수행하며 지민이가 진실을 말해야하는 파티 넣기
		visited = new boolean[N + 1];
		while(!truth.isEmpty()) { // 진실을 아는 사람들
			int cur = truth.poll();
			if(!visited[cur])
				dfs(cur);
		}
		
		// 전체 파티에서 진실을 말해야하는 파티 빼서 과장된 이야기 할 수 있는 파티 개수 출력
		bw.write((M - ans.size()) + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int number) {
		visited[number] = true;
		Iterator<Integer> it = party[number].iterator();
		while (it.hasNext()) // 지민이가 진실을 말해야하는 파티 넣기
		    ans.add(it.next());
		it = partyMember[number].iterator(); // 진실을 아는 사람과(number) 같은 파티를 가는 사람도 dfs 진행
		while (it.hasNext()) {
			int next = it.next();
			if(!visited[next]) dfs(next);
		}
	}

}
