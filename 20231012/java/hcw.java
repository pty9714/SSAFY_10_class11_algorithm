import java.io.*;
import java.util.*;

public class Main{


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long n = Long.parseLong(st.nextToken());
		long k =  Long.parseLong(st.nextToken());
		
		//a번의 가위질로 k개의 색종이 만들 수 있음?
		
		//가로 자르는 횟수
		long start = 0;
		
		long end = n;
		int flag = 0;
		while(start <= end) { //start == end 일때도 해야되는게 mid 가 start(end) 값이어야하기 때문?4 5
			long mid = (start + end) / 2; //mid 구함
			
			if((mid+1) * (n-mid+1) < k) { //현재 색종이 수가 k보다 작다면
				end = mid-1; //end를 낮춘다.
			}else if((mid+1) * (n-mid+1) == k) {
				flag = 1;
				System.out.println("YES");
				break;
			}else {
				start = mid+1;
			}
//			System.out.println(start + " " + mid + " " + end);
		}
		
		
		if(flag == 0) {
			System.out.println("NO");
		}
		
		
		


		
		
	}

}
