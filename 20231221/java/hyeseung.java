import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

// 11808KB, 80ms
public class B2174 {
	
	// 로봇
	static class Robot {
		int x;
		int y;
		int dir;
		Robot(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	// 명령
	static class Direction { 
		int robot;
		String dir;
		int repeat;
		Direction(int robot, String dir, int repeat) {
			this.robot = robot;
			this.dir = dir;
			this.repeat = repeat;
		}
	}
	
	public static HashMap<Integer, Robot> robots = new HashMap<Integer, Robot>();
	public static int A, B;
	// N, E, S, W 순 (상, 우, 하, 좌)
	public static int[] dx = {0, 1, 0, -1}; 
	public static int[] dy = {-1, 0, 1, 0}; 
	public static int[][] ground;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		ground = new int[B][A];
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// N개의 로봇 정보 입력 받기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = B - Integer.parseInt(st.nextToken());
			int d = -1;
			ground[y][x] = i;
			// 방향 정수화(인덱스)
			switch (st.nextToken()) {
			case "N" : d = 0; break;
			case "E" : d = 1; break;
			case "S" : d = 2; break;
			case "W" : d = 3; break;
			}
			robots.put(i, new Robot(x, y, d));
		}
		
		// M개의 명령 입력받기
		Direction directions[] = new Direction[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int robot = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			int repeat = Integer.parseInt(st.nextToken());
			directions[i] = new Direction(robot, dir, repeat);
		}
		
		String ans = "OK";
		for (Direction direction : directions) { // 명령 실행
			String result = direction(direction.robot, direction.dir, direction.repeat);
			if(!result.equals("safe")) { // 충돌 있는 경우
				ans = result;
				break;
			}
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static String direction(int robot, String d, int repeat) {
		String result = "safe";
		Robot X;
		switch(d) {
		case "L" : // 왼쪽으로 90도 회전
			X = robots.get(robot);
			for (int i = 0; i < repeat; i++) {
				X.dir = X.dir == 0 ? 3 : X.dir - 1;
			}
			break;
		case "R" : // 오른쪽으로 90도 회전
			X = robots.get(robot);
			for (int i = 0; i < repeat; i++) {
				X.dir = (X.dir + 1) % 4;
			}
			break;
		case "F" : // 방향 기준으로 한 칸 움직임
			for (int i = 0; i < repeat; i++) {
				X = robots.get(robot);
				int tempx = X.x + dx[X.dir];
				int tempy = X.y + dy[X.dir];
				// 벽에 충돌하는 경우
				if(tempx < 0 || tempx >= A || tempy < 0 || tempy >= B) {
					result = "Robot " + robot + " crashes into the wall";
					break;					
				}
				// Y번 로봇에 충돌하는 경우
				else if(ground[tempy][tempx] > 0) {
					result = "Robot " + robot + " crashes into robot " + ground[tempy][tempx];
					break;					
				}
				// 충돌하지 않는 경우 로봇 이동
				else {
					ground[X.y][X.x] = 0; 
					ground[tempy][tempx] = robot;
					X.y = tempy; X.x = tempx;
				}
			}
			break;
 		}
		return result;
	}
	
}
/*
 구현 문제
 일반적으로 알고리즘 문제에서 나오는 좌표축이 반대로 되어있음과 y축이 아래에서 시작한다는 점 유의하면 되는 문제
 추가로 입력을 모두 받고 명령을 실행해야하는데 입력받으면서 실행해서 중간에 멈추는 문제가 발생하였음 -> 별도의 클래스를 선언하여 입력 모두 받아옴
*/
