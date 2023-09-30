import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = new int[N+1];
		int max = 0;
		for(int i = 0; i < N; i++) {
			if(i + arr[i][0]< N+1) {
				result[i+arr[i][0]] = Math.max(result[i+arr[i][0]], result[i] + arr[i][1]);
			}
			result[i+1] = Math.max(result[i], result[i+1]);
		}
		System.out.println(result[N]);
	}
}

11560ms	76kb
