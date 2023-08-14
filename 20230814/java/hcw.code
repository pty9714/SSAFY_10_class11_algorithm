import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("");

		int[] depth = new int[30];
		Stack<String> s = new Stack<String>();
		
		boolean flag = true;
		int sum = 0;
		int d = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("(")) {
				s.add("(");
				d++;
			} else if (arr[i].equals(")")) {
				if (!s.empty() && s.peek().equals("(")) {
					s.pop();
					d--;
					if (depth[d + 1] == 0) {
						depth[d] += 2;
					} else {
						depth[d] += (depth[d + 1] * 2);
						depth[d+1] = 0;
					}
				} else {
					flag = false;
					break;
				}
			} else if (arr[i].equals("[")) {
				s.add("[");
				d++;
			} else if (arr[i].equals("]")) {
				if (!s.empty() && s.peek().equals("[")) {
					s.pop();
					d--;
					if (depth[d + 1] == 0) {
						depth[d] += 3;
					} else {
						depth[d] += (depth[d + 1] * 3);
						depth[d+1] = 0;
					}
				} else {
					flag = false;
					break;
				}
			}
			if (s.empty()) {
				sum += depth[0];
				depth = new int[30];
			}
		}

		System.out.println(flag && s.empty() ? sum : 0);

	}
}

	11664kb	80ms
