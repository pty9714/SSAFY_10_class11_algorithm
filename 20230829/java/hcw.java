import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int result = 0;
		int i = 0;
		
		//2의 승수 구함
		while(Math.pow(2, i) < N) { i++;}
		i--;
		
		Stack<Integer> s = new Stack<>();
		
		//리스트에 넣어준다.
		while(N != 0) {
			//N이 2^i 보다 같거나 크다면 list에 넣어주고 N에서 빼준다.
			if(N >= Math.pow(2, i)) {
				s.add((int) Math.pow(2,  i));
				N -= Math.pow(2,  i);
			}
			//i(2의 승수) 내리는 중
			if(i > 0) {
				i--;
			}
		}
		
		System.out.println(s);

		if(K >= s.size()) { //K가 s보다 크면
			System.out.println(0);
		}else {
			while(s.size() > K) { //답이 나오는 사이즈까지
				int a = s.pop();
				int b = s.pop();
				
				result += b - a; //뒤에 두개 차를 결과에 더해준다.
				s.add(2 * b); //b * 2를 stack에 넣어준다.
				
				System.out.println(s);
			}
			System.out.println(result);
		}

		
			
		
	}
	
}

11544kb	76ms
