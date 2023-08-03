import java.io.*;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
	static int result = 0;
	
	static boolean checkQueen(int[][]arr, int count, int i, int N) {
		int left = i-1;
		int right = i+1;

		for(int j = count-1; j >=0; j--) {
			if(left >= 0 && arr[j][left] == 1) {
				return false;
			}
			left -= 1;
			if(right < N && arr[j][right] == 1) {
				return false;
			}
			right +=1;
			
		}
		return true;
	}
	
	
	static void dfs(int count, int N, int[][] arr, int[] visited) {
		if(count == N) {
			result++;
			return;
		}
		for(int i =0 ; i< N; i++) {
			if(arr[count][i] == 0 && visited[i] == 0) {
				if(checkQueen(arr, count, i, N)) {
					visited[i] = 1;
					arr[count][i] = 1;
					 
					dfs(count+1, N, arr, visited);
					visited[i] = 0;
					arr[count][i] = 0;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][N];
		int[] visited = new int[N];
		
		
		dfs(0, N, arr, visited);
		
		
		System.out.println(result);
		
	}
}



// 13572kb	3932ms
