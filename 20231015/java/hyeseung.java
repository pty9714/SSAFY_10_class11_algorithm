import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B6198 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		long ans = 0;
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			while(!stack.isEmpty() && stack.peek() <= num) {
				stack.pop();
			}
			stack.push(num);
			ans += stack.size() - 1;
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}