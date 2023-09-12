import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Main {

	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	public static int N, village[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		village = new int[N][N];
		ArrayList<Integer> answers = new ArrayList<>();
		
		// 입력
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				village[i][j] = s.charAt(j) - '0';
			}
		}
		
		// Flood Fill 수행
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(village[i][j] != 0) { // 방문 안된 것 & 집이 있는 곳
					answers.add(bfs(i, j));
				}
			}
		}
		
		// 결과 정렬 후 출력
		Collections.sort(answers);
		bw.write(answers.size() + "\n");
		for (int answer : answers) {
			bw.write(answer + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int bfs(int x, int y) {
		int cnt = 1;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{x, y});
		village[x][y] = 0; // 방문 처리
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			for (int i = 0; i < 4; i++) {
				int tempx = p[0] + dx[i];
				int tempy = p[1] + dy[i];
				if(tempx < 0 || tempx >= N || tempy < 0 || tempy >= N || village[tempx][tempy] == 0) continue;
				q.offer(new int[] {tempx, tempy});
				village[tempx][tempy] = 0; // 방문 처리
				cnt++; // 단지내 집의 수 세기
			}
		}
		
		return cnt;
	}
}
// 11744KB, 84ms	
