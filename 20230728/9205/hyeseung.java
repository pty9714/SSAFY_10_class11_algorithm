import java.io.*;
import java.util.*;
import java.awt.Point;

class Main {

	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 0; test_case < T; test_case++) {
		    // N, matrix, map 초기화
			int N = Integer.parseInt(br.readLine());
			int[][] matrix = new int[N + 2][2];
			
			// 집, 편의점, 펜타포트 락 좌표 입력 받기, map 초기화
			for(int i = 0; i < N + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				matrix[i][0] = Integer.parseInt(st.nextToken());
				matrix[i][1] = Integer.parseInt(st.nextToken()); 
			}
			
			// bfs 실행 결과 출력
			System.out.println(bfs(matrix, N));
		}
	}
	
	public static String bfs(int[][] matrix, int N) {
	    Queue<Integer> q = new LinkedList<>();
	    boolean [] visited = new boolean[N + 2];
        visited[0] = true;
	    q.add(0);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            // 도착했을 경우 결과 리턴
            if(cur == N + 1) return "happy";
            for(int i = 0; i < N + 2; i++) {
                int dis = Math.abs(matrix[i][0] - matrix[cur][0]) + Math.abs(matrix[i][1] - matrix[cur][1]);
                if(visited[i] || dis > 1000) continue;
                visited[i] = true;
                q.add(i);
            }
        }
        // 도착하지 못했을 경우 결과 리턴
        return "sad";
	}
	
}