import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String b = br.readLine();

		Stack<Character> stack = new Stack<>();
		int index = 0;

		int b_l = b.length();
		while (index < s.length()) {
			stack.add(s.charAt(index));
			if (stack.size() >= b_l && stack.peek() == b.charAt(b_l - 1)) {
				int temp = 1;
				while (temp <= b_l && stack.get(stack.size() - temp) == b.charAt(b_l - temp)) {
					temp++;
				}
				temp--;
				if (temp == b_l) {
					for (int i = 0; i < temp; i++) {
						stack.pop();
					}
				}
			}
			index++;
    }
		if(stack.isEmpty()) {
			System.out.println("FRULA");
		}else {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i< stack.size(); i++) {
				sb.append(stack.get(i));
			}
			System.out.println(sb);
		}
		

	}
}

87872kb	464ms
