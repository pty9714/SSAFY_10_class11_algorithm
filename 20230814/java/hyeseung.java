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
	    	if(stack.isEmpty() || input[i].equals("(") || input[i].equals("[")) {
	            stack.push(input[i]);
	        }
	        else if(input[i].equals(")")) {
	        	int num = 0, cnt = 0;
	        	// 숫자 나올 동안 더하기 (XY)
	        	while(!stack.isEmpty() && stack.peek().matches("[-+]?\\d*\\.?\\d+")) {
	        		num += Integer.parseInt(stack.pop());
	        		cnt++;
	        	}
	        	// 닫힌 괄호 나오면 () 값은 2
	            if(!stack.isEmpty() && stack.peek().equals("(")) {
	                stack.pop();
	                if(cnt == 0) num = 2; // 숫자 없을 경우
	                else num *= 2;
	                stack.push(String.valueOf(num));
	            }
	            // 닫힌 괄호 안나오면 올바르지 못한 괄호열
	            else {
	                stack.clear();
	                break;
	            }
	        }
	        else if(input[i].equals("]")) {
	        	int num = 0, cnt = 0;
	        	// 숫자 나올 동안 더하기 (XY)
	        	while(!stack.isEmpty() && stack.peek().matches("[-+]?\\d*\\.?\\d+")) {
	        		num += Integer.parseInt(stack.pop());
	        		cnt++;
	        	}
	        	// 닫힌 괄호 나오면 () 값은 3
	            if(!stack.isEmpty() && stack.peek().equals("[")) {
	                stack.pop();
	                if(cnt == 0) num = 3; // 숫자 없을 경우
	                else num *= 3;
	                stack.push(String.valueOf(num));
	            }
	            // 닫힌 괄호 안나오면 올바르지 못한 괄호열
	            else {
	                stack.clear();
	                break;
	            }
	        }
	    }
	    
	    // 스택에 남은 숫자 모두 더하기
	    while(!stack.isEmpty()) {
	    	if(stack.peek().matches("[-+]?\\d*\\.?\\d+")) {
	    		ans += Integer.parseInt(stack.pop());
	    	}
	    	// 스택에 남은 것이 숫자가 아니면 올바르지 못한 괄호열
	    	else {
	    		ans = 0;
	    		break;
	    	}
	    }
	    
	    // 결과 출력
	    bw.write(ans + "");
	    
	    bw.flush();
	    bw.close();
	    br.close();
	}
}
// 11800KB,	84ms
