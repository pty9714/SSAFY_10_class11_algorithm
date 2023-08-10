import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= testcase; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long N = Integer.parseInt(st.nextToken());
			long A = Integer.parseInt(st.nextToken());
			long B = Integer.parseInt(st.nextToken());

			long min =1000000000;
			
			for(int i = 1; i <= N/2; i++) {
				for(int j =i; j <= N/i; j++) {
					long temp = (long)A * Math.abs(i - j) + B * (N - i * j);
					if(temp < min) {
						min = temp;
					}
				}
			}
			System.out.println("#" + test + " " + (int)min);
		}
	}
}
