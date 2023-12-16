import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 14592KB, 132ms
public class B21609 {
	
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	public static int matrix[][];
	public static int N, M;
	
	static class BlockGroup {
		int x;
		int y;
		int color;
		int cnt;
		int rainbowCnt;
		BlockGroup(int x, int y, int color, int cnt, int rainbowCnt) {
			this.x = x;
			this.y = y;
			this.color = color;
			this.cnt = cnt;
			this.rainbowCnt = rainbowCnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][N];
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			// 1. 크기가 가장 큰 블록 그룹을 찾는다.
			BlockGroup maxBlock = findMaxGroup();
			if(maxBlock.cnt < 2) break;
			// 2. 1에서 찾은 블록 그룹의 모든 블록을 제거한다. 블록 그룹에 포함된 블록의 수의 제곱만큼 점수를 획득한다.
			removeGroup(maxBlock);
			ans += maxBlock.cnt * maxBlock.cnt;
			// 3. 격자에 중력이 작용한다.
			gravity();
			// 4. 격자가 90도 반시계 방향으로 회전한다.
			rotate();
			// 5. 다시 격자에 중력이 작용한다.
			gravity();
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 크기가 가장 큰 블록 찾기
	public static BlockGroup findMaxGroup() {
		BlockGroup maxGroup = new BlockGroup(0, 0, 0, 0, 0);
		boolean visited[][] = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j] && matrix[i][j] > 0) {
					BlockGroup blockGroup = findGroup(i, j, matrix[i][j], visited);
					if(maxGroup.cnt < blockGroup.cnt) { // 블록의 수가 가장 큰 것
						maxGroup.cnt = blockGroup.cnt;
						maxGroup.rainbowCnt = blockGroup.rainbowCnt;
						maxGroup.color = blockGroup.color;
						maxGroup.x = blockGroup.x; maxGroup.y = blockGroup.y;
					}
					else if(maxGroup.cnt == blockGroup.cnt) { // 블록의 수가 가장 큰 것이 여러 개라면 무지개 블록 수가 가장 큰 것
						if(maxGroup.rainbowCnt < blockGroup.rainbowCnt) {
							maxGroup.rainbowCnt = blockGroup.rainbowCnt;
							maxGroup.color = blockGroup.color;
							maxGroup.x = blockGroup.x; maxGroup.y = blockGroup.y;
						}
						else if(maxGroup.rainbowCnt == blockGroup.rainbowCnt) { // 무지개 블록 수가 가장 큰 것이 여러 개라면 행이 가장 큰 것을 그 것도 여러개이면 열이 가장 큰 것
							if(maxGroup.x < blockGroup.x) {
								maxGroup.color = blockGroup.color;
								maxGroup.x = blockGroup.x; maxGroup.y = blockGroup.y;
							}
							else if(maxGroup.x == blockGroup.x && maxGroup.y < blockGroup.y) {
								maxGroup.color = blockGroup.color;
								maxGroup.y = blockGroup.y;
							}
						}
					}
					initRainbow(visited);
				}
			}
		}
		return maxGroup;
	}
	
	// 블록 그룹 찾기
	public static BlockGroup findGroup(int x, int y, int color, boolean visited[][]) {
		Queue<int[]> q = new ArrayDeque<>();
		int cnt = 1;
		int rainbowCnt = 0;
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int tempx = cur[0] + dx[i];
				int tempy = cur[1] + dy[i];
				if(tempx < 0 || tempx >= N || tempy < 0 || tempy >= N || visited[tempx][tempy]) continue;
				if(matrix[tempx][tempy] == color || matrix[tempx][tempy] == 0) {
					if(matrix[tempx][tempy] == 0) rainbowCnt++;
					cnt++;
					visited[tempx][tempy] = true;
					q.offer(new int[] {tempx, tempy});	
				}
			}
		}
		return new BlockGroup(x, y, color, cnt, rainbowCnt);
	}
	
	// 블록 그룹의 모든 블록 제거
	public static void removeGroup(BlockGroup blockGroup) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean visited[][] = new boolean[N][N];
		q.offer(new int[] {blockGroup.x, blockGroup.y});
		matrix[blockGroup.x][blockGroup.y] = -2;
		visited[blockGroup.x][blockGroup.y] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int tempx = cur[0] + dx[i];
				int tempy = cur[1] + dy[i];
				if(tempx < 0 || tempx >= N || tempy < 0 || tempy >= N || visited[tempx][tempy]) continue;
				visited[tempx][tempy] = true;
				if(matrix[tempx][tempy] == blockGroup.color || matrix[tempx][tempy] == 0) {
					matrix[tempx][tempy] = -2;
					q.offer(new int[] {tempx, tempy});
				}
			}
		}
	}
	
	// 무지개 블록 방문 배열 초기화
	public static void initRainbow(boolean visited[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(matrix[i][j] == 0) visited[i][j] = false;
			}
		}
	}
	
	// 중력 작용
	public static void gravity() {
		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				if(matrix[i][j] < 0) continue;
				int index = i + 1;
				while(index < N && matrix[index][j] == -2) {
					index++;
				}
				if(index - 1 != i) {
					matrix[index - 1][j] = matrix[i][j];
					matrix[i][j] = -2;
				}
			}
		}
	}
	
	// 90도 반시계방향으로 회전
	public static void rotate() {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = matrix[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = temp[j][N - 1 - i];
			}
		}
	}
}
/*
 BFS + 구현 문제
 구현할 때는 문제에서 주어진대로 1에서 5까지 순서대로 작동하도록 함수로 분리하여 구현
 1. 최대 블록그룹 찾을 때 BFS로 블록그룹을 일일이 찾은 후 조건에 맞게 처리함
 2. 마찬가지로 BFS로 블록을 제거하였다.
 3, 4, 5.는 흔히 구현할 수 있는 중력, 배열 회전 함수 구현
 주의할 부분은 무지개블록인데 이는 반복적으로 방문할 수 있다는 조건이 있어 방문 후 다시 false로 초기화하는 initRainbow 함수를 구현
 */
