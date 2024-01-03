import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 	38900KB, 336ms
public class B1520 {
	public static int M, N;
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	public static int[][] map;
	public static int[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new int[M][N];
		
		// 지도 입력 받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 방문 배열 초기화
		for (int i = 0; i < M; i++) {
			Arrays.fill(visited[i], -1);
		}
		bw.write(dfs(0, 0) + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int dfs(int x, int y) {
		if(x == M-1 && y == N-1) return 1; // 제일 오른쪽 아래 지점일 경우 끝 
		if(visited[x][y] != -1) return visited[x][y]; // 방문 했던 칸일 경우 해당 칸 경로 개수 반환
		visited[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			int tempx = x + dx[i];
			int tempy = y + dy[i];
			if(tempx < 0 || tempy < 0 || tempx >= M || tempy >= N) continue;
			// 더 낮은 지점일 경우 이동
			if(map[x][y] > map[tempx][tempy]) {
				visited[x][y] += dfs(tempx, tempy);
			}
		}
		return visited[x][y];
	}
}
/*
 dfs + dp
 -> dfs로 풀 수 있는 문제인데 이동 가능한 경로의 수가 10억 이하이므로 dp를 사용해야함
 방문 배열에 경로 개수를 구해 이미 방문한 칸일 경우 해당 방문 배열 이용(-1인 경우 방문 X)
 */
