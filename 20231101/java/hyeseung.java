import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Stack;

// 11632KB, 76ms
public class B1918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// (,) -> *,/ -> +,- 순 우선순위 HashMap 저장
		HashMap<Character, Integer> priority = new HashMap<>();
		priority.put('(', 1); priority.put(')', 1);
		priority.put('*', 2); priority.put('/', 2);
		priority.put('+', 3); priority.put('-', 3);
		
		String infix = br.readLine(); // 중위 표기식
		Stack<Character> stack = new Stack<>(); // 연산자만 저장하는 스택
		String ans = "";
		
		// 후위 표기식 변환
		for (int i = 0; i < infix.length(); i++) {
			char cur = infix.charAt(i);
			if(priority.containsKey(cur)) { // (, ), *, /, +, - 인 경우
				if(cur == '(') {
					stack.push(cur); 
				}
				else if(cur == ')') { // ( 나올 때까지 pop 하여 ans에 더함
					while(!stack.isEmpty() && stack.peek() != '(') {
						ans += stack.pop();
					}
					stack.pop(); // ( pop
				}
				else { // *, /, +, - 인 경우 Stack 맨위의 값이 현재 연산자 우선순위보다 낮은 것이 나타낼 때가지 pop 하여 ans에 더함
					while(!stack.isEmpty() && stack.peek() != '(' && priority.get(stack.peek()) <= priority.get(cur)) {
						ans += stack.pop();
					}
					stack.push(cur); // 현재 연산자의 우선순위 확실하지 않으므로 push
				}
			}
			else { // 피연산자인 경우 그냥 ans에 더함
				ans += cur;
			}
			
		}
		
		// 남은 연산자 pop 하여 ans에 더함
		while(!stack.isEmpty()) ans += stack.pop();
		
		// 결과 출력
		bw.write(ans);
		bw.flush();
		bw.close();
		br.close();	
	}

}
