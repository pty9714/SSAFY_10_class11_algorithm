import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][3];
		
		for(int i =0; i< N; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		int[][] result1 = new int[N][3];
		int[][] result2 = new int[N][3];
		int[][] result3 = new int[N][3];
		
		
		
		result1[1][0] = Math.min(arr[0][1], arr[0][2]) + arr[1][0];
		result1[1][1] = arr[0][2] +  arr[1][1];
		result1[1][2] = arr[0][1] + arr[1][2];  
		
		
		result2[1][0] = arr[0][2] + arr[1][0];
		result2[1][1] = Math.min(arr[0][0], arr[0][2]) +  arr[1][1];
		result2[1][2] = arr[0][0] +  arr[1][2];
		
		
		result3[1][0] = arr[0][1]+ arr[1][0];;
		result3[1][1] = arr[0][0] +  arr[1][1];
		result3[1][2] = Math.min(arr[0][0], arr[0][1]) + arr[1][2];
		
		
		for(int i = 2; i < N; i++) {
			result1[i][0] = Math.min(result1[i-1][1], result1[i-1][2]) + arr[i][0];
			result1[i][1] = Math.min(result1[i-1][0], result1[i-1][2])+ arr[i][1];
			result1[i][2] = Math.min(result1[i-1][0], result1[i-1][1]) + arr[i][2];
			
			
			result2[i][0] = Math.min(result2[i-1][1], result2[i-1][2]) + arr[i][0];
			result2[i][1] = Math.min(result2[i-1][0], result2[i-1][2])+ arr[i][1];
			result2[i][2] = Math.min(result2[i-1][0], result2[i-1][1]) + arr[i][2];
			
			result3[i][0] = Math.min(result3[i-1][1], result3[i-1][2]) + arr[i][0];
			result3[i][1] = Math.min(result3[i-1][0], result3[i-1][2])+ arr[i][1];
			result3[i][2] = Math.min(result3[i-1][0], result3[i-1][1]) + arr[i][2];
		}
		
		int result = Math.min(Math.min(result1[N-1][0], result2[N-1][1]), result3[N-1][2]);
		
		System.out.println(result);
		
	}
}
