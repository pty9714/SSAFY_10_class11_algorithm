import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B6198 {
	
	static class Building {
		int number;
		int cnt;
		public Building(int number, int cnt) {
			this.number = number;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		Stack<Integer> leftStack = new Stack<>();
		Stack<Building> rightStack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			leftStack.push(Integer.parseInt(br.readLine()));
		}
		while(!leftStack.isEmpty()) {
			int cnt = 0;
			if(rightStack.isEmpty()) {
				rightStack.push(new Building(leftStack.pop(), 0));
			}
			else {
				while(!rightStack.isEmpty() && leftStack.peek() > rightStack.peek().number) {
					if(rightStack.peek().cnt != 0) {
						cnt += rightStack.peek().cnt;
					}
					else {
						cnt++;
						rightStack.pop();
					}
				}
				rightStack.push(new Building(leftStack.pop(), cnt));
			}
			ans += cnt;
			//System.out.println(ans);
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
