import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B2504 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int ans = 0;
		
		Stack<String> stack = new Stack<>();
		String s = br.readLine();
		String[] input = s.split("");
		
		for (int i = 0; i < input.length; i++) {
			if(input[i].equals("(") || input[i].equals("[")) {
				stack.push(input[i]);
			}
			else if(input[i].equals(")")) {
				if(stack.peek().equals("(")) {
					stack.pop();
					stack.push("2");
				}
				else if(stack.peek().matches("[-+]?\\d*\\.?\\d+")) {
					int num = Integer.parseInt(stack.pop());
					if(stack.peek().equals("(")) {
						stack.pop();
						stack.push(String.valueOf(num * 2));
					}
				}
				else {
					stack.clear();
					break;
				}
			}
			else if(input[i].equals("]")) {
				if(stack.peek().equals("[")) {
					stack.pop();
					stack.push("3");
				}
				else if(stack.peek().matches("[-+]?\\d*\\.?\\d+")) {
					int num = Integer.parseInt(stack.pop());
					if(stack.peek().equals("[")) {
						stack.pop();
						stack.push(String.valueOf(num * 3));
					}
				}
				else {
					stack.clear();
					break;
				}
			}
			if(stack.size() > 1 && stack.peek().matches("[-+]?\\d*\\.?\\d+")) {
				int num = Integer.parseInt(stack.pop());
				if(stack.peek().matches("[-+]?\\d*\\.?\\d+")) {
					num += Integer.parseInt(stack.pop());
				}
				stack.push(String.valueOf(num));
			}
		}
		
		if(!stack.isEmpty()) ans = Integer.parseInt(stack.pop());
		bw.write(ans + "");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
