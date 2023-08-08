import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int count = 0;
		int[] blocks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int arr[][] = new int[h][w];
		for(int i =0 ;i < blocks.length; i++) {
			for(int j =h-1 ; j > h - 1 -blocks[i]; j--) { //벽 세우기
				arr[j][i]= 2;
			}
			
			for(int j = h-1-blocks[i]; j >= 0; j-- ) { //빗물 채우기
				arr[j][i] = 1;
				count ++;
			}
		}
		int left_block = blocks[0];
		int right_block = blocks[blocks.length-1];
		
		for(int i =0 ; i< h - left_block; i++) {//왼쪽 블록 기준으로 빗물 제거
			for(int j = 0; j< arr[0].length; j++) {
				if(arr[i][j] == 1) {
					count--;
				}else {
					break;
				}
			}
		}
		
		for(int i =0 ; i < h-right_block; i++) { //오른쪽 블록 기준으로 빗물 제거
			for(int j = arr[0].length-1 ; j >=0; j--) {
				if(arr[i][j] == 1) {
					count--;
				}else {
					break;
				}
			}
		}
		
		System.out.println(count);
	}
}
