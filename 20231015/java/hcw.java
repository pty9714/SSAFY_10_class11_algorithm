import java.io.*;
import java.util.*;

public class Main {

//6
//10
//3
//7
//4
//12
//2
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> s = new Stack<>();
		long answer = 0;
		for(int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			while(!s.isEmpty() && s.peek() <= temp) {
				s.pop();
			}
			s.add(temp);
			answer += s.size()-1;
//			System.out.println(s);
		}

		
		System.out.println(answer);
		
		
		
		
	}

}

300ms
