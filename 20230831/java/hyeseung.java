import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 20052KB, 168ms
class Fish implements Comparable<Fish> {
	int x;
	int y;
	int dist;
	public Fish(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
	@Override
	public int compareTo(Fish o) {
		// 거리가 같은 물고기
		if(this.dist == o.dist) {
			// 1. 가장 왼쪽
			if(this.x == o.x) {
				return this.y - o.y;
			}
			// 2. 가장 위쪽
			else {
				return this.x - o.x;
			}
		}
		// 거리가 다른 물고기는 가까운 순
		return this.dist - o.dist;
	}
}

public class Main {

	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	public static int startX, startY, ans, size, N, map[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		ans = 0; size = 2; // 아기 상어 초기 크기 2
		startX = 0; startY = 0; // 이동 시작 위치
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) { // 아기 상어 초기 위치
					startX = i;
					startY = j;
				}
			}
		}

		bfs(); // 아기 상어가 먹을 수 있는 물고기 탐색하면서 bfs 수행
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

	private static void bfs() {
		int cnt = 0; // 먹은 물고기
		boolean visited[][];
		Queue<Fish> q = new ArrayDeque<Fish>();
		PriorityQueue<Fish> eatList = new PriorityQueue<>(); // 먹을 물고기
		while(true) {
			// 초기화
			q.clear();
			eatList.clear();
			visited = new boolean[N][N];
			visited[startX][startY] = true;
			map[startX][startY] = 0;
			q.offer(new Fish(startX, startY, 0));
			// 먹을 물고기 탐색
			while(!q.isEmpty()) {
				Fish fish = q.poll();
				for (int i = 0; i < 4; i++) {
					int tempx = fish.x + dx[i];
					int tempy = fish.y + dy[i];
					if(tempx < 0 || tempx >= N || tempy < 0 || tempy >= N || visited[tempx][tempy]) continue;
					visited[tempx][tempy] = true;
					// 이동 가능한 경우
					if(map[tempx][tempy] <= size) {
						// 먹을 수 있는 경우
						if(map[tempx][tempy] != 0 && map[tempx][tempy] < size) {
							eatList.offer(new Fish(tempx, tempy, fish.dist + 1));
						}
						q.offer(new Fish(tempx, tempy, fish.dist + 1));
					}
				}
			}
			// 먹을 물고기가 있는 경우
			if(!eatList.isEmpty()) {
				Fish eatFish = eatList.poll(); // 가장 왼쪽, 가장 위, 가장 최소 이동 거리 물고기
				ans += eatFish.dist; 
				if(++cnt == size) { // 아기 상어 크기와 먹은 물고기 개수가 같으면 크기 1 증가
					size++;
					cnt = 0;
				}
				startX = eatFish.x;
				startY = eatFish.y;
			}
			// 먹을 물고기가 없는 경우 종료
			else break;
		}
	}	
}
