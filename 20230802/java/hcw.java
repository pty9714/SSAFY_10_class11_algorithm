import java.io.*;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Stream;

public class Solution {
	
	
	static int min = 2000000000;
	
	static void dfs(int start, int current, int[][] arr, int[] visited, int count) {
		if(start == current && count != 0) {
			if(min > count) min = count;
//			System.out.println("count : " + count);
			return;
		}else if(min < count) {
			return;
		}else{
         for(int i = 0; i < arr.length; i++ ) {
			if(arr[i][0] == current && visited[i] == 0 ) {
				
//				System.out.println("current " + current);
//				System.out.println("i " + i);
				visited[i] = 1;
				count += arr[i][2];
				dfs(start, arr[i][1] , arr, visited, count);
				count -= arr[i][2];
				visited[i] = 0;
			}
		}   
        }
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in)

		int testcase = Integer.parseInt(br.readLine().trim());
		
		for(int test = 0; test < testcase; test++) {
			int[] temp = Stream.of(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[][] arr = new int[temp[1]][3];
			
			
			for(int i =0 ; i< arr.length; i++) {
				arr[i] = Stream.of(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
//			for(int i = 0; i < temp[1]; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
			
			int[] visited = new int[temp[1]];
			
			
			for(int i = 1; i <= temp[0]; i++) {
//				System.out.println("start " + i);
				dfs(i, i, arr, visited, 0);
			}

			if(min != 2000000000) {
				System.out.println("#"+ (test+1) + " " +min);
			}else {
				System.out.println("#"+ (test+1) + " -1");
			}
        }
	}
}
