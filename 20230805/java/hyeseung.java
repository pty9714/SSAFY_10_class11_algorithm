import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B21608 {
	
	public static int N, seat[][];
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    // N 입력 받기
	    N = Integer.parseInt(br.readLine());
	    
	    int ans = 0;
	    seat = new int[N][N];
	    int table[][] = new int[N * N + 1][4];
	    
	    for(int i = 0; i < N * N; i++) {
	        st = new StringTokenizer(br.readLine());
	        // 학생의 번호와 그 학생이 좋아하는 4명의 학생 번호 입력 받기
	        int num = Integer.parseInt(st.nextToken());
	        int max = 0, maxX = 0, maxY = 0;
	        for(int j = 0; j < 4; j++) {
	            table[num][j] = Integer.parseInt(st.nextToken());
	        }
	        // 자리 배치
	        for(int x = 0; x < N; x++) {
            	for(int y = 0; y < N; y++) {
            		if(seat[x][y] == 0) {
            			// 1. 비어있는 칸 중 좋아하는 학생이 인접한 칸에 가장 많은 칸 자리 정하기
            			int near = near(x, y, table[num]);
            			if(max < near) {
            				maxX = x; maxY = y; max = near;
            			}
            			// 2. 1 만족하는 칸이 여러 개면 인접 칸 중에서 비어있는 칸이 가장 많은 칸을 정하거나,
            			// 3. 2 만족하는 칸도 여러 개면 행의 번호 -> 열 번호 작은 순으로 자리 정하기
            			else if(max == near && near(maxX, maxY) < near(x, y)) {
            				maxX = x; maxY = y;
            			}
            		}
            	}
            }
	        seat[maxX][maxY] = num;
	    }
	    
	    for(int[] i : seat) {
	    	for(int j : i) {
	    		System.out.print(j + " ");
	    	}
	    	System.out.println();
	    }
	    
	    // 만족도 조사 
	    for(int i = 0; i < N; i++) {
	    	for(int j = 0; j < N; j++) {
	    		// 인접한 칸에 앉은 좋아하는 학생 수 구하기
	    		int like = near(i, j, table[seat[i][j]]);
	    		// 0이면 만족도 0, 그 이후 1부터 10배씩 증가
	    		if(like != 0) ans += Math.pow(10, like - 1);	
	    	}
	    }
	    // 결과 출력
	    bw.write(ans + "");
	    bw.close();
	}
	// 인접 칸 중 좋아하는 학생 수 세기
	public static int near(int x, int y, int[] kan) {
		int near = 0;
		for(int i = 0; i < 4; i++) {
			int tmpx = x + dx[i];
			int tmpy = y + dy[i];
			if(tmpx < 0 || tmpx >= N || tmpy < 0 || tmpy >= N) continue;
			for(int k : kan) {
				if(seat[tmpx][tmpy] == k) {
					near++;
					break;
				}
			}
		}		
		
		return near;
	}
	// 인접 칸 중 비어있는 칸 세기
	public static int near(int x, int y) {
		int near = 0;
		
		for(int i = 0; i < 4; i++) {
			int tmpx = x + dx[i];
			int tmpy = y + dy[i];
			if(tmpx < 0 || tmpx >= N || tmpy < 0 || tmpy >= N) continue;
			if(seat[tmpx][tmpy] == 0) near++;
		}		
		
		return near;
	}
}