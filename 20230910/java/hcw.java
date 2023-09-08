import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[][] arr = new int[201][201];
		int start = 0;
		for(int i =0; i < arr.length; i++) {
			int temp = start;
			for(int j=0; j + i < arr.length; j++) {
				if(j%2 == 0) {
					arr[i][i+j] = temp;
					arr[i+j][i] = temp;
					temp+=1;
				}else {
					arr[i+j][i] = temp;
					arr[i][i+j]= temp;
					temp+=3;
				}
			}
			start+=2;
		}
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int tx = 0 - x1;
			int ty = 0 - y1;
			
			x2 = Math.abs(x2 + tx);
			y2 = Math.abs(y2 + ty);
			x1 = 0;
			y1 = 0;
			
			sb.append("#"+ t + " " +arr[x2][y2] + "\n");
			
		}
		
		System.out.println(sb);
	}
}

18,412 kb
101 ms
